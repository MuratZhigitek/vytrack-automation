package com.vytrack.utilities;

public class Wait {
    public static void sleep(double s) {

        try {
            java.lang.Thread.sleep((long) s * 1000);
        } catch (InterruptedException e) {

        }
    }
}
