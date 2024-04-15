import javax.swing.*;
import java.awt.*;

// FOR SOME REASON, THE REMOVE POINTS BUTTON IS MAKING THE ADD/REMOVE VICTIM BUTTONS DISAPPEAR
// AND I DON'T KNOW WHY
// I ADDED ALL OF THE BUTTONS, BUT WE STILL NEED TO ADD THE VOLUNTEER DROP DOWN

// THEN, OF COURSE, ONCE WE HAVE THE LAYOUT GOOD, THEN WE CAN ADD THE FUNCTIONALITY AND THEN WE JUICY



// I THINK I FIXED THE BUTTONS DISAPPEARING THING BUT I'M NOT 100 ON IT
// I HAVE STARTED TRYING TO ADD THE VOLUNTEER DROPDOWN TO THE GUI, BUT IT'S BEING A BIT CRINGE
// IF YOU CAN FIGURE IT OUT... PLEASE SAVE ME

public class VictimPanel extends JPanel {

    //CHANGE THESE VALUES TO CHANGE THE SIZE OF THE VictimPanel Square (the space in which all victim panels reside)
    private final int OnePanelWidth = 800;
    private final int OnePanelHeight = 450;

    //X and Y values for the top left coordinates of the VictimPanel Square (the space in which all victim panels reside)
    private final int TopLeftCornerX = 200;
    private final int TopLeftCornerY = 40;

    //BUTTONS CURRENTLY HAVE ABSOLUTLEY 0 FUNCTIONALITY
    private final JButton addPointButton;
    private final JButton removePointButton;
    private final JButton markAbsentButton;
    private final JButton pickVictimButton;

    private final int number;




    //These values are dependent on the size of the VictimPanel Square (the space in which all victim panels reside)
    private final int TwoThreeFourPanelWidth = OnePanelWidth/2;
    private final int TwoPanelHeight = OnePanelHeight;
    private final int ThreeFourHeight = OnePanelHeight/2;




    VictimPanel(int num, VolunteerComboBox volunteer) {
        this.number = num;


        addPointButton = new JButton("Add Point");
        addPointButton.setFocusable(false);

        removePointButton = new JButton("Remove Point");
        removePointButton.setFocusable(false);

        markAbsentButton = new JButton("Mark Absent");
        markAbsentButton.setFocusable(false);

        pickVictimButton = new JButton("Pick Victim");
        pickVictimButton.setFocusable(false);


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
                localX = TopLeftCornerX + TwoThreeFourPanelWidth;
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
                localX = TopLeftCornerX + TwoThreeFourPanelWidth;
                localY = TopLeftCornerY;
                localWidth = TwoThreeFourPanelWidth;
                localHeight = ThreeFourHeight;

                break;

            case 6 : //3 victims on screen (bottom panel)
                localX = TopLeftCornerX + (TwoThreeFourPanelWidth/2);
                localY = TopLeftCornerY + ThreeFourHeight;
                localWidth = TwoThreeFourPanelWidth;
                localHeight = ThreeFourHeight;

                break;

            case 9 : //4 victims on screen (bottom left panel)
                localX = TopLeftCornerX;
                localY = TopLeftCornerY + ThreeFourHeight;
                localWidth = TwoThreeFourPanelWidth;
                localHeight = ThreeFourHeight;

                break;

            case 10 : //4 victims on screen (bottom right panel)
                localX = TopLeftCornerX + TwoThreeFourPanelWidth;
                localY = TopLeftCornerY + ThreeFourHeight;
                localWidth = TwoThreeFourPanelWidth;
                localHeight = ThreeFourHeight;

                break;

            default :
                // default Statement
        }

        this.setBounds(localX,localY,localWidth,localHeight);
        pickVictimButton.setBounds((int)(localWidth/(16.0/3)),(localHeight/9),(int)(localWidth/1.6),(int)(localHeight/4.5));
        addPointButton.setBounds((localWidth/32),(int)(localHeight/2.25),(int)(localWidth/3.2),(int)(localHeight/4.5));
        removePointButton.setBounds((int)(localWidth/(32.0/11)),(int)(localHeight/2.25),(int)(localWidth/3.2),(int)(localHeight/4.5));
        markAbsentButton.setBounds((int)(localWidth/(32.0/21)),(int)(localHeight/2.25),(int)(localWidth/3.2),(int)(localHeight/4.5));


        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        this.add(addPointButton);
        this.add(removePointButton);
        this.add(markAbsentButton);
        this.add(pickVictimButton);

        volunteer.setBounds(150, 350,200,35);
        volunteer.setText("Volunteer");
        volunteer.setFocusable(false);
        this.add(volunteer);

    }

}