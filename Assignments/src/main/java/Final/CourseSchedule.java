package Final;

import java.util.*;

public class CourseSchedule {
    /*Q9
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.


Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
*/

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //map -> prerec, list of courses
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerec : prerequisites){
            if(!map.containsKey(prerec[1])){
                Set<Integer> set = new HashSet<>();
                set.add(prerec[0]);
                map.put(prerec[1],set);
            }else {
                Set<Integer> set = map.get(prerec[1]);
                set.add(prerec[0]);
                map.put(prerec[1],set);
            }
        }
        //add dependencies
        int[] numDependencies = new int[numCourses];
        for (int[] prerec : prerequisites){
            numDependencies[prerec[0]]+=1;
        }
        //if no dependency, add to q, reduce depencency of children
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<numDependencies.length;i++){
            if(numDependencies[i]==0){
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()){
            int currCourse = q.poll();
            count++;
            //reduce dependency of children
            if(map.containsKey(currCourse)) {
                Set<Integer> children = map.get(currCourse);
                for (int i : children) {
                    numDependencies[i]--;
                    if (numDependencies[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        if(count==numCourses) return true;
        return false;
    }

}
