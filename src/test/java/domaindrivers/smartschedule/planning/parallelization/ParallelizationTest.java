package domaindrivers.smartschedule.planning.parallelization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class ParallelizationTest {

	static final StageParallelization stageParallelization = new StageParallelization();

	@Test
	void noDependency_executeInParallel() {
		Stage stage1 = new Stage("Stage1");
		Stage stage2 = new Stage("Stage2");

		ParallelStagesList sortedStages = stageParallelization.of(Set.of(stage1, stage2));

		assertEquals(1, sortedStages.all().size());
	}

}