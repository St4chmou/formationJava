
public class RegulatedRadiator extends Radiator {

	private int level;

	public RegulatedRadiator(String brand, String model, boolean on, int powerMax, int level) {
		super(brand, model, on, powerMax);
		this.level = level;
		// TODO Auto-generated constructor stub
	}

	public int getConsumption() {
		int consumption = 0;
		if (this.isOn()) {
			consumption = this.getPowerMax()*level/10;
		}
		return consumption;
	}

}
