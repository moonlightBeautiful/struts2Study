#Struts2学习
值栈
    简介：
        每个请求对象的一套内存数据的封装，struts2为每个请求创建一个单独的值栈，也就是一个请求对应一个值栈，值栈封装了一次请求所有需要的数据
        通俗的讲：就是把request session application 相关的数据等都封装起来供请求使用
        每次请求，核心控制器StrutsPrepareAndExecuteFilter都会创建一个ActionContext和ValueStack对象。这两个对象存储了整个动作访问期间用到的数据。
    狭义值栈
        指实现ValueStack接口的对象，目前就是OgnlValueStack的对象。主要用来支持OGNL运算的。
        里面存放着一些OGNL可以存取的数据，比如：
            Action的实例（这样就可以访问action实例中的属性）
            OGNL表达式运算的值，可以存放到值栈中。
            OGNL表达式产生的中间变量，比如使用循环标签，自然后循环产生的变量，会存放到值栈中。
        ValueStack值栈可以存储多个相同的对象，会从栈顶到栈底顺序匹配，找到了就不会再往下找，值栈是list
        获取：
            ActionContext.getValueStack()
        使用
            set(key,value)  设置值，应该可以重复，我试一试，会不会覆盖，看大小，重复key，看看大小会不会变。    
    广义值栈
        通常指ActionContext对象。是Action运行上下文，每个ActionContext对象是一个基本容器，包含着Action对象运行所需要的数据。
        线程安全，每个线程都一个独立的ActionContext对象。
        里面存放着很多数据，比如：
            request、session、application、valueStack、attr、parameters
        获取：
            ActionContext actionContext = ActionContext.getContext()
            或者
            ActionContext actionContext = actionInvocation.getInvocationContext()
        使用：ActionContext主要功能是存放数据
            get(String key)：根据key从ActionContext当前的存储空间里面获取相应的值。
            put(String key, Object value)：把值存储在ActionContext的存储空间里面。
            Map<String,Object> getApplication()：返回ServletContext中存储的值。
            Map<String,Object>: getSession()：返回HttpSession中存储的值。
            Map<String,Object>: getContextMap()：返回当前context存储的值。或许就是全部的键值对吧，
            Map<String,Object>: getParameters()：返回HttpServletRequest对象里面存储的，客户端提交的参数。
            ValueStack getValueStack()：获取OGNL的值栈。       
    狭义与广义
        因为广义包含狭义，所以ActionContext是广义，ValueStack是狭义。在没有特别说明的情况下，多数指的是广义值栈，当然，JSP页面上OGNL默认是狭义。
    OGNL
        对象图导航语言，如果没有特别声明，OGNL访问的就是valueStack里面的数据。
        如果要访问ActionContext的数据，要生命范围 
            #parameters  = request.getParameter（...）；
            #request  =  request.Attribute(...)
            #session   =  session.Attribute(...)
            #application   =  application.Attribute(...
            #attr = 按照page request session application顺序查找
        访问数据：
            首先：jsp头部设置开启标签：<%@taglib prefix="s" uri="/struts-tags" %>
            然后，jsp获取值：<s:property value="设置的属性"/>
        数据类型
            基本数据和String类型： <s:property value="属性名"/>
            bean： <s:property value="属性名.属性名"/>
            list<bean>：<s:property value="属性名[index].属性名"/>
            map<String,bean>：<s:property value="属性名['key].属性名"/>
            静态属性：
                <s:property value="@全类名@静态属性名"/>
            静态方法：
                默认不允许访问静态方法，所以要现在配置文件中开启：
                <constant name="struts.ognl.allowStaticMethodAccess" value="true"></constant> 
                <s:property value="@全类名@静态方法名"/> 如果静态方法有返回值，则会输出在jsp界面。
        