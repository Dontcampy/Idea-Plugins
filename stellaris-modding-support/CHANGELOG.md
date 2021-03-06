# 版本

## 1.x

### 1.0

* 创建语言文件类型和图标
* 更新中
* 更新和整理代码
* 完成基础功能

### 1.1

* 更新版本

### 1.2

* [X] 脚本文件：允许变量名中有大写字母
* [X] 脚本文件：代码格式设置和格式化
* [X] 脚本文件：代码检查 - ［警告］重复的变量定义 → 导航到重复的变量定义
* [X] 脚本文件：代码检查 - ［警告］非法的文件编码 → 转化为正确的文件编码（除了name_list是`UTF-8 BOM`之外，必须是`UTF-8 NO BOM`）
* [X] 本地化文件：代码格式设置和格式化
* [X] 本地化文件：代码检查 - ［警告］重复的属性 → 导航到重复的属性
* [X] 本地化文件：语法词法解析 - 允许属性名和冒号之间有空格，但是格式化时总是会去掉
* [X] 本地化文件：代码检查 - ［错误］不支持的语言区域 → 选择语言区域（语法上允许其他语言区域）
* [X] 本地化文件：代码检查 - ［警告］非法的文件编码 → 转化为正确的文件编码（必须是`UTF-8 BOM`）
* [X] 本地化文件：代码检查 - ［警告］非法的文件名 → ~~重命名文件名~~（必须包含语言区域字符串如`l_simp_chinese`）

### 1.3

* 更新项目文档

### 1.4

* [X] 更新项目代码结构
* [X] 完成引用部分代码，未完整测试
* [X] 本地化文件属性，脚本文件变量：实现定位定义功能
* [X] 本地化文件属性，脚本文件变量：实现提供文档注释功能
* [X] 完善文档注释功能。
* [X] 定位定义：脚本文件的字符串 - 可能的脚本文件/本地化文件的属性
* [X] 实现ElementDescriptionProvider，提供元素的描述（用于查找引用）
* [X] 完善文档注释功能和代码补全功能
* [X] 测试通过查找使用功能
* [X] 完善对本地化文件富文本的支持
* [X] 删除多余的代码
* [X] 本地化文件的属性引用兼容额外参数
* [X] 对于属性引用的代码提示（来自属性的引用）
* [X] 解决BUG：脚本文件Lexer的问题导致Editor永久卡顿下去的恶性BUG（当输入propertyKey时，Lexer468行，不要随便使用`yypushback()`）
* [X] 解决BUG：本地化文件属性的查找使用只能找到单个使用的静态代码提示不起作用（重载为`PsiPolyVariantReference.resolveReference()`）
* [X] 解决BUG：时间区域的静态代码提示不起作用（pattern不对，需要通过代码调试得出）
* [X] 解决BUG：脚本文件关键词的静态代码提示不起作用（pattern不对，需要通过代码调试得出）
* [X] 对于语言区域的代码提示（确保匹配范围准确）

### 1.5

* [X] 解决关于代码补全的小bug。

### 1.6
 
修复一些BUG和问题。
 
* [X] LocalizationPropertyKey/ScriptPropertyKey可以包含`-`
* [X] ScriptPropertyKey/ScriptText实际上都可以仅包含大写/小写字母
* [X] ScriptPropertyKey可以是`NOT` `NOR` `AND` `OR`
* [X] LocalizationProperty可以不包含number（在`localization_synced`目录中）
* [X] 将GutterIcon的尺寸调小一点。
* [X] 支持gfx引用文件（`.gfx`）
* [X] ScriptUnquotedString只要不包含空格即可
* [X] 仅对顶层的ScriptProperty添加文档注释并视为可能的引用
* [X] 对于变量的代码提示（来自变量的引用）
* [X] 更新项目描述
* [X] 高亮转义字符
* [X] 重构和重命名Psi
* [X] 修复BUG

### 1.7

语法兼容性优化。

* [X] 修复对于语言区域的代码补全中的BUG，当提示时包含已输入的字符
* [X] 为脚本文件提供Json Schema的支持（完成代码的编写，但未测试）
* [X] annotator解析多个引用结果
* [X] 更新项目文档
* [X] 优化性能
* [X] 取消在页面右边显示彩色文本的颜色（因为可能有很多）
* [X] "="周围可以没有空格（限制unquotedString）
* [X] 限制scriptUnquotedString：不包含`{}[]="\s`
* [X] scriptUnquotedString实际上也可以不包含大写字母（允许的属性名：`portraits`，来自name_list）
* [X] scriptPropertyName，不是顶级属性时，仍然可以包含大写字母（但不以大写字母开头）
* [X] 图标名也可以是属性引用
* [X] 认为序号必须是`%x%`，其中`x`长度只能为1，同时`%`不需要在字符串中转义
* [X] 颜色文本可以嵌套
* [X] LocalIntention不要直接定义为object，可能存在问题
* [X] scriptString显示文本时去除包围的引号
* [X] ClassCastException（数组不要直接转换泛型）

### 1.8

语法兼容性优化。

* [X] 数字可以是负数
* [X] 值（字符串）也可以在顶层
* [X] 数字也可以作为数组的元素，即，`{1 2 3}`是合法的
* [X] LocalIntention：ClassNotFoundException（`intentionAction.className`标签中不能有任何空格）（黑人问号？？？）
* [X] 更新结构视图和面包屑导航以匹配完善后的语法。
* [X] 补充关于Color类型的代码。

### 1.9

语法兼容性优化。

* [X] scriptUnquoteString可以包含非开头的`@`
* [X] gutterIcon可以导航到多个localizationProperty
* [X] 注释可以放在`{...}`块的末尾几行
* [X] 修复描述文本中的一些错误
* [X] 变量定义之前的注释与变量定义之间不需要有空行
* [X] 允许单独的`§R`（这也可以？？？）
* [X] DocComment：仅允许第一个空行之前的LineComment作为DocComment
* [X] 更新项目和插件文档

### 1.10
 
* [X] scriptProperty也可以在同一行

### 2.0
 
* [X] 更新IDE版本
* [X] 兼容颜色语法（作为一种类型）：`rgb { 142 188 241 }`

### 2.1
 
* [X] 生成文档注释时，当属性的值的文本过长时，截断文本
* [X] 本地化文件的属性名可以以数字开头，也可以包含单引号
* [X] 本地化文件的颜色码可以为小写
* [X] 本地化文件的属性值可以直接包含双引号而无需转义
* [X] 语言区域也可以是`l_default`
* [X] 官方文件中，同一个本地化文件中有存在重复的属性的情况，但仍然认为不应当重复
* [X] 取消对于本地化文件的文件名的检查（存在特例）
* [X] 增强对于脚本文件颜色的支持，支持rgb/rgba/hsb/hsv/hsl，支持通过gutterIcon预览和更改颜色
* [X] 完善项目文档

### 2.2

* [X] 调整代码检查的错误级别，将大部分检查的错误级别改为WARNING而非ERROR
* [X] 对于脚本文件颜色，通过gutterIcon更改颜色时，使用rgb或者rgba
* [X] 认为本地化文件的编号和颜色码是忽略大小写的（暂不清楚颜色码g对应什么颜色）
* [X] 文件类型使用IDE原版图标，而非以游戏图标为背景的图标
* [X] 添加关于游戏目录和mod目录的设置（暂时还不能解析这些目录下的引用）

### 2.3

* [X] 修复从`example.yml`文件获取文本时，开头有意外字符的bug（不要为该文件添加bom）
* [X] 脚本文件-语法解析：如果在属性分隔符后换行，则期待属性键，而非属性值
* [X] 脚本文件-语法解析：允许属性键中包含":"
* [X] 本地化文件-语法解析：即使存在属性引用分隔符，属性引用参数也是可选的
* [X] 本地化文件-语法解析：尽管实际上属性值中的双引号不需要转义，这里认为是语法错误 + 允许行尾注释
* [X] 完善格式化功能

### 2.4

基本完成脚本文件的Schema验证功能。

* [X] 解决加载扩展时的ClassNotFoundException（如果`/src/main/kotlin`中包含java文件，那么`sourceSets.java`需要包含这个目录）
* [X] 解决`String.toClassPathResource()`扩展方法的bug（最好基于特定的Class而非ClassLoader，需要考虑发布版本从jar中读取的情况）
* [X] Schema：进行代码补全时，插入等号而非冒号（原始代码是硬编码，需要自行调整）
* [X] Schema：可以从属性名定位到Schema文件中的定义处
* [X] Schema：根据文件名和所在目录，自动关联对应的Schema文件
* [X] Schema：进行Schema验证，当规则不匹配时显示错误
* [X] Schema：由Yaml Schema生成Json Schema，jar包中需要Json Schema（Yaml Schema不识别并且可能产生意外错误）
* [X] Schema：更加符合格式的代码补全（光标向右移1格，数组和对象补全不换行）
* [X] Schema：从Yaml Schema生成Json Schema时，不将yes/no识别为布尔值

### 2.5

* [ ] 更新项目文档
* [ ] Schema：解决jar包中的指向其他schema文件的`$ref`属性不能正确工作的bug
* [ ] Schema：为脚本文件提供较为完善的Schema文件
* [ ] 仅当找到descriptor.mod文件时，才将所在目录中你的yml文件和txt文件识别为本地化文件和脚本文件

# TODO

* [ ] 格式化：本地化文件中，语言区域之后，除了非行尾注释以外，属性也要缩进
* [ ] 意向：scriptUnquotedString，引号括起
* [ ] 意向：scriptString，移除包围的引号（如果移除引号后是合法的scriptUnquotedString）
* [ ] 更多的引用类型：event_id，gfx_reference，path
* [ ] 为脚本文件编写基础的Json Schema
* [ ] 根据脚本文件的位置和后缀名，为其应用对应的Json Schema
* [ ] 一个本地化文件实际上可以包含多个语言区域+下面的属性，当文件名中存在语言区域时要匹配
* [ ] 通过网络爬虫爬取<https://stellaris.paradoxwikis.com/>中的相关内容，以生成更完善的schema（不适合，部分条目不匹配）
