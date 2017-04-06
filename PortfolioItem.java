package javastuff;

import yahoofinance.*;
import java.io.*;

public class PortfolioItem {

    private Stock stock;
    private String name;

    public PortfolioItem(String str){

	try{
	    this.stock = YahooFinance.get(str);
	}catch (IOException e){
	    e.printStackTrace();
	}

	this.name = str;
	    
    }

    public String getName(){

	return this.name;
	    
    }

    public Stock getStock(){

	return this.stock;
	
    }

    public void print(){
	this.stock.print();
    }
    
}

