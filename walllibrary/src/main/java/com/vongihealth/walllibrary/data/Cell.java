package com.vongihealth.walllibrary.data;

/**
 * Created by hzjixiaohui on 2017-9-7.
 */

public class Cell {
    private int row;
    private int layer = 0;
    private double width;
    private double hight;

    public Cell(int row,double width, double hight) {
        this.width = width;
        this.hight = hight;
        this.row = row;
    }

    public Cell(int row, int layer, double width, double hight) {
        this.row = row;
        this.layer = layer;
        this.width = width;
        this.hight = hight;
    }

    public int getRow() {
        return row;
    }

    public double getWidth() {
        return width;
    }

    public double getHight() {
        return hight;
    }

    public int getLayer() {
        return layer;
    }
}
