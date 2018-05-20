import java.awt.EventQueue;

import javax.swing.JFrame;

public class Game extends JFrame {

Game() {
    add(new Board());
    setResizable(false);
    pack();

    setTitle("Snake");
    setLocationRelativeTo(null);
}

public static void main(String[] args) {
            JFrame frame = new Game();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
}
}
