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

package org.jetbrains.jet.j2k.ast;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class LocalVariable extends Expression {
    private final Identifier myIdentifier;
    private final Set<String> myModifiersSet;
    private final Type myType;
    private final Expression myInitializer;

    public LocalVariable(Identifier identifier, Set<String> modifiersSet, Type type, Expression initializer) {
        myIdentifier = identifier;
        myModifiersSet = modifiersSet;
        myType = type;
        myInitializer = initializer;
    }

    public boolean hasModifier(String modifier) {
        return myModifiersSet.contains(modifier);
    }

    @NotNull
    @Override
    public String toKotlin() {
        if (myInitializer.isEmpty()) {
            return myIdentifier.toKotlin() + SPACE + COLON + SPACE + myType.toKotlin();
        }

        return myIdentifier.toKotlin() + SPACE + COLON + SPACE + myType.toKotlin() + SPACE +
               EQUAL + SPACE + myInitializer.toKotlin();
    }
}
