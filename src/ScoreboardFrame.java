import javax.swing.*;

public class ScoreboardFrame extends JFrame {

    ScoreboardPanel sbPanel;

    ScoreboardFrame(ScoreboardPanel sbPanel){
        this.add(sbPanel);
        this.setSize(250,650);

        //Set to do nothing on close because entire application closes when 'x' is clicked
        //Could change to something else maybe, but there is a 'close' button on the frame
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //this.pack();
        //this.setLocationRelativeTo(null);
        //this.setVisible(true);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
    }
}
