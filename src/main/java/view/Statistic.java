package view;

import presenter.MainViewPresenter;
import model.LogicManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Statistic extends JFrame{
    private JButton newGameBtn;
    private JPanel mainPanel;
    private JLabel time;
    private JLabel step;

    public Statistic(int time, int count) {
        setContentPane(mainPanel);
        setSize(320,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        mainPanel.setBorder(new EmptyBorder(15,15,15,15));
        this.time.setText(time + " секунд");
        step.setText(String.valueOf(count));
        setVisible(true);

        newGameBtn.addActionListener(e -> {
            new MainViewPresenter(new Game(), new LogicManager()).startGame();
            setVisible(false);
        });


    }
}
