package friendsnetwork;

import java.util.ArrayList;

public class friend {
	private String name;
	private int age;
	
	/**
	 * @peerObject
	 */
	private ArrayList<friend> friends;
	
	friend(String name, int age, friendsnetwork network){
		this.name = name;
		this.age = age;
		this.friends = new ArrayList<friend>();
		network.addToNetwork(this);
	}
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * @post | hasAsFriend(f)
	 * @post | f.hasAsFriend(this)
	 */
	public void addAsfriend(friend f) {
		this.friends.add(f);
		if (!f.hasAsFriend(this)) {
			f.addAsfriend(this);
		}
	}
	
	public void removeAsFriend(friend f) {
		friends.remove(f);
		if (f.hasAsFriend(f){
			f.removeAsFriend(this);
		}
	}
	
	public boolean hasAsFriend(friend f) {
		return this.friends.contains(f);
	}
	
	public boolean indirectFriends(friend f) {
		int size = friends.size();
		for (int i = 0; i < size; i++) {
			if (friends.get(i).hasAsFriend(f)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
