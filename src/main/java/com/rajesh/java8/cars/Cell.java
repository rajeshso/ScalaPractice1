package com.rajesh.java8.cars;

public class Cell {
    /**
     * This is an unique identifier for the space
     */
    private String cellId;

    /**
     * This is part of the Geo Location or address of the Cell
     */
    private int x;
    /**
     * This is part of the Geo Location or address of the Cell
     */
    private int y;

    public Cell(String cellId, int x, int y) {
        super();
        this.cellId = cellId;
        this.x = x;
        this.y = y;
    }

    public String getCellId() {
        return cellId;
    }

    public void setCellId(String cellId) {
        this.cellId = cellId;
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

    @Override
    public String toString() {
        return "Cell [cellId=" + cellId + ", x=" + x + ", y=" + y + "]";
    }


}
