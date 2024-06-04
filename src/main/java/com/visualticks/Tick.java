package com.visualticks;

import lombok.Getter;

public class Tick {
    @Getter
    private int shapeX;
    @Getter
    private int shapeY;
    @Getter
    private int fontX;
    @Getter
    private int fontY;

    public Tick(int shapeX, int shapeY, int fontX, int fontY) {
        this.shapeX = shapeX;
        this.shapeY = shapeY;
        this.fontX = fontX;
        this.fontY = fontY;
    }
}
