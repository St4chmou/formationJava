package jef;

public class Bike {

	private String color;
	private int counter;
	private String model;
	private int speed;

	public Bike(String color, String model) {
		super();
		this.color = color;
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public int getCounter() {
		return counter;
	}

	public String getModel() {
		return model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Bike [color=" + color + ", model=" + model + ", counter=" + counter + ", speed=" + speed + "]";
	}

}
