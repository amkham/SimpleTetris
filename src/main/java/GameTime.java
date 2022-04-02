import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


/**
 * Хранит время игры
 */
public class GameTime {


    private int hour, min, sec;


    /**
     * Увеличивает @sec на 1
     */
    public void tick() {
        this.sec++;
        if (this.sec == 60){
            this.sec = 0;
            setMin(getMin() + 1);
        }
    }


    /**
     * Возвращает время игры
     * @return Время в формате hh:mm:ss
     */
    public String getTime(){
        return getFormatted(this.hour) + ":" + getFormatted(this.min) + ":" + getFormatted(this.sec);
    }

    /**
     * Setter
     * @param hour часы
     */
    private void setHour(int hour) {
        this.hour = hour;
    }


    /**
     * Setter
     * @param min минуты
     */
    private void setMin(int min) {
        this.min = min;
        if (this.min == 60){
            this.min = 0;
            setHour(getHour() + 1);
        }
    }

    /**
     * Getter
     * @return секунды
     */
    public int getSec() {
        return sec;
    }

    /**
     * Getter
     * @return
     */
    public int getHour() {
        return hour;
    }

    /**
     * Getter
     * @return
     */
    public int getMin() {
        return min;
    }


    /**
     * Добавляет ноль перед временем если оно меньше 10
     * Ex: Вместо 1 будет отображаться 01
     * @param time
     * @return
     */
    @Contract(pure = true)
    private @NotNull String getFormatted(int time){
        if (time == 0) return "00";
        return time < 10 ? "0" + time : ""  + time;
    }

}
