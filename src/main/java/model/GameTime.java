package model;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class GameTime {

    private int hour, min, sec;


    public void tick() {
        this.sec++;
        if (this.sec == 60){
            this.sec = 0;
            setMin(getMin() + 1);
        }
    }


    public String getTime(){
        return getFormatted(this.hour) + ":" + getFormatted(this.min) + ":" + getFormatted(this.sec);
    }

    private void setHour(int hour) {
        this.hour = hour;
    }

    private void setMin(int min) {
        this.min = min;
        if (this.min == 60){
            this.min = 0;
            setHour(getHour() + 1);
        }
    }

    public int getSec() {
        return sec;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    @Contract(pure = true)
    private @NotNull String getFormatted(int time){
        if (time == 0) return "00";
        return time < 10 ? "0" + time : ""  + time;
    }

}
