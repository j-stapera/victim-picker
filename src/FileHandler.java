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
        // line containing variable:value combos, delimited by *

        // user generated
        // line containing student first and last name, delimited by ,

        return null;
    }

    public static ArrayList<String> importQuestions(){
        var in = new Scanner("Questions.txt");

        // line containing a question, no delimiter


        return null;
    }
    //does export
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


        } catch (IOException e) {
            System.err.println("Error writing to the file: Victim.txt");
            e.printStackTrace();
        }
    }
}
