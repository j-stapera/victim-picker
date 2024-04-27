import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class FileHandler {
    //does import
    public static ArrayList<Victim> importVictims(){
        var in = new Scanner("Victims.txt");

        //get first line
        // if first line is an L then it is program generated list
        // else user generated
        System.out.println(in.next());

        // program generated
        // each item in this array is a victim and their corresponding data
        // data is seperated into two delimited segements
        // * delimiter - seperates variable name:value combos
        // : delimiter - seperates variable and values
        // Example with uninitated values:
        // Name:Channing Andrews*Score: 0*Last picked:null*Absent:false*Absences:[]*Number of picks:0
        // victim vars order is: name*score*last picked*absent*absences*number of picks

        // user generated
        // line containing student first and last name, delimited by ,

        return null;
    }

    public static ArrayList<String> importQuestions(){
        var in = new Scanner("Questions.txt");

        // line containing a question, no delimiter


        return null;
    }

    // does export
    // currently only exports the victim data
    public static void Export(ArrayList<String> exportList) {

        File newFile = new File("Victims.txt");
        File oldFile = new File("OldVictims-" + Instant.now().getEpochSecond() + ".txt"); //appends date in seconds
                                                                                                    // this will need to be improved - Josh

        // if Victims.txt already exists, move that data to oldVictims-{seconds}.txt
        // then proceed as normal
        if (newFile.exists()){
            try {
                Files.move(newFile.toPath(), oldFile.toPath());
            } catch(IOException e){
                System.err.println("Error moving victim file to oldVictim");
                e.printStackTrace();
            }
        }
        try(PrintWriter writer = new PrintWriter(new FileWriter(newFile))){

            for (String item : exportList){
                writer.println(item);
            }

        } catch (IOException e) {
            System.err.println("Error writing to the file: Victim.txt");
            e.printStackTrace();
        }
    }
}
