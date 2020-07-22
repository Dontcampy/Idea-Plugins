package com.windea.plugin.idea.stellaris.script.settings

import com.intellij.openapi.fileTypes.*
import com.intellij.openapi.options.colors.*
import com.intellij.openapi.options.colors.ColorDescriptor.*
import com.windea.plugin.idea.stellaris.*
import com.windea.plugin.idea.stellaris.StellarisBundle.message
import com.windea.plugin.idea.stellaris.annotations.*
import com.windea.plugin.idea.stellaris.script.*
import com.windea.plugin.idea.stellaris.script.highlighter.*

@ExtensionPoint
class StellarisScriptColorSettingsPage : ColorSettingsPage {
	companion object {
		//Capitalized Words
		private val attributesDescriptors = arrayOf(
			AttributesDescriptor(message("stellaris.script.color.separator"), StellarisScriptAttributesKeys.SEPARATOR_KEY),
			AttributesDescriptor(message("stellaris.script.color.braces"), StellarisScriptAttributesKeys.BRACES_KEY),
			AttributesDescriptor(message("stellaris.script.color.variable"), StellarisScriptAttributesKeys.VARIABLE_KEY),
			AttributesDescriptor(message("stellaris.script.color.propertyKey"), StellarisScriptAttributesKeys.PROPERTY_KEY_KEY),
			AttributesDescriptor(message("stellaris.script.color.keyword"), StellarisScriptAttributesKeys.KEYWORD_KEY),
			AttributesDescriptor(message("stellaris.script.color.number"),StellarisScriptAttributesKeys. STRING_KEY),
			AttributesDescriptor(message("stellaris.script.color.string"), StellarisScriptAttributesKeys.NUMBER_KEY),
			AttributesDescriptor(message("stellaris.script.color.comment"), StellarisScriptAttributesKeys.COMMENT_KEY),
			AttributesDescriptor(message("stellaris.script.color.validEscape"), StellarisScriptAttributesKeys.VALID_ESCAPE_KEY),
			AttributesDescriptor(message("stellaris.script.color.invalidEscape"), StellarisScriptAttributesKeys.INVALID_ESCAPE_KEY),
			AttributesDescriptor(message("stellaris.script.color.badCharacter"), StellarisScriptAttributesKeys.BAD_CHARACTER_KEY)
		)
	}

	override fun getHighlighter() = SyntaxHighlighterFactory.getSyntaxHighlighter(StellarisScriptLanguage, null, null)

	override fun getAdditionalHighlightingTagToDescriptorMap() = null

	override fun getIcon() = stellarisScriptIcon

	override fun getAttributeDescriptors() = attributesDescriptors

	override fun getColorDescriptors() = EMPTY_ARRAY

	override fun getDisplayName() = stellarisScriptName

	override fun getDemoText() = stellarisScriptDummyText
}
