package model;

import java.sql.Time;

public class AppTimer extends Thread {

    private int __time;
    private boolean __stop;


    public AppTimer() {
    }

    public int getTime() {
        return __time;
    }

    public void go() {
        start();
    }

    public int end() {
        __stop = true;
        int result = __time;
        __time = 0;
        return result;
    }

    @Override
    public void run() {
        __stop = false;
        while(!__stop) {
            try {
                sleep(1000);
                __time++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
