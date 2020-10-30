package algorithems;

import models.State;

import java.util.LinkedList;
// import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class IDS {

    public static int dfs_limit(State start, int depth_limit) {
        // System.out.println("starting dfs limit " + depth_limit);
        int count = 0;
        if (start.isFinal()) {
            start.print();
            return 1;
        }
        boolean has_other_childs = false;
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
            if (temp.depth < depth_limit) {
                // System.out.println(temp.depth);
                fringe.addAll(0, temp.makeChild());
            } else {
                if (temp.makeChild().size() > 0)
                    has_other_childs = true;
            }
        }

        // System.out.println("not found");
        if (has_other_childs)
            return -1;
        else
            return 0;
    }


    public static void solve(State start) {
        System.out.println("starting ids");
        int i = 0;
        while(true) {
            i++;
            int result = dfs_limit(start, i);
            if ( result == 1) {
                return;
            } else if (result == 0) {
                break;
            }
        }
        System.out.println("not found any solutions");
    }
}
