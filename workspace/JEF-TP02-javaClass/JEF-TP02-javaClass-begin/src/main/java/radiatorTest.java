import java.util.ArrayList;

public class radiatorTest {

	public static void testRadiator() {
		System.out.println("Création radiateur éteint");
		Radiator r1 = new Radiator("test", "modelTest", false, 100);
		System.out.println(r1);
		System.out.println("Consommation = " + r1.getConsumption());
		System.out.println("Allumage du radiateur");
		r1.setOn(true);
		System.out.println("Consommation = " + r1.getConsumption());
	}

	public static void testRegulatedRadiator() {
		System.out.println("Création radiateur éteint");
		Radiator r1 = new RegulatedRadiator("test", "modelTest", false, 100, 2);
		System.out.println(r1);
		System.out.println("Consommation = " + r1.getConsumption());
		System.out.println("Allumage du radiateur");
		r1.setOn(true);
		System.out.println("Consommation = " + r1.getConsumption());
	}

	public static void testCollectionRadiator() {
		ArrayList<Radiator> radiators = new ArrayList<Radiator>();
		System.out.println("Création radiateurs éteints");
		Radiator r1 = new Radiator("test", "modelTest", false, 100);
		Radiator r2 = new RegulatedRadiator("test", "modelTest", false, 100, 2);
		radiators.add(r1);
		radiators.add(r2);
		for (Radiator r : radiators) {
			System.out.println(r);
			System.out.println("Consommation = " + r.getConsumption());
		}
		System.out.println("Allumage des radiateurs");
		for (Radiator r : radiators) {
			r.setOn(true);
			System.out.println("Consommation = " + r.getConsumption());
		}

	}

	public static void main(String[] args) {
		// testRadiator
		System.out.println("test Radiator");
		testRadiator();

		// test RegulatedRadiator
		System.out.println("test RegulatedRadiator");
		testRegulatedRadiator();

		// test Collection de Radiator et RegulatedRadiator
		System.out.println("test Collection de Radiator et RegulatedRadiator");
		testCollectionRadiator();

	}
}
