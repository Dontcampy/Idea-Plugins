// This is a generated file. Not intended for manual editing.
package com.windea.plugin.idea.stellaris.script.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralValue;

public interface StellarisScriptVariableValue extends PsiLiteralValue {

  @Nullable
  StellarisScriptBoolean getBoolean();

  @Nullable
  StellarisScriptNumber getNumber();

  @Nullable
  StellarisScriptString getString();

  @Nullable
  String getValue();

}
