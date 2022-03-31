package view;

import service.GameService;
import model.GameLogic;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameStatistic extends JFrame{
    private JButton button;

    private JLabel timeLabel;
    private JLabel stepLabel;

    private JPanel mainPanel;


    public GameStatistic(String time, int count) {
        setContentPane(mainPanel);
        setSize(300,200);

        setTitle("Конец игры");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        createMainPanel();


        decorateTextLabel(timeLabel, stepLabel);

        timeLabel.setText(time);

        stepLabel.setText(String.valueOf(count));


        button.addActionListener(e -> {
            new GameService(new Game(), new GameLogic()).start();
            setVisible(false);
        });

        setVisible(true);
    }

    private void decorateTextLabel(JLabel... jLabel)
    {
        for (JLabel j: jLabel)
        j.setForeground(Color.white);
    }

    private void createMainPanel()
    {
        mainPanel.setBorder(new EmptyBorder(30,30,30,30));
        mainPanel.setBackground(Color.DARK_GRAY);
    }
}
