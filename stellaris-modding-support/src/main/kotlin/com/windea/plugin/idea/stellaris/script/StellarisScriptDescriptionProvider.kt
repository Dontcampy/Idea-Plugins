package com.windea.plugin.idea.stellaris.script

import com.intellij.psi.*
import com.intellij.usageView.*
import com.windea.plugin.idea.stellaris.*
import com.windea.plugin.idea.stellaris.StellarisBundle.message
import com.windea.plugin.idea.stellaris.script.psi.*

class StellarisScriptDescriptionProvider: ElementDescriptionProvider {
	override fun getElementDescription(element: PsiElement, location: ElementDescriptionLocation): String? {
		return when(element) {
			is StellarisScriptVariableDefinition ->{
				if(location == UsageViewTypeLocation.INSTANCE) message("stellaris.script.description.variable")
				else element.name
			}
			is StellarisScriptProperty ->{
				if(location == UsageViewTypeLocation.INSTANCE) message("stellaris.script.description.property")
				else element.name
			}
			else -> null
		}
	}
}
