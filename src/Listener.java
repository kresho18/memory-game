import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Listener implements ActionListener {
    JButton[][] buttons;
    JPanel panel;
    String[] Numbers = { "1", "1", "2", "2", "3", "3",
            "4", "4", "5", "5", "6", "6", "7", "7", "8", "8", "9", "9", "10", "10" };
    String[] random;
    int field1, field2;
    int move = 0;

    public void randomizeFields() {
        List<String> list = Arrays.asList(Numbers);
        Collections.shuffle(list);
        random = list.toArray(new String[list.size()]);
    }

    public void setUpFields(JPanel panel) {
        buttons = new JButton[4][];
        for (int i = 0; i < 4 * 5; i++) {
            if (i % 5 == 0)
                buttons[i / 5] = new JButton[5];
            buttons[i / 5][i % 5] = new JButton("MEMORY GAME");

            buttons[i / 5][i % 5].addActionListener(this);
            buttons[i / 5][i % 5].setBackground(Color.WHITE);
            buttons[i / 5][i % 5].setForeground(Color.BLACK);
            panel.add(buttons[i / 5][i % 5]);
            randomizeFields();

        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Memory.hard) {
            JFrame frame = new JFrame("MEMORY GAME");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocation(400, 200);
            frame.setVisible(true);
            JPanel panel1 = new JPanel();
            panel1.setLayout(new GridLayout(4, 5));
            setUpFields(panel1);
            frame.add(panel1, BorderLayout.CENTER);

        }

        if (move < 2) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 5; j++) {
                    if ((e.getSource() == buttons[i][j]) && buttons[i][j].getText().equals("MEMORY GAME")) {
                        buttons[i][j].setText(random[(i * 5 + j)]);
                        move++;
                        if (move == 1) {
                            field1 = (i * 5 + j);

                        } else {
                            field2 = (i * 5 + j);

                        }
                    }
                }
            }
        } else {

            for (int i = 0; i < 4; i++) {// 4 rows
                for (int j = 0; j < 5; j++) {// 5 columns
                    if (random[field1].equals(random[field2])) {
                        if (!buttons[i][j].getText().equals("MEMORY GAME"))
                            buttons[i][j].setText("$$$$$$$$$$");
                    } else if ((!buttons[i][j].getText().equals("$$$$$$$$$$"))
                            && (!buttons[i][j].getText().equals("MEMORY GAME"))) {
                        buttons[i][j].setText("MEMORY GAME");
                    }
                }
                move = 0;
            }
        }
    }

}