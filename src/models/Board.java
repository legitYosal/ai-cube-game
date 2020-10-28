package models;

import java.util.Arrays;
import java.util.Objects;

public class Board implements Cloneable {


    private int[][] map;
    //-1 -> hole
    //0 -> empty
    //1 -> colored
    //2 -> cube

    private int length;
    private int height;
    private Cube cube;

    private Board(Board board) {
        this.map = new int[board.height][board.length];
        this.cube = new Cube(board.cube);
        for (int i = 0; i < board.height; i++)
            if (board.length >= 0) System.arraycopy(board.map[i], 0, this.map[i], 0, board.length);
        this.length = board.length;
        this.height = board.height;
    }

    public Board(int length, int height, String map, Cube cube) {
        this.map = new int[height][length];
        this.cube = cube;
        int count = 0;
        for (int i = 0; i < height; i++)
            for (int j = 0; j < length; j++) {
                if (map.charAt(count) == '.') {
                    this.map[i][j] = 0;
                }
                if (map.charAt(count) == '*') {
                    this.map[i][j] = -1;
                }
                count++;
            }
        this.map[cube.getX()][cube.getY()] = 2;
        this.length = length;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public Cube getCube() {
        return cube;
    }

    private void removeCubeFromMap() {
        if (cube.isStand()) {
            map[cube.getX()][cube.getY()] = 1;
        } else {
            if (cube.isHorizontal()) {
                map[cube.getX()][cube.getY()] = 1;
                map[cube.getX()][cube.getY() + 1] = 1;
            } else {
                map[cube.getX() - 1][cube.getY()] = 1;
                map[cube.getX()][cube.getY()] = 1;
            }
        }
    }

    private boolean addCubeToMap() {
        if (cube.isStand()) {
            if (map[cube.getX()][cube.getY()] == -1)
                return false;
            map[cube.getX()][cube.getY()] = 2;

        } else {
            if (cube.isHorizontal()) {
                if (map[cube.getX()][cube.getY()] == -1 || map[cube.getX()][cube.getY() + 1] == -1)
                    return false;
                map[cube.getX()][cube.getY()] = 2;
                map[cube.getX()][cube.getY() + 1] = 2;
            } else {
                if (map[cube.getX()][cube.getY()] == -1 || map[cube.getX() - 1][cube.getY()] == -1)
                    return false;
                map[cube.getX()][cube.getY()] = 2;
                map[cube.getX() - 1][cube.getY()] = 2;
            }
        }
        return true;
    }

    Board moveRight() {
        Board board = new Board(this);
        board.removeCubeFromMap();
        board.cube.moveRight();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveLeft() {
        Board board = new Board(this);
        board.removeCubeFromMap();
        board.cube.moveLeft();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveDown() {
        Board board = new Board(this);
        board.removeCubeFromMap();
        board.cube.moveDown();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    Board moveUp() {
        Board board = new Board(this);
        board.removeCubeFromMap();
        board.cube.moveUp();
        if (board.addCubeToMap()) {
            return board;
        }
        board = null;
        return null;
    }

    public boolean isFinal() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        boolean a = Arrays.deepEquals(map, board.map);
        boolean b = Objects.equals(cube, board.cube);
        return a && b;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cube);
        result = 31 * result + Arrays.hashCode(map);
        return result;
    }
}
