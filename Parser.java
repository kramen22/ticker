// This is a test comment
package javastuff;

import yahoofinance.histquotes.*;
import yahoofinance.*;
import java.io.*;

public class Parser{

    private Portfolio portfolio;

    public Parser(Portfolio port){
	this.portfolio = port;
    }

    public void printHistoricalData(){

	try{
	    PrintWriter writer = new PrintWriter("historicaldata.txt", "UTF-8");

	    for(PortfolioItem item : portfolio.getPortfolio()){

		try{

		    //for debugging
		    writer.println("\n\n" + "attempting to get data for " + item.getName() + "\n");
		
		    for(HistoricalQuote quote : item.getStock().getHistory()){

			writer.println(quote.getSymbol() + quote.getOpen().doubleValue() + quote.getClose().doubleValue() + quote.getHigh().doubleValue() + quote.getLow().doubleValue() + "\n");
		    }   
		    
		} catch(IOException e){
		    e.printStackTrace();
		}

	    }

	    writer.close();
	    
	} catch(IOException e){
		e.printStackTrace();
	}
    }
}
