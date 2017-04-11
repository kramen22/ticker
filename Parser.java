// This is a test comment
package javastuff;

import yahoofinance.histquotes.*;
import yahoofinance.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

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

    public double[][] getHistoricalData(int portfolioItem)
    {
	double[][] output = new double[1][4];
	List<HistoricalQuote> quotes = new ArrayList<>();
	
	PortfolioItem item = portfolio.getPortfolio().get(portfolioItem);
	
	try{

	    output = new double[item.getStock().getHistory().size()][4];
	    quotes = item.getStock().getHistory();
		
       	}catch(IOException e){

	    e.printStackTrace();

	}

	for(int i = 0; i < quotes.size(); i++){
	    output[i][0] = quotes.get(i).getOpen().doubleValue();
	    output[i][1] = quotes.get(i).getClose().doubleValue();
	    output[i][2] = quotes.get(i).getHigh().doubleValue();
	    output[i][3] = quotes.get(i).getLow().doubleValue();
	}

	return output;
	    
    }
}   

