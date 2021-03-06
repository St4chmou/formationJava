package appliance.persistence.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Persistent model class. Only persistent fields are kept here, without ANY
 * funtional business behaviour. this is a TECHNICAL persistent model.
 */
@SuppressWarnings("serial")
@Entity
public class Appliance implements Serializable {

	private String brand;

	private boolean graduable;
	private Integer graduations;
	/**
	 * primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String model;
	private int power;
	private boolean secured;

	public Appliance() {
		super();
	}

	public Appliance(String _brand, String _model, int _power, boolean _graduable, Integer _graduations,
			boolean _secured) {
		super();
		brand = _brand;
		model = _model;
		power = _power;
		graduable = _graduable;
		graduations = _graduations;
		secured = _secured;
	}

	public String getBrand() {
		return brand;
	}

	public Integer getGraduations() {
		return graduations;
	}

	public Long getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public int getPower() {
		return power;
	}

	public boolean isGraduable() {
		return graduable;
	}

	public boolean isSecured() {
		return secured;
	}

	public void setBrand(String _brand) {
		brand = _brand;
	}

	public void setGraduable(boolean _graduable) {
		graduable = _graduable;
	}

	public void setGraduations(Integer _graduations) {
		graduations = _graduations;
	}

	public void setId(Long _id) {
		id = _id;
	}

	public void setModel(String _model) {
		model = _model;
	}

	public void setPower(int _power) {
		power = _power;
	}

	public void setSecured(boolean _secured) {
		secured = _secured;
	}

	@Override
	public String toString() {
		return "Appliance [id=" + id + ", brand=" + brand + ", model=" + model + ", power=" + power + ", graduable="
				+ graduable + ", graduations=" + graduations + ", secured=" + secured + "]";
	}

}
