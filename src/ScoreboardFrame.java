import javax.swing.*;

public class ScoreboardFrame extends JFrame {

    ScoreboardPanel sbPanel;

    ScoreboardFrame(ScoreboardPanel sbPanel){
        this.add(sbPanel);
        this.setSize(200,400);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.pack();
        //this.setLocationRelativeTo(null);
        //this.setVisible(true);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
    }
}
