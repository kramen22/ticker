package javastuff;

import java.util.ArrayList;

public class Portfolio{

    // where the portfolio items live only one instance should ever exist
    private ArrayList<PortfolioItem> portfolio = new ArrayList<>();

    // just to initialize the ArrayList
    public Portfolio(){
    }

    public void addItem(String str){

	PortfolioItem item = new PortfolioItem(str);

	portfolio.add(item);
	
    }

    public void printData(){

	for(PortfolioItem item : portfolio){
	    item.print();
	}
	
    }

    public ArrayList<PortfolioItem> getPortfolio(){
	return this.portfolio;
    }
    
}

