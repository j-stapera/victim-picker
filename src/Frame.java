import javax.swing.*;


public class Frame extends JFrame  {

    /**
     * Creates a 1000x750 JFrame that exits on close
     * with no layout manager. ALL ITEMS MUST BE MANUALLY POSITIONED
     */
    Frame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Victim Picker v2.0");
        this.setSize(1200,800);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    /*
    public void addScoreboardButton(ArrayList<Victim> victims) {
        JButton scoreboardButton = new JButton("Open Scoreboard");
        scoreboardButton.setBounds(10, 10, 150, 30);
        scoreboardButton.addActionListener(e -> {
            // Open the scoreboard panel when the button is clicked
            ScoreboardPanel scoreboardPanel = new ScoreboardPanel(victims);
            scoreboardPanel.updateScoreboard();
            JFrame scoreboardFrame = new JFrame("Scoreboard");
            scoreboardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            scoreboardFrame.getContentPane().add(scoreboardPanel);
            scoreboardFrame.pack();
            scoreboardFrame.setLocationRelativeTo(null);
            scoreboardFrame.setVisible(true);
        });
        this.add(scoreboardButton);
    }

     */
}
