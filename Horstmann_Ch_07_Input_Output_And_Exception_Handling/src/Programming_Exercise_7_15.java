
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * "Using the mechanism described in Special Topic 7.1, write a program that reads all data from a web page and prints all
 * hyperlinks. Extra credit if your program can follow the links that it finds and find links in those web pages as well."
 */

public class Programming_Exercise_7_15 {


    private static ArrayList<String> extractLinks(String originating_web_page) throws IOException {

        ArrayList<String> results=new ArrayList<>();
        Document htmlDoc=Jsoup.connect(originating_web_page).timeout(0).ignoreHttpErrors(true).ignoreContentType(true).followRedirects(false).get();
        Elements hyperLinks=htmlDoc.select("a[href]");
        for(Element link : hyperLinks){

            String url=link.attr("abs:href");
            if(!results.contains(url) && isValidURL(url) && !url.equals(originating_web_page+"/")){
                results.add(url);
            }
        }
        return results;
    }

    private static boolean isValidURL(String url){
        try{
            new URL(url).toURI();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public static void main(String[] args) throws IOException{

        String url="https://github.com";
        ArrayList<ArrayList<String>> results=new ArrayList<>();
        results.add(extractLinks(url));
        for(String link : results.get(0)){
            ArrayList<String> list=extractLinks(link);
            results.add(list);
        }
        for(int i=0;i<results.size();i++){
            if(i==0){
                System.out.println(url + " links to: " );
            }
            else{
                System.out.println(results.get(0).get(i-1) + " links to: ");
            }
            if(results.get(i).isEmpty()){
                System.out.println("No links found\n");
            }
            else{
                for (int j=0;j<results.get(i).size();j++) {
                    System.out.printf("%d: %s\n", j+1, results.get(i).get(j));
                }
                System.out.println();
            }
        }
    }
}