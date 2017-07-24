package appliance.persistence.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Brand implements Serializable {
	private static final long serialVersionUID = -7316889061460928713L;

	@OneToMany(mappedBy = "brand")
	private Set<Appliance> appliances = new HashSet<Appliance>();

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String name;

	@Version
	private int version;

	public Brand() {
		super();
	}

	public Brand(String _name) {
		super();
		name = _name;
	}

	public Set<Appliance> getAppliances() {
		return appliances;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getVersion() {
		return version;
	}

	public void setAppliances(Set<Appliance> _appliances) {
		appliances = _appliances;
	}

	public void setId(Long _id) {
		id = _id;
	}

	public void setName(String _name) {
		name = _name;
	}

	public void setVersion(int _version) {
		version = _version;
	}

	@Override
	public String toString() {
		return "Brand [id=" + id + ", version=" + version + ", name=" + name + "]";
	}

}
