package friendsnetwork;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class friendsNetwork {

	public ArrayList<friend> allPeople;
	
	friendsNetwork(){
		this.allPeople = new ArrayList<friend>();
	}
	
	public void addToNetwork(friend f) {
		this.allPeople.add(f);
	}
	
	public boolean inNetwork(friend f) {
		return allPeople.stream().anyMatch(i -> i.isEqual(f));
	}
	
	public friend[] streamOfPeople() {
		int size = allPeople.size();
		friend[] arr = new friend[size];
	    IntStream.range(0, size).forEach(i -> arr[i] = allPeople.get(i));
	    return arr;
	}
	
}
