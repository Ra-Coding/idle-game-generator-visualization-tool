package idle.game.generator.visualization.tool;

public class Generator {
	
	private final double multiplier;
	private int owned;
	private final double baseCost;
	private final double baseRevenue;
	private final float baseProductionTimeInSeconds;
	private final double costFactor;
	private double nextCost;
	
	public Generator(double baseCost, double costFactor, double baseRevenue, float baseProductionTimeInSeconds, double multiplier) {
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

	public double getNextCost() {
		return nextCost;
	}
	
	public int getOwned() {
		return owned;
	}
}
