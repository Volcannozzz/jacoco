package org.jacoco.core.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Merge {

    List<File> execFiles = new ArrayList<File>();

    // like org/jacoco/core/SimpleDemo
    Set<String> repeatClassNames = new HashSet<>();

    // base
    File baseFile;

    File destFile;

    public ExecFileLoader execute()
            throws IOException {
        final ExecFileLoader loader = loadExecutionData();
        loader.save(destFile, true);
        return loader;
    }

    private ExecFileLoader loadExecutionData()
            throws IOException {
        final ExecFileLoader loader = new ExecFileLoader();
        if (execFiles.isEmpty()) {
            throw new IllegalStateException(" exec Files cannot be empty!");
        } else {
            loader.load(baseFile);
            for (final File file : execFiles) {
                loader.load(file);
            }
        }
        return loader;
    }

}
