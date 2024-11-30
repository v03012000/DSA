package Leetcode;

import java.util.*;

// https://algo.monster/liteproblems/1236

interface HtmlParser {
    List<String> getUrls(String str);
}


public class WEBCrawler {
private final Set<String> visited = new HashSet<String>();

public Set<String> getVisitedUrls() {
    return visited;
}
    private void dfs(String url,HtmlParser htmlParser){
    if(visited.contains(url)) return;
    visited.add(url);
        List<String> next;
        next = (List<String>) htmlParser.getUrls(url);
        for( String next_url: next){
            if(getHostName(url).equals(getHostName(next_url))) {
                dfs(next_url,htmlParser);
            }
        }
  }

    private String getHostName(String url){
        String host = "";
        host = url.substring(7);
        host = host.split("/")[0];
        return host;
    }

    public static void main(String[] args) {
        WEBCrawler webcrawler = new WEBCrawler();
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
        webcrawler.dfs(start,htmlParser);
        for( String url_ans: webcrawler.getVisitedUrls()){
            System.out.println(url_ans);
        }
    }
}

