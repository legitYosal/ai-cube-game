package models;

public class Cube implements Cloneable {

    //true -> cover one square of board
    //false-> cover two square of board
    private boolean stand;

    //true -> cube is like --
    //false -> cube is like |
    private boolean horizontal;
    private int x;
    private int y;

    public Cube(Cube cube) {
        this.horizontal = cube.horizontal;
        this.stand = cube.stand;
        this.x = cube.x;
        this.y = cube.y;
    }

    public Cube(int x, int y) {
        this.horizontal = false;
        this.stand = true;
        this.x = x;
        this.y = y;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isStand() {
        return stand;
    }


    public void moveUp() {
        if (stand) {
            stand = false;
            horizontal = false;
            x--;
        } else {
            if (horizontal) {
                x--;
            } else {
                x -= 2;
                stand = true;
            }
        }
    }

    public void moveDown() {
        if (stand) {
            stand = false;
            horizontal = false;
            x += 2;
        } else {
            if (horizontal) {
                x++;
            } else {
                x++;
                stand = true;
            }
        }
    }

    public void moveRight() {
        if (stand) {
            stand = false;
            horizontal = true;
            y++;
        } else {
            if (horizontal) {
                y += 2;
                stand = true;
            } else {
                y++;
            }
        }
    }

    public void moveLeft() {
        if (stand) {
            stand = false;
            horizontal = true;
            y -= 2;
        } else {
            if (horizontal) {
                stand = true;
                y--;
            } else {
                y--;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return stand == cube.stand &&
                horizontal == cube.horizontal &&
                x == cube.x &&
                y == cube.y;
    }

}

