package com.javarush.task.task27.task2712.ad;

import java.util.*;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance;
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null)
            synchronized (StatisticAdvertisementManager.class) {
                if (instance == null)
                    instance = new StatisticAdvertisementManager();
            }
        return instance;
    }

    public Map<String, Integer> getActiveVideos() {
        Map<String, Integer> activeVideos = new TreeMap<>();
        for (Advertisement ad : storage.list())
            if (ad.getHits() > 0) {
                activeVideos.put(ad.getName(), ad.getHits());
            }
        return activeVideos;
    }

    public List<Advertisement> getArchivedVideos() {
        List<Advertisement> archivedVideos = new ArrayList<>();
        for (Advertisement ad : storage.list())
            if (ad.getHits() == 0) {
                archivedVideos.add(ad);
            }
        Collections.sort(archivedVideos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return archivedVideos;
    }
}
