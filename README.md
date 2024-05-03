

## Overview
The Victim Picker application is a Java-based GUI application designed to manage and display a list of participants, referred to as "victims," in various interactive scenarios.
It features functionality for adding, removing, and scoring victims, displaying questions, managing a timer, and handling file import/export operations.

## Requirements
To run the Victim Picker application, ensure you have the following environment and files set up:

#### Software Requirements
- Java Development Kit (JDK): Java 11 or later must be installed.
- Java Runtime Environment (JRE): Required for running the application.

#### File Requirements
- Questions.txt: This file contains questions displayed to the user. Each question should be on a new line.

  Example:
  > Do you like pie? <br>
  > What color is the sky? <br>
  > How are you today? 
- Victims.txt: This file stores the list of victims. Each victim's details should be on a new line and newline delimited.

  Example:
  > John Snow <br>
  > Edward Scissor Hands<br>
  > Jim Bean<br>
  > Jake
- alarm.wav: An audio file that is played by the application at specific events (e.g., timer end). Format must be a .wav

## Setup Instructions
1. Clone the Repository: Download the provided code files to your local machine or clone the repository if applicable.
2. Prepare Required Files: Ensure Questions.txt, Victims.txt, and alarm.wav are placed in the application's root directory.
3. Compile the Java Files: 
4. Run the Application: 

or <br>
(preferred method)
1. Download current release
2. run .bat

## Usage
- Adding Victims: Victims can be added dynamically through the GUI by interacting with the 'Add Victim' button. You can add up to 4 Victims 
- Removing Victims: Victims can be removed similarly by using the 'Remove Victim' button.
- Scoring: Points can be added or subtracted from a victim's score via the interface.
- Marking Absence: Mark a victim as absent or present using the 'Mark Absent' button.
- Timer: Start, stop, and reset the timer using the timer controls. Adjust the timer by adding or removing time.
- Questions: Navigate through questions using the 'Question' and 'Back' buttons.
- Volunteer: Victims can be Volunteered by using the drop down menu.
- Lifelines: Victims can be awarded lifelines these life lines are single use and will be toggled off once they are used.
- Scoreboard: opens a seprate panel displaying the current scoreboard that is updated in real time.
- Exporting Data: Data can be exported anytime using the 'Export' button, and it is also automatically exported upon closing the application.

  For Victims.txt, it exports the data for the current victims and moves the current Victims.txt to oldVictims-`<time in seconds>`.txt.

  A program generated Victims.txt will take its place, use this for future executions.
- Importing Data: Import questions and victims using the 'Import' button to load from the respective text files.

## Features
- Victim Management: Add, remove, and update the details and scores of victims.
- Timer Control: Integrated timer with audio alerts for timing activities or events.
- Question Handling: Display and cycle through questions from an external file.
- Dynamic Interface: Supports a variable number of victim panels, adjusted through user interaction.
- File Handling: Robust import and export functionality for managing application data through text files.

# Notes
Ensure that the file paths and names are correctly set as the application expects Questions.txt, Victims.txt, and alarm.wav in the specific format mentioned.
The application is designed to handle exceptions and user errors, but proper file formats must be maintained for optimal performance.
