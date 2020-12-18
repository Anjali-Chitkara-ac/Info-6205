package BinaryTree;

import java.util.*;

public class TreeDiameter {

    public int treeDiameter(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new HashSet<>());
            }

            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new HashSet<>());
            }

            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        int[] result = bfs(map, 0);

        result = bfs(map, result[1]);

        return result[0];
    }

    private int[] bfs(Map<Integer, Set<Integer>> map, int node) {
        Set<Integer> visited = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        int level = -1;
        int farthestNode = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            level ++;
            for(int i = 0; i < size; i ++) {
                int current = q.poll();
                visited.add(current);

                farthestNode = current;

                for(Integer neighbor : map.get(current)) {
                    if(neighbor == null)
                        continue;

                    if(!visited.contains(neighbor))
                        q.add(neighbor);
                }
            }
        }

        return new int[] {level, farthestNode};
    }
}
