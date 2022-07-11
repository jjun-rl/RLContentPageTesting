package parsingCSV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class seleniumCSV {
//    main driver method
    public static void main(String[] args) {
//        declare new object variable from CSVReader class to access listOfContents
        CSVReader content = new CSVReader();

//        instantiate new ArrayList with return value of CSVReader class
        List<ArrayList<String>> pages = content.setContentPages();

//        Getting ListIterator
        ListIterator<ArrayList<String>> pagesIterator = pages.listIterator();

        String chromeDriver = "/Users/jjun/Documents/IDEAprojects/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        WebDriver driver = new ChromeDriver();

//        Traversing elements using next() method
        while (pagesIterator.hasNext()) {
//            System.out.println("While Loop > page line: " + pagesIterator.next());

//        for-each loop creates Internal Iterator
            for (ArrayList<String> page : pages) {
                System.out.println("line: " + page);
                String baseURL = page.get(0);
//                System.out.println("baseURL: " + baseURL);

                driver.get(baseURL);
                String expectedURL = driver.getCurrentUrl();

//                if (expectedURL != baseURL) {
//                    System.out.println("FALSE: URL match");
//                    System.out.println("getCurrentURL: " + expectedURL);
//                }
//                else
//                    System.out.println("TRUE: URL match");

                String actualTitle = page.get(1);
                System.out.println("actualTitle: " + actualTitle);

                String expectedTitle = driver.getTitle();
                System.out.println("expectedTitle: " + expectedTitle);

                if (expectedTitle.contains(actualTitle)) {
                    System.out.println("PASS: title DOES match" );
                    System.out.println("");
                }
                else {
                    System.out.println("ERROR: title DOES NOT match");
                    System.out.println("");
                }
            }
//            driver.quit();
        }
        driver.quit();

    }

}


//        List<ArrayList<String>> contentPages = new List<ArrayList><>();

//        contentPages.add(listOfContents)
//
//        System.setProperty("webdriver.chrome.driver", "/Users/jjun/Documents/IDEAprojects/chromedriver");
//        WebDriver driver = new ChromeDriver();
//
//        arr.forEach((list) -> {
//            list.forEach((contentPage) -> {
//                String baseURL = String.valueOf(arr.get(0));
//                System.out.println("baseURL: " + baseURL);
//                driver.get(baseURL);
//
//                String expectedTitle = driver.getTitle();
//                System.out.println("expectedTitle: " + expectedTitle);
//
//                String actualTitle = String.valueOf(arr.get(1));
//                System.out.println("actualTitle: " + actualTitle);
//
//                if (expectedTitle.contains(actualTitle))
//                    System.out.println("Actual title matches expected title. || " + expectedTitle);
//                else
//                    System.out.println("Actual title: " + expectedTitle +  " || does not match Expected Title: " + actualTitle);
//            }) ;
//
//        });

