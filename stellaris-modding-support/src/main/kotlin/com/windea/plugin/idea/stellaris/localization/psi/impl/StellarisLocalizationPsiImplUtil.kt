@file:Suppress("UNCHECKED_CAST", "UNUSED_PARAMETER")

package com.windea.plugin.idea.stellaris.localization.psi.impl

import com.intellij.icons.*
import com.intellij.openapi.util.Iconable.*
import com.intellij.psi.*
import com.intellij.refactoring.suggested.*
import com.intellij.util.*
import com.windea.plugin.idea.stellaris.*
import com.windea.plugin.idea.stellaris.domain.*
import com.windea.plugin.idea.stellaris.localization.psi.*
import com.windea.plugin.idea.stellaris.localization.psi.StellarisLocalizationElementFactory.createColorfulText
import com.windea.plugin.idea.stellaris.localization.psi.StellarisLocalizationElementFactory.createIcon
import com.windea.plugin.idea.stellaris.localization.psi.StellarisLocalizationElementFactory.createLocale
import com.windea.plugin.idea.stellaris.localization.psi.StellarisLocalizationElementFactory.createPropertyKey
import com.windea.plugin.idea.stellaris.localization.psi.StellarisLocalizationElementFactory.createPropertyReference
import com.windea.plugin.idea.stellaris.localization.psi.StellarisLocalizationElementFactory.createSerialNumber
import com.windea.plugin.idea.stellaris.localization.reference.*
import javax.swing.*

//NOTE getName 确定进行重构和导航时显示的PsiElement的名字
//NOTE setName 确定进行重命名时的逻辑
//NOTE getNameIdentifier ？
//NOTE getTextOffset 确定选中一个PsiElement时，哪一部分会高亮显示
//NOTE getReference 确定选中一个PsiElement时，哪些其他的PsiElement会同时高亮显示

object StellarisLocalizationPsiImplUtil {
	//region StellarisLocalizationLocale
	@JvmStatic
	fun getName(element: StellarisLocalizationLocale): String? {
		return element.localeId.text
	}

	@JvmStatic
	fun setName(element: StellarisLocalizationLocale, name: String): PsiElement {
		element.localeId.replace(createLocale(element.project, name).localeId)
		return element
	}

	@JvmStatic
	fun getNameIdentifier(element: StellarisLocalizationLocale): PsiElement? {
		return element.localeId
	}

	@JvmStatic
	fun getTextOffset(element:StellarisLocalizationLocale):Int{
		return element.startOffset
	}


	@JvmStatic
	fun getIcon(element: StellarisLocalizationLocale, @IconFlags flags: Int): Icon? {
		return AllIcons.FileTypes.Properties
	}

	@JvmStatic
	fun getLocale(element: StellarisLocalizationLocale): StellarisLocale? {
		return StellarisLocale.map[element.name]
	}

	@JvmStatic
	fun getDocumentation(element: StellarisLocalizationLocale): String? {
		return element.locale?.description?.toDefinitionText()
	}
	//endregion

	//region StellarisLocalizationProperty
	@JvmStatic
	fun getName(element: StellarisLocalizationProperty): String? {
		return element.propertyKey.text
	}

	@JvmStatic
	fun setName(element: StellarisLocalizationProperty, name: String): PsiElement {
		element.propertyKey.replace(createPropertyKey(element.project, name))
		return element
	}

	@JvmStatic
	fun getNameIdentifier(element: StellarisLocalizationProperty): PsiElement? {
		return element.propertyKey.keyToken
	}

	@JvmStatic
	fun getIcon(element: StellarisLocalizationProperty, @IconFlags flags: Int): Icon? {
		return PlatformIcons.PROPERTY_ICON
	}

	@JvmStatic
	fun getKey(element:StellarisLocalizationProperty):String{
		return element.propertyKey.text
	}

	@JvmStatic
	fun getValue(element:StellarisLocalizationProperty):String{
		return element.propertyValue?.text.orEmpty()
	}
	//endregion

	//region StellarisLocalizationPropertyValue
	@JvmStatic
	fun getValue(element: StellarisLocalizationPropertyValue): String? {
		return element.text?.unquote()
	}
	//endregion

	//region StellarisLocalizationPropertyReference
	@JvmStatic
	fun getName(element: StellarisLocalizationPropertyReference): String? {
		return element.keyToken?.text
	}

	@JvmStatic
	fun setName(element: StellarisLocalizationPropertyReference, name: String): PsiElement {
		element.keyToken?.replace(createPropertyReference(element.project, name).keyToken!!)
		return element
	}

	@JvmStatic
	fun getNameIdentifier(element: StellarisLocalizationPropertyReference): PsiElement? {
		return element.keyToken
	}

	@JvmStatic
	fun getTextOffset(element:StellarisLocalizationPropertyReference):Int{
		return element.startOffset +1
	}

	@JvmStatic
	fun getReference(element:StellarisLocalizationPropertyReference):PsiReference{
		return StellarisLocalizationPropertyPsiReference(element,element.keyToken?.textRangeInParent)
	}
	//endregion

	//region StellarisLocalizationIcon
	@JvmStatic
	fun getName(element: StellarisLocalizationIcon): String? {
		return element.iconText?.text
	}

	@JvmStatic
	fun setName(element: StellarisLocalizationIcon, name: String): PsiElement {
		element.iconText?.replace(createIcon(element.project, name).iconText!!)
		return element
	}

	@JvmStatic
	fun getNameIdentifier(element: StellarisLocalizationIcon): PsiElement? {
		return element.iconText
	}

	@JvmStatic
	fun getTextOffset(element:StellarisLocalizationIcon):Int{
		return element.startOffset + 1
	}

	@JvmStatic
	fun getDocumentation(element:StellarisLocalizationIcon):String?{
		return element.name?.let{ name -> "(icon) $name".toDefinitionText()}
	}
	//endregion

	//region StellarisLocalizationSerialNumber
	@JvmStatic
	fun getName(element: StellarisLocalizationSerialNumber): String? {
		return element.serialNumberCode?.text
	}

	@JvmStatic
	fun setName(element: StellarisLocalizationSerialNumber, name: String): PsiElement {
		element.serialNumberCode?.replace(createSerialNumber(element.project, name).serialNumberCode!!)
		return element
	}

	@JvmStatic
	fun getNameIdentifier(element: StellarisLocalizationSerialNumber): PsiElement? {
		return element.serialNumberCode
	}

	@JvmStatic
	fun getTextOffset(element:StellarisLocalizationSerialNumber):Int{
		return element.startOffset + 1
	}

	@JvmStatic
	fun getSerialNumber(element:StellarisLocalizationSerialNumber):StellarisSerialNumber?{
		return element.name?.let{ name -> StellarisSerialNumber.map[name]}
	}

	@JvmStatic
	fun getDocumentation(element:StellarisLocalizationSerialNumber):String?{
		return element.serialNumber?.description?.toDefinitionText()
	}
	//endregion

	//region StellarisLocalizationColorfulText
	@JvmStatic
	fun getName(element: StellarisLocalizationColorfulText): String? {
		return element.colorfulTextCode?.text
	}

	@JvmStatic
	fun setName(element: StellarisLocalizationColorfulText, name: String): PsiElement {
		element.colorfulTextCode?.replace(createColorfulText(element.project, name).colorfulTextCode!!)
		return element
	}

	@JvmStatic
	fun getNameIdentifier(element: StellarisLocalizationColorfulText): PsiElement? {
		return element.colorfulTextCode
	}

	@JvmStatic
	fun getTextOffset(element:StellarisLocalizationColorfulText):Int{
		return element.startOffset +1
	}

	@JvmStatic
	fun getColor(element:StellarisLocalizationColorfulText):StellarisColor?{
		return element.name?.let{ name-> StellarisColor.map[name]}
	}

	@JvmStatic
	fun getDocumentation(element:StellarisLocalizationColorfulText):String?{
		return element.color?.description?.toDefinitionText()
	}
	//endregion
}
