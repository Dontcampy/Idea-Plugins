package com.windea.plugin.idea.stellaris.script

import com.intellij.psi.*
import com.intellij.psi.util.*
import com.intellij.spellchecker.tokenizer.*
import com.windea.plugin.idea.stellaris.script.psi.StellarisScriptTypes.*

//拼写检查：
//检查variableName、key、value、comment

class StellarisScriptSpellchecker : SpellcheckingStrategy() {
	override fun getTokenizer(element: PsiElement): Tokenizer<*> {
		return when(element.elementType) {
			VARIABLE_NAME_ID -> TEXT_TOKENIZER
			PROPERTY_KEY_ID -> TEXT_TOKENIZER
			VARIABLE_REFERENCE_ID -> TEXT_TOKENIZER
			STRING_TOKEN -> TEXT_TOKENIZER
			UNQUOTED_STRING_TOKEN -> TEXT_TOKENIZER
			COMMENT -> TEXT_TOKENIZER
			END_OF_LINE_COMMENT -> TEXT_TOKENIZER
			else -> EMPTY_TOKENIZER
		}
	}
}
