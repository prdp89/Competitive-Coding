package com.coding.scaler.arrays.carry_forward

class LeadersInAnArray {

    /**
     * Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
     * An element is a leader if it is strictly greater than all the elements to its right side.

    Example Input

    A = [16, 17, 4, 3, 5, 2]
    Example Output

    [17, 2, 5]
     */
    companion object {
        fun solve(A: IntArray): IntArray {
            val arr = mutableListOf<Int>()
            var tempLeader = A[A.size - 1]
            var index = 0
            arr.add(index++, A[A.size - 1])

            for (i in A.size - 2 downTo 0) {
                if(A[i] > tempLeader) {
                    arr.add(index++, A[i])
                    tempLeader = A[i]
                }
            }

            return arr.toIntArray()
        }
    }
}

fun main() {
   LeadersInAnArray.solve(intArrayOf(16, 17, 4, 3, 5, 2)).forEach {
       print(it)
   }
}