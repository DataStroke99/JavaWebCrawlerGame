
package webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Crawl2 {
    
    public static Queue<URL> queue = new LinkedList<>();

    private static int count = 1;
    static URL url, url2 ;
    

    
    
    public static String BFS(String initial, String end){
        boolean found = true;
        String cnt;
        try {
            
            url = new URL(initial);
            url2 = new URL(end);
            
            queue.add(url);
            
        } catch (Exception e) {
        }
        

        
        while (!queue.isEmpty()) {
            String web = url.toString();
            
            try {
             Document doc = Jsoup.connect(web).get();
             Elements linksOnPage = doc.select("a[href]");
             
             
             for(Element element:linksOnPage){
                        String urlText = element.attr("abs:href");
                        URL discoveredURL = new URL(urlText);
                        queue.add(discoveredURL);
                        System.out.println(count);
                        
         
                        if(discoveredURL.equals(url2)){
                            
                            System.err.println( url2+"******");
                            System.out.println("Seperation between the topics : "+count);
                            cnt = Integer.toString(count);
                            return cnt;
                            
                        
                        }                    
                    
                    }
             count++ ;       
             url = queue.poll();
               
            } catch (IOException e) {
            }
            
            
          }
        return "Not Found";
           
        }
          
    
}
