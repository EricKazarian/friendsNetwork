package friendsnetwork;

import java.util.ArrayList;

public class friendsnetwork {

	public ArrayList<friend> allPeople;
	
	friendsnetwork(){
		this.allPeople = new ArrayList<friend>();
	}
	
	public void addToNetwork(friend f) {
		this.allPeople.add(f);
	}
	
}
