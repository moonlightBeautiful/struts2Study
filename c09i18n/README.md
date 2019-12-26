#Struts2学习
国际化：
    简介
        让软件实现多语言支持， internationalization(i18n)
    国际化设置：根据浏览器设置的语言环境Struts2自动切换
        前台使用标签取值 <s:text name="配置文件的key">可以在这里为key的值设置参数</stext>
        配置文件配置多语言：<constant name="struts.custom.i18n.resources" value="随便取值，这里取java1234示例"></constant>
            默认的java1234.properties  
            中文java1234_中文标示.properties  键值对不支持直接写中文，要用Unicode编码，可以使用在线转换器
            英文java1234_英文标示.properties
            