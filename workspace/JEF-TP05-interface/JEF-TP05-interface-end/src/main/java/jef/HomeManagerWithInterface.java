package jef;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.functors.InstanceofPredicate;

public class HomeManagerWithInterface {

	private Collection<Startable> startables = new ArrayList<Startable>();

	public void add(Light l) {
		this.startables.add(l);
	}

	public void add(Radiator r) {
		this.startables.add(r);
	}

	@SuppressWarnings("unchecked")
	public Collection<Light> getLights() {
		return CollectionUtils.select(this.startables, InstanceofPredicate.getInstance(Light.class));
	}

	@SuppressWarnings("unchecked")
	public Collection<Radiator> getRadiators() {
		return CollectionUtils.select(this.startables, InstanceofPredicate.getInstance(Radiator.class));
	}

	public void startAll() {
		for (Startable s : this.startables) {
			s.start();
		}
	}

	public void stopAll() {
		for (Startable s : this.startables) {
			s.stop();
		}
	}

}
