package com.windea.plugin.idea.stellaris.localization.psi

import com.intellij.lang.*
import com.intellij.lang.ParserDefinition.SpaceRequirements.*
import com.intellij.openapi.project.*
import com.intellij.psi.*
import com.intellij.psi.TokenType.*
import com.intellij.psi.tree.*
import com.windea.plugin.idea.stellaris.localization.*
import com.windea.plugin.idea.stellaris.localization.psi.StellarisLocalizationTypes.*

class StellarisLocalizationParserDefinition : ParserDefinition {
	companion object {
		val WHITE_SPACES = TokenSet.create(WHITE_SPACE)
		val COMMENTS = TokenSet.create(COMMENT, ROOT_COMMENT,END_OF_LINE_COMMENT)
		val STRINGS = TokenSet.create(STRING_TOKEN)
		val FILE = IFileElementType(StellarisLocalizationLanguage)
	}

	override fun createLexer(project: Project?) = StellarisLocalizationLexerAdapter()

	override fun getWhitespaceTokens() = WHITE_SPACES

	override fun getCommentTokens() = COMMENTS

	override fun getStringLiteralElements() = STRINGS

	override fun createParser(project: Project?) = StellarisLocalizationParser()

	override fun getFileNodeType() = FILE

	override fun createFile(viewProvider: FileViewProvider) = StellarisLocalizationFile(viewProvider)

	override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?): ParserDefinition.SpaceRequirements {
		return when {
			//数字和属性值之间必须有空格
			left?.elementType == NUMBER && right?.elementType == PROPERTY_VALUE -> MUST
			//语言区域之前必须换行
			right?.elementType == LOCALE -> MUST_LINE_BREAK
			//属性之前必须换行
			right?.elementType == PROPERTY -> MUST_LINE_BREAK
			else -> MAY
		}
	}

	override fun createElement(node: ASTNode) = StellarisLocalizationTypes.Factory.createElement(node)
}


