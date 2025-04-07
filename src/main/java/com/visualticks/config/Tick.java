package com.visualticks.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tick {
    private int shapeX;
    private int shapeY;
    private int fontX;
    private int fontY;

    public Tick(int shapeX, int shapeY) {
        this.shapeX = shapeX;
        this.shapeY = shapeY;
    }
}
