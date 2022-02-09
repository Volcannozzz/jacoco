package org.jacoco.core.model;

import java.io.File;

public class WorkSpaceModel {

    public File execFile;

    public File sourceDirectory;

    public File classesDirectory;

    public File getExecFile() {
        return execFile;
    }

    public void setExecFile(File execFile) {
        this.execFile = execFile;
    }

    public File getSourceDirectory() {
        return sourceDirectory;
    }

    public void setSourceDirectory(File sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }

    public File getClassesDirectory() {
        return classesDirectory;
    }

    public void setClassesDirectory(File classesDirectory) {
        this.classesDirectory = classesDirectory;
    }
}
