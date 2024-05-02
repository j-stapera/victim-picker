import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class FileHandler {

    /**
     * imports Victims, requires program generated list
     * or user generated list in the format of name of victim
     * and one victim per line
     * @return
     * List of type victim
     */
    public static List<Victim> importVictims() {

        List<Victim> victimList = new ArrayList<>();
        try {
            var in = new Scanner(Path.of("Victims.txt"));
            in.useDelimiter("\n");
            // get first line
            // if first line is an L then it is program generated list
            // else user generated
            if (in.nextLine().equals("L")) {
                // program generated list handling
                // program generated
                // each item in this array is a victim and their corresponding data
                // is separated into two delimited segments
                // * delimiter - separates variable name:value combos
                // : delimiter - separates variable and values
                // Example with uninitiated values:
                // Name:Channing Andrews*Score: 0*Last picked:null*Absent:false*Absences:[]*Number of picks:0

                // NOTE: I realize that this may be an improper use of Streams, but it's cleaner
                ArrayList<Map<String, String>> victimStream = in.tokens() // tokenize file based on \n delimiter, returns Stream<String>
                        .<Map<String, String>>mapMulti((victim, mapConsumer) -> { //creates a Stream<Map<String,String>>
                            String[] victimParts = victim.split("[*]"); //splits into name:value pairs
                            Map<String, String> victimPieces = new HashMap<>();
                            for (String victimPart : victimParts) {
                                // gets the name of the variable
                                String varName = victimPart.substring(0, victimPart.indexOf(':'));
                                // gets the value of the variable
                                String varValue = victimPart.substring(victimPart.indexOf(':') + 1);
                                // put that pair into an entry in a map
                                victimPieces.put(varName, varValue);
                            }

                            // remove \r from num picks value
                            String fixedValue = victimPieces.get("Number of picks").replaceFirst("\r", "");
                            victimPieces.put("Number of picks", fixedValue);
                            // add map to Stream
                            mapConsumer.accept(victimPieces);
                        })
                        .collect(Collectors.toCollection(ArrayList::new)); // collect Stream<Map<String,String>> into an ArrayList<Map<String,String>>
                // close file
                in.close();

                // calling keys directly, IF NAME OF KEY CHANGES IN Victims.txt
                // THEN IT NEEDS TO BE CHANGED HERE!!!!
                for (Map<String, String> victim : victimStream) {
                    //get victim name
                    // technically can be called directly in the constructor but this looks better
                    String victimName = victim.get("Name");

                    // convert vars to their proper types
                    // Cast absences to ArrayList<LocalDate>
                    ArrayList<LocalDate> absenceList = new ArrayList<>();
                    if (!victim.get("Absences").isEmpty()) {
                        String absences = victim.get("Absences");
                        String[] absencesArray = absences.substring(1, absences.length() - 1).split(",");

                        for (String absence : absencesArray){
                            String[] absenceDate = absence.split("-");
                            absenceList.add(LocalDate.of(Integer.parseInt(absenceDate[0]),Integer.parseInt(absenceDate[1]),Integer.parseInt(absenceDate[2])));
                        }
                    }

                    // cast Last Picked to LocalDate
                    LocalDate lastPicked = null;
                    // only adds last picked date if last picked IS NOT null
                    if (!victim.get("Last picked").equals("null")) {
                        String[] date = victim.get("Last picked").split("-");
                        // date order is YYYY-MM-DD
                        lastPicked = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
                    }

                    // cast Score and Number of Picks to int
                    int score = Integer.parseInt(victim.get("Score"));
                    int numPicks = Integer.parseInt(victim.get("Number of picks"));


                    // victim constructor: name, score, lastPicked, absences, numberOfPicks
                    victimList.add(new Victim(victimName, score, lastPicked, absenceList, numPicks));
                }

            // user generated
            // line containing student first and last name, delimited by \n
            } else {
                victimList = in.tokens()
                        .map(e-> e.replaceFirst("\r","")) //remove weird \r behavior
                        .map(Victim::new)
                        .collect(Collectors.toCollection(ArrayList::new));
            }

        } catch (IOException e) {
            System.err.println("Error reading from Victim.txt");
            e.printStackTrace();
        }

        return victimList;
    }

    /**
     * Imports a user list of questions, one question per line
     * @return
     * List of type string containing questions
     */
    public static ArrayList<String> importQuestions(){
        ArrayList<String> list = new ArrayList<>();
        try {
            var in = new Scanner(Path.of("Questions.txt"));
            // questions delimited by \n
            in.useDelimiter("\n");

            // tokenize the file and then put those questions to a list
            list = in.tokens()
                    .map(e-> e.replaceFirst("\r", "")) //remove weird \r that appears
                    .collect(Collectors.toCollection(ArrayList::new)); //collects to ArrayList
        } catch (IOException e){
            System.err.println("Error importing Questions.txt");
            e.printStackTrace();
        }
        return list;
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
            writer.println("L"); //signifies file is program generated
            for (String item : exportList){
                writer.println(item); //writes line of list to file
            }

        } catch (IOException e) {
            System.err.println("Error writing to the file: Victim.txt");
            e.printStackTrace();
        }
    }
}
