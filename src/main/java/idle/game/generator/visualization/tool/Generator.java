package idle.game.generator.visualization.tool;

import java.io.Serializable;

public class Generator implements Serializable {

	static final long serialVersionUID = 1L;
	private String name;
	private final double multiplier;
	private int owned;
	private int ownedCostHigherRevenue;
	private final double baseCost;
	private final double baseRevenue;
	private final float baseProductionTimeInSeconds;
	private final double costFactor;
	private double nextCost;
	
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

			// print if production per second is less than the next cost
			if (productionPerSecond() < nextCost) {
				System.out.print(owned + " ");
			}
    }
    
    public double productionPerSecond() {
        if (owned == 0) {
            return 0;
        }

        return (baseRevenue * owned * multiplier) / baseProductionTimeInSeconds;
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
}
