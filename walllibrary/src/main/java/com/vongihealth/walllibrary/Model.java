package com.vongihealth.walllibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzjixiaohui on 2017-9-7.
 */

public class Model {

    private List<Cell> cells;

    public Model(int nums){

        cells = new ArrayList<>(nums);

        if (nums == 1){
            cells.add(new Cell(1,1,1));
        }else if (nums == 2){
            cells.add(new Cell(1,0.5,1));
            cells.add(new Cell(1,0.5,1));
        }else if (nums == 3){
            cells.add(new Cell(1,1,0.5));
            cells.add(new Cell(2,0.5,1));
            cells.add(new Cell(2,0.5,1));
        }else if (nums == 4){
            cells.add(new Cell(1,0.4,0.5));
            cells.add(new Cell(1,0.5,1));
            cells.add(new Cell(2,0.5,1));
            cells.add(new Cell(2,0.5,1));
        }else if (nums == 5){
            cells.add(new Cell(1,1/3,1/3));
            cells.add(new Cell(1,1/3,1/3));
            cells.add(new Cell(2,1/3,1/3));
            cells.add(new Cell(2,1/3,1/3));
            cells.add(new Cell(2,1/3,1/3));
        }
        else if (nums == 6){
            cells.add(new Cell(1,2/3,2/3));
            cells.add(new Cell(1,1,1/3,1/3));
            cells.add(new Cell(1,1,1/3,1/3));
            cells.add(new Cell(2,1/3,1/3));
            cells.add(new Cell(2,1/3,1/3));
            cells.add(new Cell(2,1/3,1/3));
        }else if (nums == 7){
            cells.add(new Cell(1,1/2,1/2));
            cells.add(new Cell(1,1/2,1/2));
            cells.add(new Cell(2,1/2,1/4));
            cells.add(new Cell(2,1/2,1/4));
            cells.add(new Cell(3,1/3,1/4));
            cells.add(new Cell(3,1/3,1/4));
            cells.add(new Cell(3,1/3,1/4));
        }else if (nums == 8){
            cells.add(new Cell(1,1/2,1/3));
            cells.add(new Cell(1,1/2,1/4));
            cells.add(new Cell(1,1/2,1/4));
            cells.add(new Cell(2,1/2,1/2));
            cells.add(new Cell(2,1/2,1/2));
            cells.add(new Cell(3,1/4,1/4));
            cells.add(new Cell(3,1/4,1/4));
            cells.add(new Cell(3,1/2,1/4));
        }else if (nums == 9){
            cells.add(new Cell(1,2/3,1/2));
            cells.add(new Cell(1,1,1/3,1/4));
            cells.add(new Cell(1,1,1/3,1/4));
            cells.add(new Cell(2,1/3,1/4));
            cells.add(new Cell(2,1/3,1/4));
            cells.add(new Cell(2,1/3,1/4));
            cells.add(new Cell(3,1/3,1/4));
            cells.add(new Cell(3,1/3,1/4));
            cells.add(new Cell(3,1/3,1/4));
        }
    }

    public List<Cell> getCells() {
        return cells;
    }
}
