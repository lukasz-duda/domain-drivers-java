package domaindrivers.smartschedule.planning.parallelization;

import java.util.List;
import java.util.stream.Collectors;

public record ParallelStagesList(List<ParallelStages> all) {

    public static ParallelStagesList empty() {
        return new ParallelStagesList(List.of());
    }

    public String print() {
        return all.stream()
                .map(ParallelStages::print)
                .collect(Collectors.joining(" | "));
    }

}
