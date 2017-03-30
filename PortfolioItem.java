package javastuff;

public class PortfolioItem{

    private String handle, name;
    private float bid, ask, open, lastClose, lastTick;

    public PortfolioItem(String handle, String name, float bid, float ask, float open, float lastClose, float lastTick){
	this.handle = handle;
	this.name = name;
	this.bid = bid;
	this.ask = ask;
	this.open = open;
	this.lastClose = lastClose;
	this.lastTick = lastTick;
    }

    public boolean setLastTick(float newTick){

	if(newTick != 0){
	    this.lastTick = newTick;
	    return true;
	}
	return false;

    }

}

