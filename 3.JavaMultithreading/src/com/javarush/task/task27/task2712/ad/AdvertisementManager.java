package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        List<Advertisement> availableVideos = new ArrayList<>();
        for (Advertisement advertisement : storage.list()) {
            if (advertisement.getHits() > 0) {
                availableVideos.add(advertisement);
            }

        }
        List<Advertisement> bestVideos = new ArrayList<>();
        chooseAdvertisement(availableVideos, bestVideos, timeSeconds);

        int timeLeft = timeSeconds;
        for (Advertisement advertisement : bestVideos) {
            if (timeLeft < advertisement.getDuration()) {
                continue;
            }

            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());

            timeLeft -= advertisement.getDuration();
            advertisement.revalidate();
        }

        if (timeLeft == timeSeconds) {
            throw new NoVideoAvailableException();
        }
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(bestVideos,
                bestVideos.stream().mapToLong(Advertisement::getAmountPerOneDisplaying).sum(),
                bestVideos.stream().mapToInt(Advertisement::getDuration).sum())
        );

    }

    private void chooseAdvertisement(List<Advertisement> availableVideos, List<Advertisement> bestVideos, int time) {
        if (availableVideos.isEmpty()) {
            return;
        }
        Advertisement chooseAdvertisement;

        Advertisement maxAmountVideo = Collections.max(availableVideos, Comparator.comparing(Advertisement::getAmountPerOneDisplaying));

        List<Advertisement> advertisementsAmount = availableVideos.stream()
                .filter(advertisement -> advertisement.getAmountPerOneDisplaying() == maxAmountVideo.getAmountPerOneDisplaying())
                .collect(Collectors.toList());
        if (advertisementsAmount.size() > 1) {
            Advertisement advertisementDuration = Collections.max(advertisementsAmount, Comparator.comparing(Advertisement::getDuration));
            List<Advertisement> advertisementsDuration = advertisementsAmount.stream()
                    .filter(advertisement -> advertisement.getDuration() == advertisementDuration.getDuration())
                    .collect(Collectors.toList());
            if (advertisementsDuration.size() > 1) {
                chooseAdvertisement = Collections.max(advertisementsDuration, Comparator.comparing(Advertisement::getHits));
            } else {
                chooseAdvertisement = advertisementDuration;
            }
        } else {
            chooseAdvertisement = maxAmountVideo;
        }
        availableVideos.remove(chooseAdvertisement);
        if (time >= chooseAdvertisement.getDuration()) {
            bestVideos.add(chooseAdvertisement);
            time -= chooseAdvertisement.getDuration();
        }
        chooseAdvertisement(availableVideos, bestVideos, time);
    }
}
