
public class BadSwapTest {

	public static void swapInt(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void swapUser(User u1, User u2) {
		User tempUser = u1;
		u1 = u2;
		u2 = tempUser;
	}
	
	public static void main (String[] args) {
		int a = 2;
		int b = 3;
		System.out.println("a = " + a + " b = " + b);
		// Swap
		swapInt(a, b);
		System.out.println("Swap");
		System.out.println("a = " + a + " b = " + b);
		
		System.out.println("------");
		User u1 = new User("User1");
		User u2 = new User("User2");
		System.out.println("u1 = " + u1 + " u2 = " + u2);
		// Swap
		swapUser(u1, u2);
		System.out.println("Swap");
		System.out.println("u1 = " + u1 + " u2 = " + u2);
	}
}
