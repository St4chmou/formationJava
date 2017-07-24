package jef.part2;

public class Swap {
	public static void main(String[] args) {

		// *****************************************
		// Swap integers :

		int i1 = 1;
		int i2 = 2;

		int i;
		i = i1;
		i1 = i2;
		i2 = i;

		System.out.println(i1 + "//" + i2);
		// it works
		// *****************************************

		// *****************************************
		// Swap Users :

		User u1 = new User("U1");
		User u2 = new User("U2");

		User u;
		u = u1;
		u1 = u2;
		u2 = u;

		System.out.println(u1 + "//" + u2);
		// it works
		// *****************************************
	}
}
