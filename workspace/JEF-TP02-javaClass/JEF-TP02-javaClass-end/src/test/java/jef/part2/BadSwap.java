package jef.part2;

public class BadSwap {
	public static void main(String[] args) {

		// *****************************************
		// Swap integers :
		int i1 = 1;
		int i2 = 2;
		swapint(i1, i2);
		System.out.println(i1 + "//" + i2);
		// it doesn't work because Java copies and passes the reference by
		// value, not the object.
		// i1 and a are TWO references of the same object
		// *****************************************

		// *****************************************
		// Swap Users :
		User u1 = new User("U1");
		User u2 = new User("U2");
		swapObject(u1, u2);
		System.out.println(u1 + "//" + u2);
		// it doesn't work because Java copies and passes the reference by
		// value, not the object.
		// u1 and a are TWO references of the same object
		// *****************************************
	}

	private static void swapint(int a, int b) {
		int i;
		i = a;
		a = b;
		b = i;
	}

	private static void swapObject(User a, User b) {
		User u;
		u = a;
		a = b;
		b = u;
	}
}
