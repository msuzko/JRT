package com.javarush.task.task21.task2105;

import java.util.HashSet;
<<<<<<< HEAD
=======
import java.util.Objects;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

<<<<<<< HEAD
    public boolean equals(Object o) {
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return n.first.equals(first) && n.last.equals(last);
=======
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return Objects.equals(first, solution.first) &&
                Objects.equals(last, solution.last);
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
=======
        return Objects.hash(first, last);
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
