package domaindrivers.smartschedule.planning.parallelization;

import java.util.List;
import java.util.Set;

public class StageParallelization {

    public ParallelStagesList of(Set<Stage> stages) {
        return new ParallelStagesList(List.of(new ParallelStages(stages)));
    }
}