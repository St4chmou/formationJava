package jef;

public class EuclidTest {

	private static int computeGcd(int a, int b) {
		int r = a % b;
		while (r != 0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}

	public static void main(String[] args) {

		int result = computeGcd(72, 56);
		System.out.println("expected=8 / result=" + result);

		result = computeGcd(231, 21);
		System.out.println("expected=21 / result=" + result);

	}
}
