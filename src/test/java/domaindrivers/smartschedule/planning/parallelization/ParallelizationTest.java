package domaindrivers.smartschedule.planning.parallelization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ParallelizationTest {

	static final StageParallelization stageParallelization = new StageParallelization();

	@Test
	void noDependency_executeInParallel() {
		Stage stage1 = new Stage("Stage1");
		Stage stage2 = new Stage("Stage2");

		ParallelStagesList sortedStages = stageParallelization.of(Set.of(stage1, stage2));

		assertEquals(1, sortedStages.all().size());
		assertEquals("Stage1, Stage2", sortedStages.print());
	}

	@Test
	@Disabled
	void simpleDependencies_executeSequentially() {

		Stage stage1 = new Stage("Stage1");
		Stage stage2 = new Stage("Stage2");
		Stage stage3 = new Stage("Stage3");
		Stage stage4 = new Stage("Stage4");
		stage2.dependsOn(stage1);
		stage3.dependsOn(stage1);
		stage4.dependsOn(stage2);

		ParallelStagesList sortedStages = stageParallelization.of(Set.of(stage1, stage2, stage3, stage4));

		assertEquals(1, sortedStages.all().size());
		assertEquals("Stage1 | Stage2, Stage3 | Stage4", sortedStages.print());
	}

}