package com.visualticks;

import lombok.Getter;

@Getter
public class Tick {
    private final int shapeX;
    private final int shapeY;
    private final int fontX;
    private final int fontY;

    public Tick(int shapeX, int shapeY, int fontX, int fontY) {
        this.shapeX = shapeX;
        this.shapeY = shapeY;
        this.fontX = fontX;
        this.fontY = fontY;
    }
}
