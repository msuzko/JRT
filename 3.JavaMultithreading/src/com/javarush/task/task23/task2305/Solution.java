package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
<<<<<<< HEAD
        Solution[] solutions = new Solution[2];
        solutions[0] = createSolution();;
        solutions[1] = createSolution();;
        return solutions;
    }

    private static Solution createSolution() {
        Solution solution = new Solution();
        solution.innerClasses[0] = solution.new InnerClass();
        solution.innerClasses[1] = solution.new InnerClass();
        return solution;
    }

    public static void main(String[] args) {
        for (Solution solution :getTwoSolutions()) {
            System.out.print("Sol: " + solution+"   {");
            for (InnerClass innerClass: solution.innerClasses){
                System.out.print(innerClass+";");
            }
            System.out.println("}");
        }
=======
        Solution sol1 = new Solution();
        sol1.innerClasses[0] = sol1.new InnerClass();
        sol1.innerClasses[1] = sol1.new InnerClass();
        Solution sol2 = new Solution();
        sol2.innerClasses[0] = sol2.new InnerClass();
        sol2.innerClasses[1] = sol2.new InnerClass();
        return new Solution[]{sol1,sol2};
    }

    public static void main(String[] args) {

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    }
}
