import algorithems.BFS;
import algorithems.DFS;
import algorithems.IDS;


import models.Board;
import models.Cube;
import models.State;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        String[] cubeStart = scanner.nextLine().split(" ");
        StringBuilder map = new StringBuilder();
        int length, height;
        int x, y;
        x = Integer.parseInt(cubeStart[0]) - 1;
        y = Integer.parseInt(cubeStart[1]) - 1;
        height = Integer.parseInt(size[0]);
        length = Integer.parseInt(size[1]);
        for (int i = 0; i < height; i++) {
            map.append(scanner.nextLine());
        }

        State start = new State(new Board(length, height, map.toString(), new Cube(x, y)));
        BFS.solve(start);
        DFS.solve(start);
        IDS.solve(start);
        scanner.close();
    }

    /*
1 3
1 1
...

1 3
1 3
...

3 1
1 1
.
.
.

3 1
3 1
.
.
.

     */

    /*
3 3
1 1
...
*..
...

3 3
3 3
..*
...
...

5 5
3 3
**.**
**.**
.....
**.**
**.**

5 5
1 1
.....
.....
.....
.....
.....

3 7
1 1
...*...
...*...
.......

4 7
1 1
...*...
...*...
.......
...*...


     */

    /*

5 5
3 3
.*.**
**.**
.....
**.**
**.**

     */

}
