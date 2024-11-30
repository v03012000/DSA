package Leetcode;
// https://leetcode.ca/2019-04-25-1242-Web-Crawler-Multithreaded/

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

//Assume we have 10,000 nodes and 1 billion URLs to crawl. We will deploy the same software onto each node. The software can know about all the nodes. We have to minimize communication between machines and make sure each node does equal amount of work. How would your web crawler design change?
//What if one node fails or does not work?
//How do you know when the crawler is done?


public class WEBCrawlerMultiThread implements Runnable{
    public String startUrl;
    public String hostname;
    public HtmlParser htmlparser;
    public static Set<String> result;

    public WEBCrawlerMultiThread(HtmlParser htmlparser, String startUrl, String hostname) {
        this.htmlparser = htmlparser;
        this.startUrl = startUrl;
        this.hostname = hostname;
    }

    @Override
public void run(){
        if(startUrl.contains(hostname) && !result.contains(startUrl)){
            result.add(startUrl);
            List<Thread> threads = new ArrayList<>();
            for(String url: htmlparser.getUrls(startUrl)){
                WEBCrawlerMultiThread crawler = new WEBCrawlerMultiThread(htmlparser, url, hostname);
                Thread thread = new Thread(crawler);
                thread.start();
                threads.add(thread);
            }
            for(Thread thread:threads){
                join(thread);
            }
        }
    }

    public void join(Thread thread){
        try {
            thread.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private static String getHostName(String url){
        String host = "";
        host = url.substring(7);
        host = host.split("/")[0];
        return host;
    }

    public static void main(String[] args) {
        String start = "http://news.yahoo.com/news/topics";
        List<String> urls = List.of(new String[]{
                "http://news.yahoo.com", "http://news.yahoo.com/news", "http://news.yahoo.com/news/topics","http://news.google.com",
                "http://news.yahoo.com/us"
        });

        List<List<Integer>> edges=  new ArrayList<>();
        edges.add(List.of(2,0));
        edges.add(List.of(2,1));
        edges.add(List.of(3,2));
        edges.add(List.of(3,1));
        edges.add(List.of(0,4));
        HtmlParser htmlParser = new HtmlParser() {
            @Override
            public List<String> getUrls(String str) {
                List<String> returned_urls = new ArrayList<>();
                int ind=0,i=0;
                for( String url: urls){
                    if(url.equals(str)){
                        ind=i;
                    }
                    i++;
                }
                for(List<Integer> edge:edges){
                    if(edge.get(0) == ind){
                        returned_urls.add(urls.get(edge.get(1)));
                    }
                }
                return returned_urls;
            }
        };

       // System.out.println(start);
 WEBCrawlerMultiThread crawler = new WEBCrawlerMultiThread(htmlParser,start,getHostName(start));
        ConcurrentHashMap<String,Boolean> visited = new ConcurrentHashMap<>();
        result = ConcurrentHashMap.newKeySet();
        Thread thread = new Thread(crawler);
        thread.start();
        crawler.join(thread);
        List<String> res = new ArrayList<>(result);
        for(String url: res){
            System.out.println(url);
        }



    }
}


