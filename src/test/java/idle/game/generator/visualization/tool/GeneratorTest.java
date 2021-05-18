package idle.game.generator.visualization.tool;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GeneratorTest {
	
	private Generator setupGenerator() {
		Generator generator = new Generator(5, 1.05, 3, 3, 1);
		return generator;
	}
	
	@Test
	void updateNextBuildingCostTest() {
		Generator generator = setupGenerator();
		
		generator.updateNextBuildingCost();
		
		assertThat(generator.getNextCost()).isEqualTo(5);
	}
	
	@Test
	void calculateCostsTest() {
		Generator generator = setupGenerator();
		
		generator.calculateCosts();
		
		assertThat(generator.getOwned()).isEqualTo(1);
	}
	
	@Test
	void productionPerSecondZeroOwnedTest() {
		Generator generator = setupGenerator();
		
		assertThat(generator.productionPerSecond()).isEqualTo(0);
	}
}