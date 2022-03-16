package view;

import controller.GameController;
import model.GameLogic;
import view.GameMainForm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GameResultForm extends JFrame{
    private JLabel __timeField;
    private JLabel __countField;
    private JButton __newGameBtn;
    private JPanel __mainPanel;


    public GameResultForm(int time, int count) {

        setContentPane(__mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,200);
        __mainPanel.setBorder(new EmptyBorder(15,15,15,15));
        __timeField.setText(time + " сек");
        __countField.setText(String.valueOf(count));
        setVisible(true);

        __newGameBtn.addActionListener(e -> {
            GameLogic _gameLogic = new GameLogic();
            GameController _gameController = new GameController(_gameLogic);
            new GameMainForm(_gameController, _gameLogic);
            setVisible(false);
        });


    }
}
