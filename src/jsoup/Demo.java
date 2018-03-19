package jsoup;
import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
public class Demo {
	public static void main(String[] args) throws IOException{
//		http://liuliushe.com/%e6%96%87%e7%ab%a0%e5%bd%92%e6%a1%a3
//		Document doc=Jsoup.connect("http://liuliushe.com/chunytu/4218.html").get();
		Document doc=Jsoup.connect("http://liuliushe.com/%e6%96%87%e7%ab%a0%e5%bd%92%e6%a1%a3").get();
//		String title=doc.title();
//		String text=doc.body().text();
//		Element link = doc.select("a").first();
		Elements links =doc.select("a[href]");
		for(Element link:links){
			System.out.println(link);
		}
	}

}
