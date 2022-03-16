import java.awt.*;

public enum FigureColor {
    RED(Color.red),
    BLUE(Color.blue),
    YELLOW(Color.yellow),
    GREEN(Color.green);

    private final Color __color;
    FigureColor(Color color) {
        __color = color;
    }

    public Color getColor() {
        return __color;
    }
}
