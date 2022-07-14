package parsingCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {


//    *future thinking --> include method to iterate through all CSV files within a folder*



//    Declare instance variable
    private static List<ArrayList<String>> listOfContents;

//    Renamed method to "get" instead of "set", and now accepts file path as input
    public static List<ArrayList<String>> getContents(String filePath) {
//        Declare primitive variable
        String line = "";

//        Create new ArrayList object
        listOfContents = new ArrayList<>();

//        try/catch block
        try {
//            Assign BufferedReader object (which accepts new FileReader object) to declared BufferedReader reference variable
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {
//                Create new ArrayList object, reference variable will change with each iteration
                ArrayList<String> contentLine = new ArrayList<>();

                String[] values = line.split(",");

//                if conditional to account for empty lines within CSV file (e.g, ",,")
                if (values.length != 0) {
//                    System.out.println("values[0]" + values[0]);
//                    add base URL and page Title to contentLine ArrayList object
                    contentLine.add(values[0]);
                    contentLine.add(values[2]);
//                    add contentLine value to reference variable listOfContents
                    listOfContents.add(contentLine);
                }
            }
//            System.out.println("listOfContents: " + listOfContents); --> to check that there aren't anomalies in list that could case problems with seleniumCSV
            return (listOfContents);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

//CODE BEFORE REFACTOR 7/13/2022

//    private, restricted access
//    private static List<ArrayList<String>> listOfContents;
//
////    declare list instance variable, value to be assigned in setContentPages method
//
////    return value > listOfContents (list of lists containing baseURL and page Title)
////    public List<ArrayList<String>> setContentPages() {
//
//    //    GETTER
////    public List<ArrayList<String>> getContentPages(List<ArrayList<String>> newListOfContents){
////    public static List<ArrayList<String>> getContents(String filePath) {
////        return listOfContents;
////    }
////    SETTER
////    public static List<ArrayList<String>> setContents(String filePath) {
//    public static void setContentPages(List<ArrayList<String>> listOfContents) {
//        this.listOfContents = listOfContents;
////        declare string variable for file path
////        String file = "/Users/jjun/Documents/csv_files/US Content Pages - ParentCategory.csv";
////        declare string variable line, with value to be assigned in try block
////        this.listOfContents = contentList;
//
//        String line = "";
//
////        make new ArrayList for pre-existing instance variable
//        contents = new ArrayList<>();
//
////        try/catch block
//        try {
////            parses CSV file, extracts baseURL and page title from each line into instance variable ArrayList
////            declares new BufferedReader variable, accepts Reader in its constructor
//            BufferedReader br = new BufferedReader(new FileReader(filePath));
////            readLine() method reads content of CSV file
//            while ((line = br.readLine()) != null) {
////                declare local ArrayList variable (using ArrayList for mutability)
//                ArrayList<String> eachContent = new ArrayList<>();
//
////                declare String list "values", will be given the values of each item in a line which has been split by ",'
//                String [] values = line.split(",");
//
////                need to strip white space from csv file
//                if(values.length != 0) {
//                    System.out.println(values[0]);
////                append only necessary items from "values", values[0] > baseURL; values[2] > page Title, to eachContent ArrayList
////                does the following be better assigned to a variable? (7/11 2:28pm)
//                    eachContent.add(values[0]);
//                    eachContent.add(values[2]);
////                append eachContent list with each iteration to listOfContents
//                    listOfContents.add(eachContent);
//                }
//            }
////            after loop breaks, return the value of ArrayList variable "listOfContents"
////            return(listOfContents);
////            exception thrown if file is not found
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
////            exception thrown if input/output error
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
////        why am I returning null? (7/11 2:23PM) --> answer > because this particular method requires a return value
////        null returned if exception thrown (I think?)
////        return null;


//}
