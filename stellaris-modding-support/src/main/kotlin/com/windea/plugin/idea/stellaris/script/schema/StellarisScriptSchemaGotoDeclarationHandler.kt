package com.windea.plugin.idea.stellaris.script.schema

import com.intellij.codeInsight.navigation.actions.*
import com.intellij.json.pointer.*
import com.intellij.openapi.editor.*
import com.intellij.psi.*
import com.intellij.psi.util.*
import com.jetbrains.jsonSchema.ide.*
import com.jetbrains.jsonSchema.impl.*
import com.windea.plugin.idea.stellaris.script.psi.*
import com.windea.plugin.idea.stellaris.script.psi.StellarisScriptTypes.*

//org.jetbrains.yaml.schema.YamlJsonSchemaGotoDeclarationHandler

class StellarisScriptSchemaGotoDeclarationHandler:GotoDeclarationHandler {
	override fun getGotoDeclarationTargets(sourceElement: PsiElement?, offset: Int, editor: Editor?): Array<PsiElement>? {
		//sourceElement: PROPERTY_KEY_ID
		if(sourceElement == null) return null
		when(sourceElement.elementType){
			PROPERTY_KEY_ID -> {
				val file = sourceElement.containingFile?:return null
				val service = JsonSchemaService.Impl.get(sourceElement.project)
				if(service.isApplicableToFile(file.virtualFile)){
					val steps = StellarisScriptJsonLikePsiWalker.findPosition(sourceElement,true)?:return null
					val schemaObject = service.getSchemaObject(file)?:return null
					val target = JsonSchemaResolver(sourceElement.project,schemaObject,steps).findNavigationTarget(sourceElement.parent)?:return null
					return arrayOf(target)
				}
			}
		}
		return null
	}
}
