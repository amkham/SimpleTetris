package view;

import model.Figure;
import presenter.IMainViewPresenter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements IViewContract {

    private final Point figureLocation = new Point(500, 10);
    private final Point gameButtonLocation = new Point(500, 250);
    private final Point gameStepsTextFieldLocation = new Point(500, 200);
    private final Point gameTimeTextFieldLocation = new Point(500, 220);

    private final Color rectangleColor = Color.ORANGE;

    private final int size = 50;

    private IMainViewPresenter mainViewPresenter;
    private final Timer timer;
    private JPanel mainPanel;
    private JPanel figurePanel, gameFieldPanel;
    private JLabel step, time;

    private int gameTime;

    public Game() {

        int _mainPanelWidth = 700;
        int _mainPanelHeight = 520;
        setSize(_mainPanelWidth, _mainPanelHeight);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        createMainPanel();
        createButton();
        createGameStepLabel();
        createTimeLabel();
        setContentPane(mainPanel);

        timer = new Timer(1000, e -> {
            gameTime++;
            SwingUtilities.invokeLater(() -> time.setText("Время: " + gameTime));
        });
        timer.start();

        setVisible(true);
    }

    @Override
    public void updateGameField(int[][] matrix) {
        if (gameFieldPanel != null) {
            gameFieldPanel.removeAll();
        }
        createGameField(9, 9);
        fillGameField(gameFieldPanel, matrix, true);
    }

    @Override
    public void updateGameStep(int step) {
        SwingUtilities.invokeLater(() -> this.step.setText("Сделано ходов: " + step));
    }

    @Override
    public void end(int steps) {
        timer.stop();
        new Statistic(gameTime, steps);
        setVisible(false);
    }

    @Override
    public void setPresenter(IMainViewPresenter presenter) {
        mainViewPresenter = presenter;
    }

    @Override
    public void updateFigure(Figure figure) {
        if (figurePanel != null) {
            figurePanel.removeAll();
        }
        createFigureContainer(figure.getMatrix().length, figure.getMatrix()[0].length);
        fillGameField(figurePanel, figure.getMatrix(), false);

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
        mainPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                figurePanel.setLocation(
                        (e.getX() / size) * size + gameFieldPanel.getLocation().x - size,
                        (e.getY() / size) * size + gameFieldPanel.getLocation().y - size
                );
            }
        });
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                mainPanel.remove(gameFieldPanel);
                mainPanel.remove(figurePanel);
                int x = e.getX() / size - 1;
                int y = e.getY() / size - 1;
                mainViewPresenter.setFigure(x,y);
            }
        });
    }

    public void createGameField(int w, int h) {
        gameFieldPanel = new JPanel();
        gameFieldPanel.setLayout(new GridLayout(w, h));
        gameFieldPanel.setSize(w * size, h * size);
        gameFieldPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        gameFieldPanel.setLocation(10, 10);
        mainPanel.add(gameFieldPanel);
    }

    private void createGameStepLabel() {
        step = new JLabel();
        step.setSize(200, 20);
        step.setBorder(new EmptyBorder(10, 10, 10, 10));
        step.setText("Колличество ходов: ");
        step.setLocation(gameStepsTextFieldLocation);
        mainPanel.add(step);
    }

    private void createTimeLabel() {
        time = new JLabel();
        time.setSize(100, 20);
        time.setBorder(new EmptyBorder(10, 10, 10, 10));
        time.setLocation(gameTimeTextFieldLocation);
        time.setText("Время: ");
        mainPanel.add(time);
    }

    private void createButton() {
        JButton _jButton = new JButton();
        _jButton.addActionListener(e -> {
            mainViewPresenter.endGame();
        });
        _jButton.setSize(150, 20);
        _jButton.setText("Завершить игру");
        _jButton.setLocation(gameButtonLocation);
        mainPanel.add(_jButton);
    }

    public void createFigureContainer(int w, int h) {
        figurePanel = new JPanel();
        figurePanel.setLayout(new GridLayout(h, w));
        figurePanel.setBackground(new Color(0, 0, 0, 0));
        figurePanel.setSize(w * size, h * size);
        figurePanel.setLocation(figureLocation);
        mainPanel.add(figurePanel);
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
