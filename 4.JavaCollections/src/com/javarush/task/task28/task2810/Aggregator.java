package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;

public class Aggregator {
    //maven -> org.jsoup:jsoup
    public static void main(String[] args) {
        View view = new HtmlView();
        try {
            Model model = new Model(view, new Provider(new HHStrategy()), new Provider(new MoikrugStrategy()));
            Controller controller = new Controller(model);
            view.setController(controller);
            view.userCitySelectEmulationMethod();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
