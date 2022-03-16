import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

public class GameMainForm extends JFrame {
    private final int __mainPanelWidth = 1000;
    private final int __mainPanelHeight = 700;

    private final Point __figurePanelLocation = new Point(500,10);

    private JPanel __mainPanel;
    private JPanel __figurePanel, __gameFieldPanel;

    private GameLogic __gameLogic;

    public GameMainForm() {
        setSize(__mainPanelWidth, __mainPanelHeight);
        setResizable(false);
        setLocationRelativeTo(null);
        initMainPanel();
        setContentPane(__mainPanel);

        __gameLogic = new GameLogic(this);
        setVisible(true);


        __mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

               __figurePanel.setLocation(
                        (e.getX() / 50) * 50 + __gameFieldPanel.getLocation().x - 50,
                        (e.getY() / 50) * 50 + __gameFieldPanel.getLocation().y - 50
                );
            }
        });


        __mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                __mainPanel.removeAll();
                __gameLogic.insert(e.getX(), e.getY());
            }
        });
    }
    
    public void updateGameField(int[][] matrix){
        if (__gameFieldPanel != null){
            __gameFieldPanel.removeAll();
        }
        initGameField(9,9);
        fillPanel(__gameFieldPanel, matrix);

    }

    public void updateFigure(Figure figure) {
        if (__figurePanel != null){
            __figurePanel.removeAll();
        }
        initFigureGenerateField(figure.getMatrix().length, figure.getMatrix()[0].length);
        fillPanel(__figurePanel, figure.getMatrix());

    }

    private void fillPanel(JPanel jPanel, int[][] matrix){



        int _width =  matrix.length;
        int _height = matrix[0].length;

        for (int i = 0; i < _height; i++) {
            for (int j = 0; j < _width; j++) {
                if (matrix[j][i] == 0) {
                    jPanel.add(createRectangle());
                } else {
                    jPanel.add(createRectangle(Color.blue, Color.black));
                }
            }
        }
        SwingUtilities.updateComponentTreeUI(__mainPanel);
    }


    private void initMainPanel() {
        __mainPanel.setLayout(null);
    }

    public void initGameField(int w, int h) {
        __gameFieldPanel = new JPanel();
        __gameFieldPanel.setLayout(new GridLayout(w, h));
        __gameFieldPanel.setSize(w*50, h*50);
        __gameFieldPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        __gameFieldPanel.setLocation(10, 10);
        __mainPanel.add(__gameFieldPanel);
    }

    public void initFigureGenerateField(int w, int h) {


            __figurePanel = new JPanel();
            __figurePanel.setLayout(new GridLayout(h, w));
            __figurePanel.setBackground(new Color(0, 0, 0, 0));
            __figurePanel.setSize(w*50, h*50);
            __figurePanel.setLocation(__figurePanelLocation);
            __mainPanel.add(__figurePanel);

    }

    private Component createRectangle() {
        JPanel _panel = new JPanel();
        _panel.setSize(50,50);
        _panel.setBackground(new Color(0, 0, 0, 0));
        return _panel;
    }

    private Component createRectangle(Color border) {
        JPanel _panel = new JPanel();
        _panel.setSize(50,50);
        _panel.setBorder(BorderFactory.createLineBorder(border));
        return _panel;
    }

    private Component createRectangle(Color solid, Color border) {
        JPanel _panel = new JPanel();
        _panel.setSize(50,50);
        _panel.setBackground(solid);
        _panel.setBorder(BorderFactory.createLineBorder(border));
        return _panel;
    }


}
