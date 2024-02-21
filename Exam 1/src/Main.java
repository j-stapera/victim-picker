import java.util.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // List of names on class roster
        String[] names = {"Channing Andrews", "Danny Barmanbekov", "Nate Benson", "Nate Bittle",
        "Excalibur Bunker", "Vincent Climer", "Nicholas Colet", "Fabrice Faustin", "Seth Garner",
        "Nicholas Gilleran", "Hunter Henderson", "Akhil John Bosco", "Jeremiah Jordan", "Bret Kagebein",
        "Owen Klilsgaard", "Cuckie Koch", "Reagan Kohler", "Jace Kramer", "Levi Landers",
        "Abraham Martinez Brito", "Chandler Mason", "Matthew McCallister", "Connor Myers",
        "Oluwatobiloba Olaoye", "Connor Parr", "Markie Salzwedel", "Canon Shaw", "Gavin Smith",
        "Josh Stapera", "Justin Stauffer", "Kevin Stinnett", "Ethan Stucker", "Dakotah Sutton-Rodriguez",
        "Heather Watson"};

        Random rand = new Random();
        /*Create new arraylist of students and store each name from roster in array
            Each student in the roster is randomly generated a number of picks
            to test the sorting algorithm used in the 'chooseTwo' method of the
            Victims class
        */
        ArrayList<Victim> students = new ArrayList<>();
        for(int i = 0; i < names.length; i++){
            students.add(new Victim(names[i]));     //instantiates new victim objects
            students.get(i).setNumberOfPicks(rand.nextInt(10));
        }

        /*
            Each student is randomly marked as either absent or
            present to test adding absences to students
         */
        for(int i = 0; i < students.size(); i++){
            int num = rand.nextInt(2);
            if(num == 0){
                students.get(i).addAbsence();
            }
        }

        /*
        System.out.println("Victims before sorting: ");
        for(Victim victim : students){
            System.out.println(victim.getName() + ": " + victim.getNumberOfPicks());
        }
        */

        //Used collections class to sort array of students by number of picks
        Collections.sort(students);

        /*
            Displays each student and the number of picks they have
            after sorting the array of victims
         */
        System.out.println("");
        System.out.println("Victims w/ number of picks after sorting: ");
        for(Victim victim : students){
            System.out.println(victim.getName() + ": " + victim.getNumberOfPicks());
        }



        /*
              ---Choosing the victims---
         */


        VictimPicker victimPicker = new VictimPicker();

        //Choosing two random victims
        System.out.println("");
        System.out.println("Picking Victims:");
        victimPicker.loadList(students);
        ArrayList<Victim> twoVictims = new ArrayList<>();
        twoVictims = victimPicker.chooseTwo();

        //Display whether the victims chosen are absent or not
        for(int i = 0; i < twoVictims.size(); i++){
            System.out.print(twoVictims.get(i).getName());
            if(twoVictims.get(i).ifAbsent()){
                System.out.println(": Absent");
            }
            else
                System.out.println("");

            //Increase number of picks
            twoVictims.get(i).setNumberOfPicks(twoVictims.get(i).getNumberOfPicks() + 1);
        }

        //Increase the score of the victims chosen
        victimPicker.increaseScore(1);

        /*
            Display the information about the victims chosen.
            Tests whether the last date they were picked on was updated,
            the score was incremented, and the number of picks was incremented
         */
        System.out.println("");
        System.out.println("Victim info after being picked:");

        for(int i = 0; i < twoVictims.size(); i++){
            System.out.println(twoVictims.get(i).getName() + ": ");
            System.out.println("Last picked on: " + twoVictims.get(i).getLastPicked());
            System.out.println("Score: " + twoVictims.get(i).getScore());
            System.out.println("Number of Picks: " + twoVictims.get(i).getNumberOfPicks());
            System.out.println("");
        }
    }
}