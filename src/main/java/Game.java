import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {


    private Point figureLocation ;
    private Point gameButtonLocation;
    private Point gameStepsTextFieldLocation;
    private Point gameTimeTextFieldLocation;



    private final int itemSize = 70;

    private GameService service;
    private final Timer timer;
    private JPanel mainPanel;
    private JPanel figureGenerateContainer, gameFieldContainer;
    private JLabel stepLabel, timeLabel;

    private final Color rectangleColor = Color.GREEN;

    private final GameTime gameTime = new GameTime();

    public Game() {

        int w = 1000;
        int h = 700;

        setSize(w, h);

        setTitle("Простой тетрис");

        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        createGameComponents();

        setContentPane(mainPanel);

        this.timer = new Timer(1000, e -> {
            this.gameTime.tick();
            SwingUtilities.invokeLater(() -> this.timeLabel.setText(this.gameTime.getTime()));
        });
        this.timer.start();

        setVisible(true);
    }


    void createGameComponents()
    {
        this.figureLocation = new Point(700, 10);
        this.gameButtonLocation = new Point(700, 300);
        this.gameStepsTextFieldLocation = new Point(700, 420);
        this.gameTimeTextFieldLocation = new Point(700, 440);

        this.mainPanel.setLayout(null);
        this.mainPanel.setBackground(Color.DARK_GRAY);
        this.mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                figureGenerateContainer.setLocation(
                        (e.getX() / itemSize) * itemSize + gameFieldContainer.getLocation().x - itemSize,
                        (e.getY() / itemSize) * itemSize + gameFieldContainer.getLocation().y - itemSize
                );
            }
        });
        this.mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                mainPanel.remove(gameFieldContainer);
                mainPanel.remove(figureGenerateContainer);
                int x = e.getX() / itemSize - 1;
                int y = e.getY() / itemSize - 1;
                service.insertFigure(x,y);
            }
        });

        JButton _jButton = new JButton();
        _jButton.addActionListener(e -> service.end());
        _jButton.setSize(200, 50);
        _jButton.setText("Завершить");
        _jButton.setLocation(gameButtonLocation);
        this.mainPanel.add(_jButton);

        this.stepLabel = new JLabel();
        this.stepLabel.setSize(200, 20);
        this.stepLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.stepLabel.setForeground(Color.white);
        this.stepLabel.setText("Ходов: ");
        this.stepLabel.setLocation(gameStepsTextFieldLocation);
        this.mainPanel.add(stepLabel);

        this.timeLabel = new JLabel();
        this.timeLabel.setSize(150, 20);
        this.timeLabel.setForeground(Color.white);
        this.timeLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.timeLabel.setLocation(gameTimeTextFieldLocation);
        this.mainPanel.add(timeLabel);
    }




    public void updateGameField(int[][] matrix) {
        if (this.gameFieldContainer != null) {
            this.gameFieldContainer.removeAll();
        }

        this.gameFieldContainer = new JPanel();
        this.gameFieldContainer.setLayout(new GridLayout(9, 9));
        this.gameFieldContainer.setSize(9 * itemSize, 9 * itemSize);
        this.gameFieldContainer.setBorder(BorderFactory.createLineBorder(Color.black));
        this.gameFieldContainer.setLocation(10, 10);
        this.mainPanel.add(gameFieldContainer);

        fillGameField(this.gameFieldContainer, matrix, true);
    }


    public void updateGameStep(int step) {
        SwingUtilities.invokeLater(() -> this.stepLabel.setText("Очки: " + step));
    }

    public void end(int steps) {
        this.timer.stop();
        new GameStatistic(this.gameTime.getTime(), steps);
        setVisible(false);
    }


    public void setGameService(GameService service) {
        this.service = service;
    }


    public void updateFigure(Shape shape) {
        if (this.figureGenerateContainer != null) {
            this.figureGenerateContainer.removeAll();
        }
        createFigureContainer(shape.getShapeStructure().length, shape.getShapeStructure()[0].length);
        fillGameField(this.figureGenerateContainer, shape.getShapeStructure(), false);

    }

    void fillGameField(JPanel jPanel, int[] @NotNull [] matrix, boolean border) {
        int _width = matrix.length;
        int _height = matrix[0].length;

        for (int i = 0; i < _height; i++) {
            for (int[] ints : matrix) {
                if (ints[i] == 0) {
                    if (border) {
                        JPanel _panel = new JPanel();
                        _panel.setBorder(BorderFactory.createLineBorder(Color.black));
                        jPanel.add(_panel);
                    }
                    else {
                        JPanel _panel = new JPanel();
                        _panel.setBackground(new Color(0, 0, 0, 0));
                        jPanel.add(_panel);
                    }
                } else {
                    JPanel _panel = new JPanel();
                    _panel.setBackground(Color.green);
                    _panel.setBorder(BorderFactory.createLineBorder(Color.black));
                    jPanel.add(_panel);
                }
            }
        }
        SwingUtilities.updateComponentTreeUI(this.mainPanel);
    }


    void createFigureContainer(int w, int h) {
        this.figureGenerateContainer = new JPanel();
        this.figureGenerateContainer.setLayout(new GridLayout(h, w));
        this.figureGenerateContainer.setBackground(new Color(0, 0, 0, 0));
        this.figureGenerateContainer.setSize(w * itemSize, h * itemSize);
        this.figureGenerateContainer.setLocation(figureLocation);
        this.mainPanel.add(figureGenerateContainer);
    }






}
