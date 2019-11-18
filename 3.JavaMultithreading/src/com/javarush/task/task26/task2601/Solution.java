package com.javarush.task.task26.task2601;

<<<<<<< HEAD
import java.util.*;

/*
=======
/* 
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
<<<<<<< HEAD
//        Integer[] array = sort(new Integer[]{13, 8, 5, 17});
//        for (int i :
//                array) {
//            System.out.println(i);
//        }
    }

    public static Integer[] sort(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        Arrays.sort(array);

        int len = array.length;
        int median = len % 2 != 0 ? array[len / 2] : ((array[len / 2] + array[len / 2 - 1]) / 2);
        //System.out.println(median);
        Comparator<Integer> comparator = (o1, o2) -> Math.abs(o1 - median) - Math.abs(o2 - median);
        Collections.sort(list,comparator);
        array = (Integer[]) list.toArray();
        return array;
    }

    private static class Com implements Comparable<Com>{
        private int razn;
        private int val;

        public Com(int razn, int val) {
            this.razn = razn;
            this.val = val;
        }

        @Override
        public int compareTo(Com o) {
            return this.razn-o.razn;
        }
    }

=======

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        return array;
    }
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
}
