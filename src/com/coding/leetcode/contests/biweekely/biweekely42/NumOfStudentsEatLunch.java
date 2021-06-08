package com.coding.leetcode.contests.biweekely.biweekely42;

public class NumOfStudentsEatLunch {

    public static void main( String[] args ) {
        int[] students = {1, 1, 1, 0, 0, 1};
        int[] sandwiches = {1, 0, 0, 0, 1, 1};

        System.out.println(countStudents(students, sandwiches));

        //easier approach: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/discuss/987708/JAVA-Beginner-Friendly-Solution-Time-O(N)-Space-O(1)
    }

    //done bt me, with little help :)
    //Runtime: 1 ms
    //Memory Usage: 38.9 MB
    private static int countStudents( int[] students, int[] sandwiches ) {
        int j = 0, count = 0, len = students.length;

        //Loop until Sandwiches are finished and students doesn't want opposite sandwich
        for (int i = 0; j < sandwiches.length && count != len; ) {

            //if student at front can eat the sandwich at top
            if (students[i] != -1 && students[i] == sandwiches[j]) {
                j++;

                students[i] = -1;
                len--;

                //resetting the count
                count = 0;

            } else if (students[i] != -1 && students[i] != sandwiches[j]) {
                count++; //counting total of non eaten students
            }

            i++;
            i = i % students.length;
        }

        return len;
    }
}
