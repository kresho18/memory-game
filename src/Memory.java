import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Memory {
    static JButton hard;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setLocation(500,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Listener Listener = new Listener();
        hard = new JButton("START THE GAME");
        hard.addActionListener(Listener);
        hard.setPreferredSize(new Dimension(300,160));
        hard.setBackground(Color.WHITE);
        hard.setForeground(Color.BLACK);
        JPanel panel = new JPanel();
        panel.add(hard);
        JLabel text = new JLabel();
        text.setText("                            WELCOME TO MEMORY GAME PLEASE PRESS START THE GAME : ");
        text.setPreferredSize(new Dimension(200,40));
        frame.add(text, BorderLayout.NORTH);
        frame.add(panel,BorderLayout.CENTER);
        frame.setVisible(true);
    }

}