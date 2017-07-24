package appliance.business.dto;

public class ApplianceDto {

	private String brand;
	private boolean graduable;
	private Integer graduations;
	private Long id;
	private String model;
	private int power;
	private boolean secured;
	private int version;

	public ApplianceDto() {
		super();
	}

	public ApplianceDto(Long _id, int _version, String _brand, String _model, int _power, boolean _graduable,
			Integer _graduations, boolean _secured) {
		super();
		id = _id;
		version = _version;
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

	public int getVersion() {
		return version;
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

	public void setVersion(int _version) {
		version = _version;
	}

	@Override
	public String toString() {
		return "ApplianceDto [id=" + id + ", version=" + version + ", brand=" + brand + ", model=" + model + ", power="
				+ power + ", graduable=" + graduable + ", graduations=" + graduations + ", secured=" + secured + "]";
	}

}
