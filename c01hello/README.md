#Struts2学习
hello
    简介：
        Struts2是Struts1+WebWork的结合，是一个全新的MVC框架。Struts1已经不流行了。
        Struts2更适合企业级团队开发，方便系统维护。采用拦截器机制来处理用户请求，在模块化的处理和页面的展现方面发挥吊炸天作用。
    hello编码：
        1.pom引入依赖
            <dependency>
                <groupId>org.apache.struts</groupId>
                <artifactId>struts2-core</artifactId>
                <version>2.3.35</version>
            </dependency>
        2.web.xml配置核心分发器
            <filter>
                <filter-name>Struts2</filter-name>
                <filter-class>
                    org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter
                </filter-class>
            </filter>
            <filter-mapping>
                <filter-name>Struts2</filter-name>
                <url-pattern>/*</url-pattern>
            </filter-mapping>
        3.struts.xml配置文件
            <struts>
                <package name="hello无意义，仅仅为了识别" extends="struts-default 一般都是集成这个">
                    <action name="hello" class="com.java1234.action.HelloAction Action类">
                        <result name="success">hello.jsp</result>
                    </action>
                </package>
            </struts>
        4.Action类，要实现Action接口
    原理
        请求-核心控制器把请求分发给对应的处理action-处理完之后，找到对应的响应转发到对应的页面