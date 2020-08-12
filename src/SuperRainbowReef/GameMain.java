package SuperRainbowReef;

import javax.swing.*;

public class GameMain extends JFrame {

    private GamePanel panel = new GamePanel();

    public static void main(String[] args) {
        new GameMain().startGame();
    }

    public void startGame() {
        Thread thread = new Thread(panel);
        thread.start();
        add(panel);
        addKeyListener(panel);
        setTitle("Super Rainbow Reef");
        setSize(640, 480);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
