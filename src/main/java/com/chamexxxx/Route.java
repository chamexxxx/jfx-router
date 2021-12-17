package com.chamexxxx;

public class Route {
    public final String resourceName;
    public final StageOptions stageOptions;

    public Route(String resourceName, StageOptions stageOptions) {
        this.resourceName = resourceName;
        this.stageOptions = stageOptions;
    }
}
