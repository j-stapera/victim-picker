import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.*;


public class FileHandler {
    //does import
    public static ArrayList<Victim> importVictims(){
        List<Map<String,String>> victimStream = new ArrayList<>();
        ArrayList<Victim> victimArrayList = new ArrayList<>();
        //TODO: check if program generated char is present
        try {
            var in = new Scanner(Path.of("Victims.txt"));
            in.useDelimiter("\n");
            //get first line
            // if first line is an L then it is program generated list
            // else user generated

            // program generated
            // each item in this array is a victim and their corresponding data
            // data is separated into two delimited segments
            // * delimiter - separates variable name:value combos
            // : delimiter - separates variable and values
            // Example with uninitiated values:
            // Name:Channing Andrews*Score: 0*Last picked:null*Absent:false*Absences:[]*Number of picks:0
            victimStream = in.tokens() // tokenize file based on \n delimiter, returns Stream<String>
                .<Map<String,String>> mapMulti((victim, mapConsumer) -> { //creates a Stream<Map<String,String>>

                    String[] victimParts = victim.split("[*]"); //splits into name:value pairs
                    Map<String, String> victimPieces = new HashMap<>();
                    for (String victimPart : victimParts){
                        // gets the name of the variable
                        String varName = victimPart.substring(0, victimPart.indexOf(':'));
                        // gets the value of the variable
                        String varValue = victimPart.substring(victimPart.indexOf(':')+1);
                        // put that pair into an entry in a map
                        victimPieces.put(varName,varValue);
                    }

                    // remove \r from num picks value
                    String fixedValue = victimPieces.get("Number of picks").replaceFirst("\r","");
                    victimPieces.put("Number of picks", fixedValue);
                    // add map to Stream
                    mapConsumer.accept(victimPieces);
                })
                .toList(); // collect Stream<Map<String,String>> into an ArrayList<Map<String,String>>

            // can leave try-catch now
            in.close();
        } catch(IOException e){
            System.err.println("shit broke");
        }
        // calling keys directly, IF NAME OF KEY CHANGES IN Victims.txt
        // THEN IT NEEDS TO BE CHANGED HERE!!!!
        for (Map<String,String> victim : victimStream){
            //get victim name
            // technically can be called directly in the constructor but this looks better
            String victimName = victim.get("Name");

            // convert vars to their proper types
            // Cast absences to ArrayList<LocalDate>
            ArrayList<LocalDate> absenceList = new ArrayList<>();
            if (!victim.get("Absences").isEmpty()) {
                String absences = victim.get("Absences");
                absences = absences.substring(1, absences.length() - 1);
            }

            // cast Last Picked to LocalDate
            LocalDate lastPicked = null;
            // only adds last picked date if last picked IS NOT null
            if (!victim.get("Last picked").equals("null")) {
                String temp = victim.get("Last picked");
                String[] temp2 = temp.split("-"); //need to convert this to ints
                // date order is YYYY-MM-DD
               lastPicked = LocalDate.of(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]));
            }

            // cast Score and Number of Picks to int
            int score = Integer.parseInt(victim.get("Score"));
            int numPicks = Integer.parseInt(victim.get("Number of picks"));


            // victim constructor: name, score, lastPicked, absences, numberOfPicks
            victimArrayList.add(new Victim(victimName,score,lastPicked,absenceList,numPicks));
        }
        return victimArrayList;

        // user generated
        // line containing student first and last name, delimited by ,


    }

    public static ArrayList<String> importQuestions(){
        ArrayList<String> questionList = new ArrayList<>();
        var in = new Scanner("Questions.txt");

        // line containing a question, no delimiter


        return questionList;
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
