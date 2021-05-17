package idle.game.generator.visualization.tool;

public class Generator {
	
	private double multiplier;
	private int owned;
    private double baseCost;
    private double baseRevenue;
    private float baseProductionTimeInSeconds;
    private double costFactor;
    private double nextBuildingCostsForOne;
	
	public Generator(double baseCost, double costFactor, double baseRevenue, float baseProductionTimeInSeconds, double multiplier) {
		this.baseCost = baseCost;
		this.costFactor = costFactor;
		this.baseRevenue = baseRevenue;
		this.baseProductionTimeInSeconds = baseProductionTimeInSeconds;
		this.multiplier = multiplier;
		updateNextBuildingCosts();
	}
	

    public void updateNextBuildingCosts() {
        var kOverR = Math.pow(costFactor, owned);
        var kPlusNOverR = Math.pow(costFactor, owned + 1);

        nextBuildingCostsForOne = baseCost * ((kOverR - kPlusNOverR) / (1 - costFactor));
    }
    
    public void calculateCosts() {
    	updateNextBuildingCosts();
    	owned++;
    }
    
    public double produce() {
        if (owned == 0) {
            return 0;
        }

        return (baseRevenue * owned * multiplier) / baseProductionTimeInSeconds;
    }

	public double getNextBuildingCostsForOne() {
		return nextBuildingCostsForOne;
	}
}
