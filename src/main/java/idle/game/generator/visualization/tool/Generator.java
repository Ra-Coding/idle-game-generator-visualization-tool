package idle.game.generator.visualization.tool;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Generator implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	private String name;
	private double multiplier;
	private int owned;
	private double baseCost;
	private double baseRevenue;
	private float baseProductionTimeInSeconds;
	private double costFactor;
	private double nextCost;

	public Generator() {}
	
	public Generator(String name, double baseCost, double costFactor, double baseRevenue,
									 float baseProductionTimeInSeconds, double multiplier) {
		this.name = name;
		this.baseCost = baseCost;
		this.costFactor = costFactor;
		this.baseRevenue = baseRevenue;
		this.baseProductionTimeInSeconds = baseProductionTimeInSeconds;
		this.multiplier = multiplier;
		updateNextBuildingCost();
	}

	public void updateNextBuildingCost() {
        nextCost = baseCost * Math.pow(costFactor, owned);
    }

	public void calculateCosts() {
    updateNextBuildingCost();
    owned++;
	}

	public double productionPerSecond() {
  	if (owned == 0) {
    	return 0;
    }
		return (baseRevenue * owned * multiplier) / baseProductionTimeInSeconds;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}

	public void setOwned(int owned) {
		this.owned = owned;
	}

	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}

	public void setBaseRevenue(double baseRevenue) {
		this.baseRevenue = baseRevenue;
	}

	public void setBaseProductionTimeInSeconds(float baseProductionTimeInSeconds) {
		this.baseProductionTimeInSeconds = baseProductionTimeInSeconds;
	}

	public void setCostFactor(double costFactor) {
		this.costFactor = costFactor;
	}

	public void setNextCost(double nextCost) {
		this.nextCost = nextCost;
	}

	public double getNextCost() {
		return nextCost;
	}

	public int getOwned() {
		return owned;
	}

	public String getName() {
		return name;
	}

	public double getMultiplier() {
		return multiplier;
	}

	public double getBaseCost() {
		return baseCost;
	}

	public double getBaseRevenue() {
		return baseRevenue;
	}

	public float getBaseProductionTimeInSeconds() {
		return baseProductionTimeInSeconds;
	}

	public double getCostFactor() {
		return costFactor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Generator generator = (Generator) o;
		return Double.compare(generator.multiplier, multiplier) == 0 &&
				owned == generator.owned &&
				Double.compare(generator.baseCost, baseCost) == 0 &&
				Double.compare(generator.baseRevenue, baseRevenue) == 0 &&
				Float.compare(generator.baseProductionTimeInSeconds, baseProductionTimeInSeconds) == 0 &&
				Double.compare(generator.costFactor, costFactor) == 0 && Double.compare(generator.nextCost, nextCost) == 0 &&
				name.equals(generator.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, multiplier, owned, baseCost, baseRevenue,
				baseProductionTimeInSeconds, costFactor, nextCost);
	}
}
