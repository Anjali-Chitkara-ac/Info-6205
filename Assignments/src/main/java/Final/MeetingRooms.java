package Final;

import java.util.PriorityQueue;

public class MeetingRooms {
    /*Q10
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/

    public int minMeetingRooms(int[][] intervals) {
        //sort based on the start times
        PriorityQueue<int[]> meetings = new PriorityQueue<>((a,b)-> Integer.compare(a[0], b[0]));
        for(int[] meeting: intervals){
            meetings.add(meeting);
        }
        //sorted based on end times
        PriorityQueue<int[]> rooms = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));
        while (!meetings.isEmpty()){
            if(rooms.isEmpty()){
                rooms.add(meetings.poll());
            }
            else {
                int[] currRoom = rooms.peek();
                int[] currMeeting = meetings.peek();
                if (currMeeting[0] >= currRoom[1]) {
                    //replace the meeting in the same room
                    rooms.poll();
                    rooms.add(meetings.poll());
                } else {
                    rooms.add(meetings.poll());
                }
            }
        }
        return rooms.size();
    }
}
