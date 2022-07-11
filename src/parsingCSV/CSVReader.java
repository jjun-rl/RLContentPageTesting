package parsingCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

//    declare list instance variable, value to be assigned in setContentPages method
    private List<ArrayList<String>> listOfContents;

//    return value > listOfContents (list of lists containing baseURL and page Title)
    public List<ArrayList<String>> setContentPages() {
//        declare string variable for file path
        String file = "/Users/jjun/Documents/csv_files/US Content Pages - LegalNotice.csv";
//        declare string variable line, with value to be assigned in try block
        String line = "";

//        make new ArrayList for pre-existing instance variable
        listOfContents = new ArrayList<>();

//        try/catch block
        try {
//            parses CSV file, extracts baseURL and page title from each line into instance variable ArrayList
//            declares new BufferedReader variable, accepts Reader in its constructor
            BufferedReader br = new BufferedReader(new FileReader(file));
//            readLine() method reads content of CSV file
            while ((line = br.readLine()) != null) {
//                declare local ArrayList variable (using ArrayList for mutability)
                ArrayList<String> eachContent = new ArrayList<>();

//                declare String list "values", will be given the values of each item in a line which has been split by ",'
                String [] values = line.split(",");
//                append only necessary items from "values", values[0] > baseURL; values[2] > page Title, to eachContent ArrayList
//                does the following be better assigned to a variable? (7/11 2:28pm)
                eachContent.add(values[0]);
                eachContent.add(values[2]);
//                append eachContent list with each iteration to listOfContents
                listOfContents.add(eachContent);
            }
//            after loop breaks, return the value of ArrayList variable "listOfContents"
            return(listOfContents);
//            exception thrown if file is not found
        } catch (FileNotFoundException e) {
            e.printStackTrace();
//            exception thrown if input/output error
        } catch(IOException e) {
            e.printStackTrace();
        }
//        why am I returning null? (7/11 2:23PM) --> answer > because this particular method requires a return value
//        null returned if exception thrown (I think?)
        return null;
    }

}
