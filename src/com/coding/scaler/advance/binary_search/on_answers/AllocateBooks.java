package com.coding.scaler.advance.binary_search.on_answers;

public class AllocateBooks {

    /**
     * Given an array of integers A of size N and an integer B.
     *
     * The College library has N books. The ith book has A[i] number of pages.
     *
     * You have to allocate books to B number of students so that the maximum number
     * of pages allocated to a student is minimum.
     *
     * Calculate and return that minimum possible number.
     *
     * NOTE: Return -1 if a valid assignment is not possible.
     *
     * Input 1:
     * A = [12, 34, 67, 90]
     * B = 2
     *
     * Output 1:
     * 113
     *
     * There are two students. Books can be distributed in following fashion :
     * 1)  [12] and [34, 67, 90]
     *     Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
     * 2)  [12, 34] and [67, 90]
     *     Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
     * 3)  [12, 34, 67] and [90]
     *     Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
     *     Of the 3 cases, Option 3 has the minimum pages = 113.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(books(new int[] {12, 34, 67, 90}, 2));
    }

    //logic is same as Painter Partition, just we don't have time factor here.
    private static int books(int[] A, int B) {

        int n = A.length;
        if(n < B) {
            return -1;
        }

        long sum=0, max = Integer.MIN_VALUE;
        for(int item: A) {
            sum += item;
            max = Math.max(max, item);
        }

        long l = max, r = sum, ans = 0; //r = all the book allocate to a student

        while (l <= r) {
            long mid = l + (r-l) / 2; //min distance between 2 cows

            //bcz we need to minimize the max distance same as Painter Partition.
            if(isPossible(mid, A, B)) {
                ans = mid;
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }

        return (int)ans;
    }

    //This logic same as Painter Partition (Allocate Min/At-least M pages to the B students)
    public static boolean isPossible(long m, int[] A, int B) {
        int studentCount = 1, n = A.length;
        long noOfPages = 0;

        //allocate as much as M pages to students until it less than B students.
        for(int i = 0; i < n; i++) {
            noOfPages = noOfPages + A[i];

            if(noOfPages > m) {
                studentCount++;
                noOfPages = A[i];

                if(studentCount > B) {
                    return false;
                }
            }
        }

        return true;
    }
}
