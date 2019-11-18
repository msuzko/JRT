package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit() {
        double total = 0;
        for (Map.Entry<Date,Double> entry: StatisticManager.getInstance().getProfit().entrySet()) {
            double amount = entry.getValue();
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"%s - %.2f", simpleDateFormat.format(entry.getKey()), amount));
            total+=amount;
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH,"Total - %.2f", total));
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> map = StatisticManager.getInstance().getCookTime();
        for (Map.Entry<Date, Map<String, Integer>> entry : map.entrySet()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            String date = simpleDateFormat.format(entry.getKey());
            ConsoleHelper.writeMessage(date);
            Map<String, Integer> map1 = entry.getValue();
            for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
                if (entry1.getValue() > 0) {
                    ConsoleHelper.writeMessage(entry1.getKey() + " - " + entry1.getValue() + " min");
                }
            }
        }

    }

    public void printActiveVideoSet() {
        for (Map.Entry<String,Integer> entry : StatisticAdvertisementManager.getInstance().getActiveVideos().entrySet())
            ConsoleHelper.writeMessage(entry.getKey()+ " - " + entry.getValue());

    }

    public void printArchivedVideoSet() {
        for (Advertisement ad : StatisticAdvertisementManager.getInstance().getArchivedVideos())
            ConsoleHelper.writeMessage(ad.getName());
    }

}
