package com.visualticks.utils;

public class ResetUtils {


    public static int calculateOffset(int offset, int numberOfTicks) {
        if (offset < numberOfTicks){
            return offset;
        }
        return offset % numberOfTicks;
    }
}
