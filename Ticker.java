package javastuff;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ticker{

    private static String str = "";
    private static String part1 = "http://finance.yahoo.com/d/quotes.csv?s=";
    private static String part3 = "&f=snbaopl1";

    private static Parser parse;

    public static void createPortfolio()
    {
	boolean gettingHandles = true;
	char response;
	String stockhandle;
	Scanner scan = new Scanner(System.in);
	
	while(gettingHandles){
	    System.out.println("Enter the stock you wish to see: ");
	    stockhandle = scan.next();
	    str = str + stockhandle + "+";
	    System.out.println("Would you like to add more?[y/n]: ");
	    response = scan.next().charAt(0);
	    if(response == 'n')
		gettingHandles = false;
	}
	scan.close();
	
	str = str.substring(0, str.length() - 1);
	
	str = part1 + str + part3;
    }

    public static int createTickerData()
    {
	try{
	    parse = new Parser(str);
	}catch(IOException e){
	    e.printStackTrace();
	    return 1;
	}
	return 0;
    }

    public static void main(String args[])
    {
	createPortfolio();
	
	if(createTickerData() == 1){
	    System.out.println("The Handles you entered were incorrect");
	    return;
	}
	
	while(true){
	    parse.printstuff();
	    try {
		TimeUnit.SECONDS.sleep(10);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    createTickerData();
	}
	
    }

}
