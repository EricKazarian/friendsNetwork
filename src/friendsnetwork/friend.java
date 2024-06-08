package friendsnetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class friend {
	private String name;
	private int age;
	private friendsNetwork networkPointer;
	/**
	 * @peerObject
	 */
	protected Set<friend> friends;
	
	friend(String name, int age, friendsNetwork network){
		this.name = name;
		this.age = age;
		this.friends = new HashSet<friend>();
		network.addToNetwork(this);
		networkPointer = network;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	public friendsNetwork getNetwork() {
		return networkPointer;
	}
	
	/**
	 * @post | hasAsFriend(f)
	 * @post | f.hasAsFriend(this)
	 */
	public void addAsfriend(friend f) {
		if (f.isEqual(this) || !getNetwork().inNetwork(f)) {
			throw new IllegalStateException("nuh uh");
		}
		this.friends.add(f);
		if (!f.hasAsFriend(this)) {
			f.addAsfriend(this);
		}
	}
	
	public void removeAsFriend(friend f) {
		friends.remove(f);
		if (f.hasAsFriend(f)){
			f.removeAsFriend(this);
		}
	}
	
	public boolean hasAsFriend(friend f) {
		return this.friends.contains(f);
	}
	
	public boolean indirectFriend(friend f) {
		if(hasAsFriend(f)) {
			return true;
		}
		return friends.stream().anyMatch(i -> i.hasAsFriend(f));
	}
	
	public int underAgeFriends() {
		return (int) this.friends.stream().map(i -> i.getAge()).filter(a -> a < 18).count();
	}
	
	public boolean isEqual(friend f) {
		if (f.getAge() != getAge()) {
			return false;
		} else if (!f.getName().equals(getName())) {
			return false;
		} else {
		return true;
			}
		}
	
	
	
}
