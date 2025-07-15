package domaindrivers.smartschedule.planning.parallelization;

import java.util.Set;

public record Stage(String stageName, Set<Stage> dependencies) {

    public Stage(String stageName) {
        this(stageName, Set.of());
    }

}