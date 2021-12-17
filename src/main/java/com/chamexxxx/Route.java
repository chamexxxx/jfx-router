package com.chamexxxx;

import java.net.URL;

public class Route {
    public final URL resourcePath;
    public final StageOptions stageOptions;

    public Route(URL resourcePath, StageOptions stageOptions) {
        this.resourcePath = resourcePath;
        this.stageOptions = stageOptions;
    }
}
