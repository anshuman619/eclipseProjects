package com.tut.CoronaUpdate;

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App 
{
	
	public static void getData()throws Exception {
		String country;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the country name:\t");
		country=sc.nextLine();
		String url="https://www.worldometers.info/coronavirus/country/"+country+"/";
		Document doc=Jsoup.connect(url).get();
		System.out.println("Title: "+doc.title());
		System.out.println(" ");
		Elements elements=doc.select("#maincounter-wrap");
		for(Element e: elements)
		{
			String text=e.select("h1").text();
			String count=e.select(".maincounter-number>span").text();
			System.out.println(text +" : " +count);
			
		}
		
	}
	
	
    public static void main( String[] args )throws Exception
    {
        
        App.getData();
    }
}
