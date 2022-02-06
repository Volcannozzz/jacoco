/*******************************************************************************
 * Copyright (c) 2009, 2021 Mountainminds GmbH & Co. KG and Contributors
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Nikolay Krasko - initial API and implementation
 *
 *******************************************************************************/
package org.jacoco.core.internal.analysis.filter;

import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.MethodNode;

/**
 * Filters methods generated by the Kotlin compiler. Kotlin classes are
 * identified by the <code>@kotlin.Metadata</code> annotations. In such classes
 * generated methods do not have line numbers.
 */
public class KotlinGeneratedFilter implements IFilter {

    static final String KOTLIN_METADATA_DESC = "Lkotlin/Metadata;";

    static boolean isKotlinClass(final IFilterContext context) {
        return context.getClassAnnotations().contains(KOTLIN_METADATA_DESC);
    }

    public void filter(final MethodNode methodNode,
                       final IFilterContext context, final IFilterOutput output) {

        if (context.getSourceFileName() == null) {
            // probably full debug information is missing
            // disabled filtering as all methods might be erroneously skipped
            return;
        }

        if (!isKotlinClass(context)) {
            return;
        }

        if (hasLineNumber(methodNode)) {
            return;
        }

        output.ignore(methodNode.instructions.getFirst(),
                methodNode.instructions.getLast());
    }

    private boolean hasLineNumber(final MethodNode methodNode) {
        for (final AbstractInsnNode i : methodNode.instructions) {
            if (AbstractInsnNode.LINE == i.getType()) {
                return true;
            }
        }
        return false;
    }

}
