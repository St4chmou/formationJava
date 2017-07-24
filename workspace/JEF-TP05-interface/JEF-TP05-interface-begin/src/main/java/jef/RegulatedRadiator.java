package jef;

public class RegulatedRadiator extends Radiator {

	private static final int LEVEL_MAX = 10;

	private static final String LEVEL_MESSAGE_ERROR = "Level must be between 0 and " + LEVEL_MAX;

	private int level;

	public RegulatedRadiator(int level, int powerMax, String brand, String model) {
		super(powerMax, brand, model);
		this.level = level;
	}

	/**
	 * Override the super method
	 */
	@Override
	public int getConsumption() {
		return super.getConsumption() * level / LEVEL_MAX;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if (level < 0 || LEVEL_MAX < level) {
			throw new IllegalArgumentException(LEVEL_MESSAGE_ERROR);
		}
		this.level = level;
	}

}
