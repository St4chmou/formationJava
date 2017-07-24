package jef;

import java.util.ArrayList;
import java.util.Collection;

public class HomeManagerWithoutInterface {

	private Collection<Light> lights = new ArrayList<Light>();
	private Collection<Radiator> radiators = new ArrayList<Radiator>();

	public void add(Light l) {
		this.lights.add(l);
	}

	public void add(Radiator r) {
		this.radiators.add(r);
	}

	public Collection<Light> getLights() {
		Collection<Light> result = new ArrayList<Light>();
		result.addAll(this.lights);
		return result;
	}

	public Collection<Radiator> getRadiators() {
		Collection<Radiator> result = new ArrayList<Radiator>();
		result.addAll(this.radiators);
		return result;
	}

	public void startAll() {
		for (Light l : this.lights) {
			l.start();
		}
		for (Radiator r : this.radiators) {
			r.start();
		}
	}

	public void stopAll() {
		for (Light l : this.lights) {
			l.stop();
		}
		for (Radiator r : this.radiators) {
			r.stop();
		}
	}

}
