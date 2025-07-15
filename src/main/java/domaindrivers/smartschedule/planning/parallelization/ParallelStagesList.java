package domaindrivers.smartschedule.planning.parallelization;

import java.util.List;

public record ParallelStagesList(List<ParallelStages> all) {

    public static ParallelStagesList empty() {
        return new ParallelStagesList(List.of());
    }

}
