import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        File file = new File("Victims.txt");

        // if Victims.txt already exists, rewrite that data to oldVictims{date}.txt
        // then proceed as normal
        if (file.exists()){

        }
        try(PrintWriter writer = new PrintWriter(new FileWriter(file))){

        } catch (IOException e) {
            System.err.println("Error writing to the file: Victim.txt");
            e.printStackTrace();
        }
    }
}
