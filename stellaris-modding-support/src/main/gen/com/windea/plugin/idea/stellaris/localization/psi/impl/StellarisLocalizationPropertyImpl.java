// This is a generated file. Not intended for manual editing.
package com.windea.plugin.idea.stellaris.localization.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.windea.plugin.idea.stellaris.localization.psi.StellarisLocalizationTypes.*;
import com.windea.plugin.idea.stellaris.localization.psi.*;
import com.intellij.openapi.util.Iconable.IconFlags;
import javax.swing.Icon;

public class StellarisLocalizationPropertyImpl extends StellarisLocalizationNamedElementImpl implements StellarisLocalizationProperty {

  public StellarisLocalizationPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull StellarisLocalizationVisitor visitor) {
    visitor.visitProperty(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StellarisLocalizationVisitor) accept((StellarisLocalizationVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public StellarisLocalizationPropertyKey getPropertyKey() {
    return findNotNullChildByClass(StellarisLocalizationPropertyKey.class);
  }

  @Override
  @Nullable
  public StellarisLocalizationPropertyValue getPropertyValue() {
    return findChildByClass(StellarisLocalizationPropertyValue.class);
  }

  @Override
  @Nullable
  public PsiElement getNumber() {
    return findChildByType(NUMBER);
  }

  @Override
  @Nullable
  public String getName() {
    return StellarisLocalizationPsiImplUtil.getName(this);
  }

  @Override
  @NotNull
  public PsiElement setName(@NotNull String name) {
    return StellarisLocalizationPsiImplUtil.setName(this, name);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return StellarisLocalizationPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  @Nullable
  public Icon getIcon(@IconFlags int flags) {
    return StellarisLocalizationPsiImplUtil.getIcon(this, flags);
  }

  @Override
  @NotNull
  public String getKey() {
    return StellarisLocalizationPsiImplUtil.getKey(this);
  }

  @Override
  @NotNull
  public String getValue() {
    return StellarisLocalizationPsiImplUtil.getValue(this);
  }

}
