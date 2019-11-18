package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

<<<<<<< HEAD
    public static class Plant {
=======
    public static class Plant{
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
<<<<<<< HEAD

    }

    public static class Tree extends Plant {
=======
    }

    public static class Tree extends Plant implements Cloneable{
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        @Override
<<<<<<< HEAD
        public Tree clone() throws CloneNotSupportedException {

            return new Tree(getName(), getBranches().clone());

=======
        protected Tree clone() throws CloneNotSupportedException {
            Tree tree = new Tree(getName(),new String[branches.length]);
            for(int i=0;i<branches.length;i++)
                tree.branches[i]=branches[i];
            return tree;
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
        }

        public String[] getBranches() {
            return branches;
        }
    }
}
