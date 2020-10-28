package algorithems;

import models.State;

import java.util.LinkedList;
// import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class DFS {

    public static void solve(State start) {
        System.out.println("starting dfs");
        int count = 0;
        if (start.isFinal()) {
            start.print();
            return;
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
                return;
            }

            fringe.addAll(0, temp.makeChild());
        }

        System.out.println("not found");

    }

}
