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

package org.jetbrains.jet.lang.psi.stubs.elements;

import com.intellij.psi.PsiFile;
import com.intellij.psi.stubs.DefaultStubBuilder;
import com.intellij.psi.stubs.StubElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.lang.psi.JetFile;
import org.jetbrains.jet.lang.psi.stubs.impl.PsiJetFileStubImpl;

public class JetFileStubBuilder extends DefaultStubBuilder {
    @Override
    protected StubElement createStubForFile(@NotNull PsiFile file) {
        if (!(file instanceof JetFile)) {
            return super.createStubForFile(file);
        }

        JetFile jetFile = (JetFile) file;
        return new PsiJetFileStubImpl(jetFile, jetFile.getPackageName(), jetFile.isScript());
    }
}
