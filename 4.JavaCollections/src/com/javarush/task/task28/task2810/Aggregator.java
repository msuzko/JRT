package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;

public class Aggregator {
    //maven -> org.jsoup:jsoup
    public static void main(String[] args) {
        View view = new HtmlView();
        try {
            Model model = new Model(view, new Provider(new HHStrategy()));
            Controller controller = new Controller(model);
            view.setController(controller);
            view.userCitySelectEmulationMethod();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
