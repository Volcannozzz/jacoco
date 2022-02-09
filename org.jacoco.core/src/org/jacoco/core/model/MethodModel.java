package org.jacoco.core.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MethodModel {

    Set<Integer> indexes = new HashSet<>();

    String methodName;

    String md5;

    public Set<Integer> getIndexes() {
        return indexes;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodModel that = (MethodModel) o;
        return Objects.equals(indexes, that.indexes) && Objects.equals(methodName, that.methodName) && Objects.equals(md5, that.md5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexes, methodName, md5);
    }
}
