package org.jacoco.core.analysis;

/**
 * @author Volcannozzz
 * @since 0.8.7
 */
public enum AnalyzerMode {
    // 只分析，不生成覆盖率
    ANALYZE,
    // 完全模式，既分析，又要生成覆盖率数据
    FULL
}
