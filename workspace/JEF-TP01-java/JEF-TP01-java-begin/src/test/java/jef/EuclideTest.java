package jef;

public class EuclideTest {
	public static int pgcd(int a, int b) {
		int r = a % b;
		while (r != 0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}

	public static int pgcdRecursif(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return pgcdRecursif(b, a % b);
		}
	}

	public static void main(String[] args) {
		System.out.println(EuclideTest.pgcd(72, 56));
		System.out.println(EuclideTest.pgcdRecursif(72, 56));
		
		System.out.println(EuclideTest.pgcd(21, 214));
		System.out.println(EuclideTest.pgcdRecursif(21, 214));

	}

}