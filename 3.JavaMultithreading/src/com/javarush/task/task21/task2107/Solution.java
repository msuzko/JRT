package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
<<<<<<< HEAD
=======
import java.util.Objects;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

/* 
Глубокое клонирование карты
*/
<<<<<<< HEAD
public class Solution {
=======
public class Solution implements Cloneable{
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
<<<<<<< HEAD
        Solution clone = null;
=======
        Solution clone;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);
<<<<<<< HEAD
=======
            //System.out.println(clone.equals(solution));
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
<<<<<<< HEAD
    protected Solution clone() throws CloneNotSupportedException {
        Solution sl = new Solution();
        sl.users = new LinkedHashMap<>();
        for (Map.Entry<String, User> entry :
                users.entrySet()) {
            sl.users.put(entry.getKey(),(User) entry.getValue().clone());
        }
        return sl;
=======
    public Solution clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        for (Map.Entry<String,User> entry:
             users.entrySet()) {
            solution.users.put(entry.getKey(),entry.getValue());
        }
        return solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(users, solution.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

<<<<<<< HEAD
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;

        }

=======
        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            return new User(age,name);
        }
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
}
