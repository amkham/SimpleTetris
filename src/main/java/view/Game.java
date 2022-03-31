package view;

import model.Figure;
import model.GameTime;
import service.GameService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {


    private Point figureLocation ;
    private Point gameButtonLocation;
    private Point gameStepsTextFieldLocation;
    private Point gameTimeTextFieldLocation;



    private final int size = 50;

    private GameService mainViewPresenter;
    private final Timer timer;
    private JPanel mainPanel;
    private JPanel figureGenerateContainer, gameFieldContainer;
    private JLabel stepLabel, timeLabel;

    private final Color rectangleColor = Color.GREEN;

    private final GameTime gameTime = new GameTime();

    public Game() {

        int _mainPanelWidth = 701;
        int _mainPanelHeight = 521;

        setSize(_mainPanelWidth, _mainPanelHeight);

        setTitle("Простой тетрис");

        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize();
        createMainPanel();
        createButton();
        createGameStepLabel();
        createTimeLabel();
        setContentPane(mainPanel);

        timer = new Timer(1000, e -> {
            gameTime.tick();
            SwingUtilities.invokeLater(() -> timeLabel.setText(gameTime.getTime()));
        });
        timer.start();

        setVisible(true);
    }

    private void setSize(){
        figureLocation = new Point(500, 10);
        gameButtonLocation = new Point(500, 250);
        gameStepsTextFieldLocation = new Point(500, 200);
        gameTimeTextFieldLocation = new Point(500, 220);
    }


    public void updateGameField(int[][] matrix) {
        if (gameFieldContainer != null) {
            gameFieldContainer.removeAll();
        }
        createGameField(9, 9);
        fillGameField(gameFieldContainer, matrix, true);
    }


    public void updateGameStep(int step) {
        SwingUtilities.invokeLater(() -> this.stepLabel.setText("Ходов: " + step));
    }

    public void end(int steps) {
        timer.stop();
        new GameStatistic(gameTime.getTime(), steps);
        setVisible(false);
    }


    public void setGameService(GameService service) {
        mainViewPresenter = service;
    }


    public void updateFigure(Figure figure) {
        if (figureGenerateContainer != null) {
            figureGenerateContainer.removeAll();
        }
        createFigureContainer(figure.getMatrix().length, figure.getMatrix()[0].length);
        fillGameField(figureGenerateContainer, figure.getMatrix(), false);

    }

    private void fillGameField(JPanel jPanel, int[][] matrix, boolean border) {
        int _width = matrix.length;
        int _height = matrix[0].length;

        for (int i = 0; i < _height; i++) {
            for (int j = 0; j < _width; j++) {
                if (matrix[j][i] == 0) {
                    if (border) jPanel.add(createRectangle(Color.black));
                    else jPanel.add(createRectangle());
                } else {
                    jPanel.add(createRectangle(rectangleColor, Color.black));
                }
            }
        }
        SwingUtilities.updateComponentTreeUI(mainPanel);
    }


    private void createMainPanel() {
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                figureGenerateContainer.setLocation(
                        (e.getX() / size) * size + gameFieldContainer.getLocation().x - size,
                        (e.getY() / size) * size + gameFieldContainer.getLocation().y - size
                );
            }
        });
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                mainPanel.remove(gameFieldContainer);
                mainPanel.remove(figureGenerateContainer);
                int x = e.getX() / size - 1;
                int y = e.getY() / size - 1;
                mainViewPresenter.insertFigure(x,y);
            }
        });
    }

    public void createGameField(int w, int h) {
        gameFieldContainer = new JPanel();
        gameFieldContainer.setLayout(new GridLayout(w, h));
        gameFieldContainer.setSize(w * size, h * size);
        gameFieldContainer.setBorder(BorderFactory.createLineBorder(Color.black));
        gameFieldContainer.setLocation(10, 10);
        mainPanel.add(gameFieldContainer);
    }

    private void createGameStepLabel() {
        stepLabel = new JLabel();
        stepLabel.setSize(200, 20);
        stepLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        stepLabel.setForeground(Color.white);
        stepLabel.setText("Ходов: ");
        stepLabel.setLocation(gameStepsTextFieldLocation);
        mainPanel.add(stepLabel);
    }

    private void createTimeLabel() {
        timeLabel = new JLabel();
        timeLabel.setSize(150, 20);
        timeLabel.setForeground(Color.white);
        timeLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        timeLabel.setLocation(gameTimeTextFieldLocation);
        mainPanel.add(timeLabel);
    }

    private void createButton() {
        JButton _jButton = new JButton();
        _jButton.addActionListener(e -> {
            mainViewPresenter.end();
        });
        _jButton.setSize(150, 20);
        _jButton.setText("Завершить");
        _jButton.setLocation(gameButtonLocation);
        mainPanel.add(_jButton);
    }

    public void createFigureContainer(int w, int h) {
        figureGenerateContainer = new JPanel();
        figureGenerateContainer.setLayout(new GridLayout(h, w));
        figureGenerateContainer.setBackground(new Color(0, 0, 0, 0));
        figureGenerateContainer.setSize(w * size, h * size);
        figureGenerateContainer.setLocation(figureLocation);
        mainPanel.add(figureGenerateContainer);
    }

    private Component createRectangle() {
        JPanel _panel = new JPanel();
        _panel.setBackground(new Color(0, 0, 0, 0));
        return _panel;
    }

    private Component createRectangle(Color border) {
        JPanel _panel = new JPanel();
        _panel.setBorder(BorderFactory.createLineBorder(border));
        return _panel;
    }

    private Component createRectangle(Color solid, Color border) {
        JPanel _panel = new JPanel();
        _panel.setBackground(solid);
        _panel.setBorder(BorderFactory.createLineBorder(border));
        return _panel;
    }


}
