package com.vongihealth.walllibrary.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzjixiaohui on 2017-9-7.
 */

public class Model {

    private List<Cell> cells;
    private int length,margin;

    public Model(int nums,int length,int margin){
        this.length = length;
        this.margin = margin;
        cells = new ArrayList<>(nums);

        if (nums == 1){
            cells.add(new Cell(1,getLength(1),getLength(1)));
        }else if (nums == 2){
            cells.add(new Cell(1,0.5 * getLength(2),getLength(1)));
            cells.add(new Cell(1,0.5 * getLength(2),getLength(1)));
        }else if (nums == 3){
            cells.add(new Cell(1,1 * getLength(1),0.5* getLength(2)));
            cells.add(new Cell(2,0.5*getLength(2),0.5* getLength(2)));
            cells.add(new Cell(2,0.5*getLength(2),0.5* getLength(2)));
        }else if (nums == 4){
            cells.add(new Cell(1,0.4*getLength(2),0.5*getLength(2)));
            cells.add(new Cell(1,0.6*getLength(2),0.5*getLength(2)));
            cells.add(new Cell(2,0.6*getLength(2),0.5*getLength(2)));
            cells.add(new Cell(2,0.4*getLength(2),0.5*getLength(2)));
        }else if (nums == 5){
            cells.add(new Cell(1,1/3d*getLength(3),2/3d*getLength(2)));
            cells.add(new Cell(1,2/3d*getLength(3),2/3d*getLength(2)));
            cells.add(new Cell(2,1/3d*getLength(3),1/3d*getLength(2)));
            cells.add(new Cell(2,1/3d*getLength(3),1/3d*getLength(2)));
            cells.add(new Cell(2,1/3d*getLength(3),1/3d*getLength(2)));
        }
        else if (nums == 6){
            cells.add(new Cell(1,2/3d*getLength(3)+2*margin,2/3d*getLength(3)+2*margin));
            cells.add(new Cell(1,1,1/3d*getLength(3),1/3d*getLength(3)));
            cells.add(new Cell(1,1,1/3d*getLength(3),1/3d*getLength(3)));
            cells.add(new Cell(2,1/3d*getLength(3),1/3d*getLength(3)));
            cells.add(new Cell(2,1/3d*getLength(3),1/3d*getLength(3)));
            cells.add(new Cell(2,1/3d*getLength(3),1/3d*getLength(3)));
        }else if (nums == 7){
            cells.add(new Cell(1,1/2d*getLength(2),1/2d*getLength(3)+ 2*margin));
            cells.add(new Cell(1,1/2d*getLength(2),1/2d*getLength(3)+ 2*margin));
            cells.add(new Cell(2,1/2d*getLength(2),1/4d*getLength(3)));
            cells.add(new Cell(2,1/2d*getLength(2),1/4d*getLength(3)));
            cells.add(new Cell(3,1/3d*getLength(3),1/4d*getLength(3)));
            cells.add(new Cell(3,1/3d*getLength(3),1/4d*getLength(3)));
            cells.add(new Cell(3,1/3d*getLength(3),1/4d*getLength(3)));
        }else if (nums == 8){
            cells.add(new Cell(1,1/2d*getLength(4)+2*margin,1/4d*getLength(4)));
            cells.add(new Cell(1,1/4d*getLength(4),1/4d*getLength(4)));
            cells.add(new Cell(1,1/4d*getLength(4),1/4d*getLength(4)));
            cells.add(new Cell(2,1/2d*getLength(4)+2*margin,1/2d*getLength(4)+2*margin));
            cells.add(new Cell(2,1/2d*getLength(4)+2*margin,1/2d*getLength(4)+2*margin));
            cells.add(new Cell(3,1/4d*getLength(4),1/4d*getLength(4)));
            cells.add(new Cell(3,1/4d*getLength(4),1/4d*getLength(4)));
            cells.add(new Cell(3,1/2d*getLength(4)+2*margin,1/4d*getLength(4)));
        }else if (nums == 9){
            cells.add(new Cell(1,2/3d*getLength(3)+2*margin,1/2d*getLength(4)+2*margin));
            cells.add(new Cell(1,1,1/3d*getLength(3),1/4d*getLength(4)));
            cells.add(new Cell(1,1,1/3d*getLength(3),1/4d*getLength(4)));
            cells.add(new Cell(2,1/3d*getLength(3),1/4d*getLength(4)));
            cells.add(new Cell(2,1/3d*getLength(3),1/4d*getLength(4)));
            cells.add(new Cell(2,1/3d*getLength(3),1/4d*getLength(4)));
            cells.add(new Cell(3,1/3d*getLength(3),1/4d*getLength(4)));
            cells.add(new Cell(3,1/3d*getLength(3),1/4d*getLength(4)));
            cells.add(new Cell(3,1/3d*getLength(3),1/4d*getLength(4)));
        }
    }

    public List<Cell> getCells() {
        return cells;
    }

    private int getLength(int num){
        return length - num * margin * 2;
    }
}
