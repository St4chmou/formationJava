
public class Radiator {

	private String brand;
	private String model;
	private boolean on;
	private int powerMax;

	public Radiator(String brand, String model, boolean on, int powerMax) {
		super();
		this.brand = brand;
		this.model = model;
		this.on = on;
		this.powerMax = powerMax;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public int getPowerMax() {
		return powerMax;
	}

	public void setPowerMax(int powerMax) {
		this.powerMax = powerMax;
	}

	public int getConsumption() {
		int consumption = 0;
		if (on) {
			consumption = this.powerMax;
		}
		return consumption;
	}

	@Override
	public String toString() {
		return "Radiator [brand=" + brand + ", model=" + model + ", on=" + on + ", powerMax=" + powerMax + "]";
	}

	public void start() {
		setOn(true);
	}

	public void stop() {
		setOn(false);
	}

}
