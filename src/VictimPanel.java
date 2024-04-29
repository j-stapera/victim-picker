import javax.swing.*;
import java.awt.*;




public class VictimPanel extends JPanel {

    //CHANGE THESE VALUES TO CHANGE THE SIZE OF THE VictimPanel Square (the space in which all victim panels reside)
    private final int OnePanelWidth = 750;
    private final int OnePanelHeight = 400;
    private final int PanelDistance = 5;

    //X and Y values for the top left coordinates of the VictimPanel Square (the space in which all victim panels reside)
    private final int TopLeftCornerX = 225;
    private final int TopLeftCornerY = 100;

    private JLabel pointsText;
    private final int number;

    private Victim victim = new Victim("Pick Victim");

    private PickVictimButton pickVictimButton;
    private VolunteerComboBox volunteer;

    //These values are dependent on the size of the VictimPanel Square (the space in which all victim panels reside)
    private final int TwoThreeFourPanelWidth = (OnePanelWidth/2) - PanelDistance;
    private final int TwoPanelHeight = OnePanelHeight;
    private final int ThreeFourHeight = (OnePanelHeight/2) - PanelDistance;


    private VictimPicker victimPicker;


    VictimPanel(int num, VictimPicker vp) {
        Font font1 = new Font("Arial", Font.BOLD, 20);

        this.number = num;
        victimPicker = vp;

        pointsText = new JLabel("Points: 0");
        pointsText.setFocusable(false);

        //Create all the Buttons on the Panel
        volunteer = new VolunteerComboBox(vp, this);
        AddPointButton addPointButton = new AddPointButton(this);
        RemovePointButton removePointButton = new RemovePointButton(this);
        MarkAbsentButton markAbsentButton = new MarkAbsentButton(this);
        pickVictimButton = new PickVictimButton(this);

        //SET LOCAL VARIABLES SO THAT ALL STATEMENTS CAN BE COPIED AND PASTED
        int localX = 0, localY = 0, localWidth = 0, localHeight = 0;

        //Setting Bounds of Frame
        switch(number)
        {
            case 1 : //1 victim on screen
                localX = TopLeftCornerX;
                localY = TopLeftCornerY;
                localWidth = OnePanelWidth;
                localHeight = OnePanelHeight;

                break;

            case 2 : //2 victims on screen (left panel)
                localX = TopLeftCornerX;
                localY = TopLeftCornerY;
                localWidth = TwoThreeFourPanelWidth;
                localHeight = TwoPanelHeight;

                break;

            case 3 : //2 victims on screen (right panel)
                localX = TopLeftCornerX + TwoThreeFourPanelWidth + (PanelDistance * 2);
                localY = TopLeftCornerY;
                localWidth = TwoThreeFourPanelWidth;
                localHeight = TwoPanelHeight;

                break;

            case 4, 7 : //3 or 4 victims on screen (top left panel)
                localX = TopLeftCornerX;
                localY = TopLeftCornerY;
                localWidth = TwoThreeFourPanelWidth;
                localHeight = ThreeFourHeight;

                break;

            case 5, 8 : //3 or 4 victims on screen (top right panel)
                localX = TopLeftCornerX + TwoThreeFourPanelWidth + (PanelDistance * 2);
                localY = TopLeftCornerY;
                localWidth = TwoThreeFourPanelWidth;
                localHeight = ThreeFourHeight;

                break;

            case 6 : //3 victims on screen (bottom panel)
                localX = TopLeftCornerX + (TwoThreeFourPanelWidth/2);
                localY = TopLeftCornerY + ThreeFourHeight + (PanelDistance * 2);
                localWidth = TwoThreeFourPanelWidth;
                localHeight = ThreeFourHeight;

                break;

            case 9 : //4 victims on screen (bottom left panel)
                localX = TopLeftCornerX;
                localY = TopLeftCornerY + ThreeFourHeight + (PanelDistance * 2);
                localWidth = TwoThreeFourPanelWidth;
                localHeight = ThreeFourHeight;

                break;

            case 10 : //4 victims on screen (bottom right panel)
                localX = TopLeftCornerX + TwoThreeFourPanelWidth + (PanelDistance * 2);
                localY = TopLeftCornerY + ThreeFourHeight + (PanelDistance * 2);
                localWidth = TwoThreeFourPanelWidth;
                localHeight = ThreeFourHeight;

                break;

            default :
                // default Statement
        }

        //Set the sizes of every element in the panel
        this.setBounds(localX,localY,localWidth,localHeight);
        pickVictimButton.setBounds((int)(localWidth/(16.0/3)),(localHeight/9),(int)(localWidth/1.6),(int)(localHeight/4.5));
        addPointButton.setBounds((localWidth/32),(int)(localHeight/2.25),(int)(localWidth/3.2),(int)(localHeight/4.5));
        removePointButton.setBounds((int)(localWidth/(32.0/11)),(int)(localHeight/2.25),(int)(localWidth/3.2),(int)(localHeight/4.5));
        markAbsentButton.setBounds((int)(localWidth/(32.0/21)),(int)(localHeight/2.25),(int)(localWidth/3.2),(int)(localHeight/4.5));
        pointsText.setBounds((int)(localWidth/(32.0/21)),(int)(localHeight/1.3),(int)(localWidth/3.2),(int)(localHeight/10.8));
        pointsText.setHorizontalAlignment(JLabel.CENTER);
        pointsText.setVerticalAlignment(JLabel.CENTER);


        volunteer.setBounds((localWidth/32),(int)(localHeight/1.3),(int)(localWidth/3.2),(int)(localHeight/7.0));




        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.black));


        this.add(addPointButton);
        this.add(removePointButton);
        this.add(markAbsentButton);
        this.add(pickVictimButton);
        this.add(pointsText);

        this.add(volunteer);



    }

    public VictimPicker getVictimPicker() {
        return victimPicker;
    }

    public void setVictim(Victim victim) {
        this.victim = victim;
        pickVictimButton.setText(victim.getName());
    }

    public Victim getVictim(){
        return victim;
    }

    public void updatePoints(){
        pointsText.setText("Points: " + victim.getScore());
    }

    public void updateVictimPanel() {
        pointsText.setText("Points: " + victim.getScore());
        pickVictimButton.setText(victim.getName());
        volunteer.UpdateVolunteerList();
    }


}