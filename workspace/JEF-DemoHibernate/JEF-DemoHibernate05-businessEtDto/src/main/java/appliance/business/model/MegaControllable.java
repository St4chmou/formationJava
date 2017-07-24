package appliance.business.model;

public interface MegaControllable {

	int MAX_POWER = 100000;

	/**
	 * decrement power by one notch
	 */
	void decrement();

	String getBrand();

	int getConsumption();

	int getGraduation();

	int getMaxPower();

	String getModel();

	int getTotalGraduations();

	/**
	 * increment power by one notch
	 */
	void increment();

	boolean isGraduable();

	boolean isOn();

	boolean isSecured();

	boolean isSecurityOn();

	void setGraduation(int _graduation);

	void setSecurityOff();

	void setSecurityOn();

	void start();

	void stop();

}
