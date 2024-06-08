package friendsnetwork;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class friendsNetworkTest {

	@Test
	void test() {
		friendsNetwork net = new friendsNetwork();
//		IntStream.range(0, 10).forEach(net.addToNetwork(new friend()));
		friend paul = new friend("paul", 24, net);
		friend miniladd = new friend("miniladd", 24, net);

		friend friend1 = new friend("f1", 24, net);
		friend friend2 = new friend("f2", 24, net);
		friend friend3 = new friend("f3", 24, net);
		friend friend4 = new friend("f4", 24, net);
		friend[] friendsOfPaul = {friend1, friend2, friend3, friend4};
		IntStream.range(0, friendsOfPaul.length).forEach(i -> paul.addAsfriend(friendsOfPaul[i]));
		assert(IntStream.range(0, friendsOfPaul.length).allMatch(i -> friendsOfPaul[i].hasAsFriend(paul)));
		assert(IntStream.range(0, friendsOfPaul.length).allMatch(i -> paul.hasAsFriend(friendsOfPaul[i])));
		assert(IntStream.range(0, friendsOfPaul.length).noneMatch(i -> friendsOfPaul[i].hasAsFriend(miniladd)));
		assert(paul.underAgeFriends() == 0);

		friend c1 = new friend("f1", 17, net);
		friend c2 = new friend("f2", 12, net);
		friend c3 = new friend("f3", 3, net);
		friend c4 = new friend("f4", 14, net);
		friend f5 = new friend("f5", 18, net);
		friend f6 = new friend("f6", 99, net);
		friend[] friendsOfMiniladd = {friend1, c1, c2, c3, c4, f5, f6};
		Arrays.stream(friendsOfMiniladd).forEach(i -> miniladd.addAsfriend(i));
//		assert(IntStream.range(0, friendsOfPaul.length).allMatch(i -> friendsOfPaul[i].hasAsFriend(paul)));
//		assert(IntStream.range(0, friendsOfPaul.length).allMatch(i -> paul.hasAsFriend(friendsOfPaul[i])));
		assert(Arrays.stream(friendsOfMiniladd).allMatch(i -> net.inNetwork(i)));
		assert(miniladd.indirectFriend(paul));
		assert(paul.indirectFriend(miniladd));
		assert(miniladd.underAgeFriends() == 4);
		assert(paul.underAgeFriends() == 0);

	}

}
