package appliance.business.model;

import java.io.Serializable;

public class ElectricalAppliance implements MegaControllable, Serializable {
	private static final long serialVersionUID = 1L;

	private String brand;
	private boolean graduable;
	private int graduation;
	private int maxPower;
	private String model;
	private boolean on;
	private boolean secured;
	private boolean securityOn;
	private int totalGraduations;

	/**
	 * means : not secured, and not graduable
	 * 
	 * @param _brand
	 * @param _model
	 * @param _maxPower
	 */
	public ElectricalAppliance(String _brand, String _model, int _maxPower) {
		brand = _brand;
		model = _model;
		maxPower = _maxPower;
	}

	/**
	 * Means : secured (or not) and not graduated
	 * 
	 * @param _brand
	 * @param _model
	 * @param _maxPower
	 * @param _secured
	 */
	public ElectricalAppliance(String _brand, String _model, int _maxPower, boolean _secured) {
		super();
		brand = _brand;
		model = _model;
		maxPower = _maxPower;
		secured = _secured;
	}

	/**
	 * Means : graduated and NOT secured
	 * 
	 * @param _brand
	 * @param _model
	 * @param _maxPower
	 * @param _totalGraduations
	 * @param _secured
	 */
	public ElectricalAppliance(String _brand, String _model, int _maxPower, int _totalGraduations) {
		super();
		brand = _brand;
		model = _model;
		maxPower = _maxPower;
		totalGraduations = _totalGraduations;
		graduable = true;
	}

	/**
	 * Means : secured and graduated
	 * 
	 * @param _brand
	 * @param _model
	 * @param _maxPower
	 * @param _totalGraduations
	 * @param _secured
	 */
	public ElectricalAppliance(String _brand, String _model, int _maxPower, int _totalGraduations, boolean _secured) {
		super();
		brand = _brand;
		model = _model;
		maxPower = _maxPower;
		totalGraduations = _totalGraduations;
		graduable = true;
		secured = _secured;
	}

	@Override
	public void decrement() {
		if (graduation > 0) {
			graduation = graduation - 1;
			System.out.println("Decrementing to : " + graduation);
		} else
			System.out.println("Graduation already at minimum!");
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public int getConsumption() {
		if (isOn())
			return (Math.round(graduation * Float.valueOf(this.getMaxPower()) / Float.valueOf(totalGraduations)));
		else
			return 0;
	}

	@Override
	public int getGraduation() {
		return graduation;
	}

	@Override
	public int getMaxPower() {
		return maxPower;
	}

	@Override
	public String getModel() {
		return model;
	}

	@Override
	public int getTotalGraduations() {
		return totalGraduations;
	}

	@Override
	public void increment() {
		if (graduation < totalGraduations) {
			graduation = graduation + 1;
			System.out.println("Incrementing to : " + graduation);
		} else
			System.out.println("Graduation already at maximum!");
	}

	@Override
	public boolean isGraduable() {
		return graduable;
	}

	@Override
	public boolean isOn() {
		return on;
	}

	@Override
	public boolean isSecured() {
		return secured;
	}

	@Override
	public boolean isSecurityOn() {
		return securityOn;
	}

	@Override
	public void setGraduation(int _graduation) {
		if (_graduation < totalGraduations) {
			graduation = _graduation;
			System.out.println("setGraduation to :" + _graduation);
		} else {
			System.out.println(
					"Graduation : " + _graduation + "out of range [0-" + totalGraduations + "], nothing done !");
		}
	}

	@Override
	public void setSecurityOff() {
		securityOn = false;
		System.out.println("setSecurityOff");
		if (isOn()) {
			System.out.println("forced stop");
			// this.stop() will call the ThermostatedAppliance.stop()
			// since no override is done in this present class
			// super.stop(); would be equivalent.
			this.stop();
		}
	}

	@Override
	public void setSecurityOn() {
		securityOn = true;
	}

	@Override
	public void start() {
		if (on) {
			System.out.println("already started");
		}
		if ((!secured) || (secured && (securityOn))) {
			// if the security is ON then Ok to start
			on = true;
			System.out.println("Starting appliance");
		} else {
			if (secured) {
				// if security is OFF, it could not start => error Message !
				System.out.println("start impossible, the security is off ");
			}
		}

	}

	@Override
	public void stop() {
		on = false;
		graduation = 0;
		System.out.println("Stopping appliance");
	}

	@Override
	public String toString() {
		return "ElectricalAppliance [brand=" + brand + ", model=" + model + ", maxPower=" + maxPower + ", on=" + on
				+ ", graduable=" + graduable + ", graduation=" + graduation + ", totalGraduations=" + totalGraduations
				+ ", secured=" + secured + ", securityOn=" + securityOn + "]";
	}
}
