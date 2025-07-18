package domaindrivers.smartschedule.planning.parallelization;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StageParallelization {

    public ParallelStagesList of(Set<Stage> stages) {
        Set<Stage> withoutDependencies = stages.stream()
                .filter(stage -> stage.dependencies().isEmpty())
                .collect(Collectors.toSet());

        return new ParallelStagesList(List.of(new ParallelStages(withoutDependencies)));
    }
}