package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDbSelectExecutor<T extends NamedItem> {

    public abstract String getQuery();

    /**
     * This is a fake method
     *
     * @return a list of 5 fake items
     */
    public List<T> execute() {
        List<T> result = new ArrayList<>();
        //check that the query is not null
        String query = getQuery();
        if (query == null) return result;

        try {
            //generate 5 fake items
            for (int i = 1; i <= 5; i++) {
                T newItem = getNewInstanceOfGenericType();
                newItem.setId(i);
                newItem.setName(newItem.getClass().getSimpleName() + "-" + i);
                newItem.setDescription("Received from executing '" + query + "'");
                result.add(newItem);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    //reflection
    //you need to know that it is possible to create a new instance of the T (generic type) class using its default constructor
<<<<<<< HEAD
    private T getNewInstanceOfGenericType() throws InstantiationException, IllegalAccessException {
=======
    public  T getNewInstanceOfGenericType() throws InstantiationException, IllegalAccessException {
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        return (T) ((Class) ((ParameterizedType) this.getClass().
                getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
    }
}
