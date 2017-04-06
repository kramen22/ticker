package javastuff;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ticker{

    //list of stocks to collect data on

    static String[] handles = {"AAPL", "CHK", "GOOGL"};

    public static void main(String args[]){

	Portfolio portfolio = new Portfolio();

	for(String str : handles){

	    portfolio.addItem(str);

	}

	//print data of stocks

	// portfolio.printData();

	//print the history of the stocks

	Parser parser = new Parser(portfolio);

	parser.printHistoricalData();
	
    }

}
