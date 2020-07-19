// This is a generated file. Not intended for manual editing.
package com.windea.plugin.idea.stellaris.localization.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.openapi.util.Iconable.IconFlags;
import com.windea.plugin.idea.stellaris.domain.StellarisLocale;
import javax.swing.Icon;

public interface StellarisLocalizationLocale extends StellarisLocalizationNamedElement {

  @NotNull
  PsiElement getLocaleId();

  @NotNull
  String getName();

  @NotNull
  PsiElement setName(@NotNull String name);

  @Nullable
  PsiElement getNameIdentifier();

  @Nullable
  Icon getIcon(@IconFlags int flags);

  @Nullable
  StellarisLocale getLocale();

  @Nullable
  String getDocumentation();

}