package com.coding.leetcode.contests.weekely.weekely236;

public class MinSideWaysJump {

    //https://leetcode.com/contest/weekly-contest-236/problems/minimum-sideway-jumps/
    public static void main( String[] args ) {
        int[] obstacles = {0, 1, 2, 3, 0};
        System.out.println(minSideJumps(obstacles));
    }

    //https://leetcode.com/problems/minimum-sideway-jumps/
    //TIme: 35 ms
    private static int minSideJumps( int[] obstacles ) {
        int[] jumps = new int[]{1, 0, 1};
        for (int obstacle : obstacles) { /* obstacle array also represents length of lanes */
            if (obstacle > 0) { /* if obstacle found */
                jumps[obstacle - 1] = 1000000; /* Set jump to very large number. */
            }
            for (int currentLane = 0; currentLane < 3; ++currentLane) { /* for each lane calculate jumps */
                if (obstacle != currentLane + 1) { /* if current lane doesn't have obstacle */
                    /* From a lane frog can jump to two lanes
                     * +1 for next lane and +2 for next to next lane
                     * If currentLane +1 or +2 > 3 then module by 3 will give correct index of lane.
                     * We have 3 lanes : lane1 (index 0 of jumps array), lane2 (index 1 of jumps array), lane2 (index 2 of jumps array)
                     * So if frog is at lane 1 (index = 0 ) then next two lanes are : (0+1) % 3 = 1, (0+2) % 3 = 2
                     *    if frog is at lane 2 (index = 1 ) then next two lanes are : (1+1) % 3 = 2, (1+2) % 3 = 0
                     *    if frog is at lane 3 (index = 2 ) then next two lanes are : (2+1) % 3 = 0, (2+2) % 3 = 1
                     * It is like a circular list, move ahead by +1 and +2 index.
                     * */
                    final int lane1 = (currentLane + 1) % 3; /* first lane where frog can jump*/
                    final int lane2 = (currentLane + 2) % 3; /* second lange where frog can jump*/
                    final int lane1Jump = jumps[lane1]; /* current count of jumps taken to reach first lane*/
                    final int lane2Jump = jumps[lane2]; /* current count of jumps taken to reach second lane*/
                    /*
                     * Here calculating minimum jumps required to reach current lane from other two lanes.
                     * Since Frog starts at middle lane Lane2 so jumps array has been initialized with { 1 (lane 1), 0 (lane 2), 1 (lane 3)}
                     * Why: Frog starts at lane 2 so how many jumps it needs to reach
                     * a). lane 1 : 1 jump
                     * b). lane 2 : 0 jump
                     * a). lane 3 : 1 jump
                     * Frog moves froward and when it encounters an obstacle it jumps.
                     * That is why when an obstacle is encountered we are setting value in jump array to large value (1000000).
                     * */
                    jumps[currentLane] = Math.min(jumps[currentLane], Math.min(lane1Jump, lane2Jump) + 1);
                }
            }
        }
        return Math.min(jumps[0], Math.min(jumps[1], jumps[2]));
    }
}
