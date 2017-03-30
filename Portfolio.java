package javastuff;

import java.util.ArrayList;

public class Portfolio{

    private ArrayList<PortfolioItem> portfolio = new ArrayList<>();
    
    public Portfolio(){}

    public void addItem(PortfolioItem item){
	portfolio.add(item);
    }

}

