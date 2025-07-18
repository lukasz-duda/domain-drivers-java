package domaindrivers.smartschedule.planning.parallelization;

import java.util.HashSet;
import java.util.Set;

public record Stage(String stageName, Set<Stage> dependencies) {

    public Stage(String stageName) {
        this(stageName, new HashSet<Stage>());
    }

    public void dependsOn(Stage stage) {
        dependencies.add(stage);
    }

}