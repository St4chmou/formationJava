
public class Bike {

	private String color;
	private String model;
	private int counter;
	private int speed;

	public Bike(String color, String model, int counter, int speed) {
		super();
		this.color = color;
		this.model = model;
		this.counter = counter;
		this.speed = speed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Bike [color=" + color + ", model=" + model + ", counter=" + counter + ", speed=" + speed + "]";
	}

}
