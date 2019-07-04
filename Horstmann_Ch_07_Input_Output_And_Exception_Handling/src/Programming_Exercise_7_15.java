import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import org.jsoup.nodes.Element;

import java.net.URL;
import java.util.ArrayList;

/**
 * "Using the mechanism described in Special Topic 7.1, write a program that reads all data from a web page and prints all hyperlinks.
 * Extra credit if your program can follow the links that it finds and finds links in those web pages as well."
 *
 * This program will find the links in a web page and then the links in those pages as well. It's an infinite loop and will evt. crash
 * from an OutOfMemoryError or a StackOverflowError.
 *
 */
public class Programming_Exercise_7_15 {


    private final ArrayList<String> results;

    private Programming_Exercise_7_15(String url) throws Exception {

        results = new ArrayList<>(); extractLinks(url);
    }

    private void extractLinks(String originating_web_page) throws Exception{


        Document htmlDoc=Jsoup.connect(originating_web_page).ignoreHttpErrors(true).ignoreContentType(true).followRedirects(false).get();

        Elements hyperLinks=htmlDoc.select("a[href]");
        for(Element link : hyperLinks){

            String url=link.attr("abs:href");
            if(!results.contains(url) && isValidURL(url)){
                System.out.printf("%d: %s\n", results.size() + 1,  url);
                results.add(url);
                extractLinks(url);
            }
        }
    }

    private boolean isValidURL(String url){
        try{
            new URL(url).toURI();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public static void main(String[] args) throws Exception {

        String url="https://www.volkskrant.nl";
        Programming_Exercise_7_15 urlExtractor=new Programming_Exercise_7_15(url);
    }
}
