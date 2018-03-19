package simplespider_test;

import java.util.ArrayList;
import java.util.List;

public class JianDanHtmlParser implements Runnable {
    private String html;
    public JianDanHtmlParser(String html) {
        this.html = html;
     
    }
    @Override
    public void run() {
        System.out.println("==========开始============");
        List<String> list = new ArrayList<String>();
        html = html.substring(html.indexOf("VIP套图"));
       // System.out.print(html);
        String[] images = html.split("</p>");
                
        for(String image:images){
        	String[] ss=image.split("/n<p>");
        	for(String s:ss){
        		if(s.indexOf("src=")>0){
        			try{
        				int i=s.indexOf("src=\"")+"src=\"".length();
        				list.add(s.substring(i,s.indexOf("\" />",i+1)));
        				//System.out.println(list);
        			}catch(Exception e){
        				System.out.println(s);       				
        			}       			       			
        		}
        	}
        }
               
        for(String imageUrl : list){
        	new Thread(new JianDanImageCreator(imageUrl)).start();
        }
    }
}