package idle.game.generator.visualization.tool;

public class Multiplier {
	
	private int level;
	private double value;
	
	public Multiplier(int level, double value) {
		this.level = level;
		this.value = value;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
