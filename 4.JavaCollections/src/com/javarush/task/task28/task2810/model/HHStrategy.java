package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sun.activation.registries.LogSupport.log;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int page = 0;
        while (true) {
            try {
                Document doc = getDocument(searchString,page);
                Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size() == 0)
                    break;
                for (Element element : elements)
                    if (element != null) {
                        Vacancy vacancy = fillVacancy(element);
                        vacancies.add(vacancy);
                    }
                log(doc.title());
            } catch (IOException e) {
                e.printStackTrace();
            }
            page++;
        }
        return vacancies;
    }

    private Vacancy fillVacancy(Element element) {
        Vacancy vacancy = new Vacancy();
        vacancy.setTitle(element.getElementsByAttributeValueContaining("data-qa", "title").text());
        vacancy.setCity(element.getElementsByAttributeValueContaining("data-qa", "address").text());
        vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
        vacancy.setUrl(element.getElementsByAttributeValueContaining("data-qa", "title").attr("href"));
        vacancy.setSalary(element.getElementsByAttributeValueContaining("data-qa", "compensation").text());
        vacancy.setSiteName(URL_FORMAT);
        return vacancy;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.87 Safari/537.36")
                .referrer("").get();
    }
}
