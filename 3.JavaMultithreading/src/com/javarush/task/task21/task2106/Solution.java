package com.javarush.task.task21.task2106;

import java.util.Date;
<<<<<<< HEAD
import java.util.HashSet;
import java.util.Set;
=======
import java.util.Objects;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
<<<<<<< HEAD
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date == null) return false;
        if (solution != null ? !this.solution.equals(solution1.solution) : solution1.solution == null) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string == null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        Date date = new Date();
        Solution sl =new Solution(1,"a",3.14, date,null);
        s.add(new Solution(1,"a",3.14, date,sl));
        System.out.println(s.contains(new Solution(1,"a",3.14, date,sl)));
=======
        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof Solution)) return false;
        Solution solution1 = (Solution) o;
        return anInt == solution1.anInt &&
                Double.compare(solution1.aDouble, aDouble) == 0 &&
                Objects.equals(string, solution1.string) &&
                Objects.equals(date, solution1.date) &&
                Objects.equals(solution, solution1.solution);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Solution)) return false;
//
//        Solution solution1 = (Solution) o;
//
//        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
//        if (anInt != solution1.anInt) return false;
//        if (date != null ? !date.equals(solution1.date) : solution1.date == null) return false;
//        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null) return false;
//        if (string != null ? !string.equals(solution1.string) : solution1.string == null) return false;
//
//        return true;
//    }

//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = anInt;
//        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + (solution != null ? solution.hashCode() : 0);
//        return result;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt, string, aDouble, date, solution);
    }

    public static void main(String[] args) {

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
}
