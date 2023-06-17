package main.java;

import java.util.Vector;

public class Vector2 extends Vector {
    public static Vector2 up = new Vector2(0, 1);
    public static Vector2 down = new Vector2(0, -1);
    public static Vector2 left = new Vector2(-1, 0);
    public static Vector2 right = new Vector2(1, 0);
    public static Vector2 zero = new Vector2(0, 0);

    public Vector2() {
        this.add(0);
        this.add(0);
    }

    public Vector2(int x, int y) {
        this.add(0, x);
        this.add(1, y);
    }

    public void setX(int x) {
        this.set(0, x);
    }

    public int getX() {
        return (int) this.get(0);
    }

    public void setY(int y) {
        this.set(1, y);
    }

    public int getY() {
        return (int) this.get(1);
    }

    public void addDirection(Vector2 direction) {
        this.setX(this.getX()+direction.getX());
        this.setY(this.getY()+direction.getY());
    }

    @Override
    public synchronized boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }
}
