@file:Suppress("UNCHECKED_CAST")

package com.windea.plugin.idea.stellaris.localization.navigation

import com.intellij.codeInsight.navigation.actions.*
import com.intellij.openapi.editor.*
import com.intellij.psi.*
import com.windea.plugin.idea.stellaris.*
import com.windea.plugin.idea.stellaris.localization.psi.*

//定位定义：
//TODO 属性 - 当前文件
//TODO 属性 - 当前项目
//TODO 属性 - 游戏目录
//TODO 属性 - mod目录

class StellarisLocalizationGoToDeclarationHandler : GotoDeclarationHandler{
	override fun getGotoDeclarationTargets(sourceElement: PsiElement?, offset: Int, editor: Editor?): Array<out PsiElement?>? {
		return when(sourceElement) {
			null -> null
			is StellarisLocalizationProperty -> {
				//查找当前文件，如果没有，再查找当前项目
				val name = sourceElement.name?:return null
				findLocalizationPropertyInFile(name, sourceElement.containingFile)?.toSingletonArray()?.let { return it }
				findLocalizationProperties(name, sourceElement.project).toArray()
			}
			else -> null
		}
	}
}

