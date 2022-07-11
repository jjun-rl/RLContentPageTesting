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
//        System.out.println(cp.setContentPages());

//        List<ArrayList<String>> contentPages = new List<ArrayList><>();
        ListIterator<ArrayList<String>> pagesIterator = pages.listIterator();
        String chromeDriver = "/Users/jjun/Documents/IDEAprojects/chromedriver";

        while (pagesIterator.hasNext()) {
            System.out.println("page line: " + pagesIterator.next());
        }
        System.setProperty("webdriver.chrome.driver", chromeDriver);
        WebDriver driver = new ChromeDriver();

        for (ArrayList<String> page : pages) {
//            System.out.println("page: " + page);
            String baseURL = page.get(0);
            System.out.println("baseURL: " + baseURL);
            String actualTitle = page.get(1);
            String expectedTitle = driver.getTitle();
            System.out.println(expectedTitle);
            driver.get(baseURL);

            if (expectedTitle.contains(actualTitle))
                System.out.println("Actual title matches expected title. || " + expectedTitle);
            else
                System.out.println("Actual title: " + expectedTitle +  " || does not match Expected Title: " + actualTitle);
        }
        driver.quit();
    }

}




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

