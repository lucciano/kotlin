/*
 * Copyright 2010-2012 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.lang.resolve.lazy;

import org.jetbrains.jet.ConfigurationKind;
import org.jetbrains.jet.cli.jvm.compiler.JetCoreEnvironment;
import org.jetbrains.jet.lang.descriptors.NamespaceDescriptor;
import org.jetbrains.jet.lang.types.lang.KotlinBuiltIns;
import org.junit.Test;

import java.io.File;

import static org.jetbrains.jet.test.util.NamespaceComparator.RECURSIVE;
import static org.jetbrains.jet.test.util.NamespaceComparator.compareNamespaceWithFile;

public class LazyResolveBuiltinClassesTest extends KotlinTestWithEnvironment {
    @Override
    protected JetCoreEnvironment createEnvironment() {
        return createEnvironmentWithMockJdk(ConfigurationKind.JDK_ONLY);
    }

    @Test
    public void testBuiltIns() throws Exception {
        NamespaceDescriptor builtInsPackage = KotlinBuiltIns.getInstance().getBuiltInsPackage();
        compareNamespaceWithFile(builtInsPackage, RECURSIVE, new File("compiler/testData/builtin-classes.txt"));
    }
}
