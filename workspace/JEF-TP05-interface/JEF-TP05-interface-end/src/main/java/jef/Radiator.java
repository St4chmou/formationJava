package jef;

public class Radiator implements Startable {

	private String brand;
	private String model;
	private boolean on;
	private int powerMax;

	public Radiator(int powerMax, String brand, String model) {
		super();
		this.powerMax = powerMax;
		this.brand = brand;
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public int getConsumption() {
		if (this.isOn()) {
			return this.powerMax;
		} else {
			return 0;
		}
	}

	public String getModel() {
		return model;
	}

	public int getPowerMax() {
		return powerMax;
	}

	public boolean isOn() {
		return on;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	private void setOn(boolean on) {
		this.on = on;
	}

	public void setPowerMax(int powerMax) {
		this.powerMax = powerMax;
	}

	public void start() {
		this.setOn(true);
	}

	public void stop() {
		this.setOn(false);
	}

}
