package algorithems;

import models.State;

import java.util.LinkedList;
// import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class IDS {

    public static int dfs_limit(State start, int depth_limit) {
        System.out.println("starting dfs");
        int count = 0;
        int current_depth = 0;
        if (start.isFinal()) {
            start.print();
            return 1;
        }

        Set<State> visitedList = new TreeSet<>();
        LinkedList<State> fringe = new LinkedList<>();
        fringe.add(start);

        while (!fringe.isEmpty()) {
            State temp = fringe.poll();
            if (visitedList.contains(temp)){
                continue;
            }
            visitedList.add(temp);
            count++;
            if (temp.isFinal()) {
                temp.print();
                System.out.println("node count = " + count);
                return 1;
            }

            if (current_depth < depth_limit) {
                fringe.addAll(0, temp.makeChild());
                current_depth ++;
            }
        }

        System.out.println("not found");
        return -1;
    }


    public static void solve(State start) {
        int max_depth = 100;
        for (int i = 0; i < max_depth; i ++) {
            if (dfs_limit(start, i) == 1) {
                return;
            }
        }
    }
}
