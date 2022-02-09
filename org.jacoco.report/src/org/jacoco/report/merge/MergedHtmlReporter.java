package org.jacoco.report.merge;

import org.jacoco.core.model.WorkSpaceModel;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class MergedHtmlReporter {

    WorkSpaceModel old;
    WorkSpaceModel base;

    public void report() {
        Set<String> repeatClassNames = repeatNames();
    }

    Set<String> repeatNames() {
        return Collections.emptySet();
    }

    Map<String, int[]> classMapProbes() {
        return Collections.emptyMap();
    }
}
