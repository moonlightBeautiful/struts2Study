#Struts2学习
核心知识
    1.自动set/get数据：
        action类必须要有set/get方法
        请求，自动set匹配参数，按照名字一直规则匹配
            属性驱动：作为action类的属性
                基本数据类型：前台表单元素name=Action类属性名
                数组：前台表多个表单元素name相同，比如checkbox
                bean类型：前台表单元素name=Action类bean属性名.bean类属性名
                List<bean>类型：前台表单元素name=Action类bean属性名[index].bean类属性名
            模型驱动：实现ModelDriven<T>接口，只能接受一种数据类型，很少用到，了解即可。
                bean类型：
                    前台表单元素name=Action类bean类属性名
                    后台User getModel() 方法
        响应，页面自动get要获取的参数  
    2.ActionSupport
        extends ActionSupport，以后不再用Action接口。
        why?
            功能更强大，ActionSupport实现了Action接口和其他很多接口（验证、国际化等）。
    3.配置文件
        package配置
            name：仅仅是包的名字，没啥用，用来分模块吧。
            extends：继承哪个package，有的package有特殊功能，比如拦截器等
            namespace：请求和响应地址的前缀，/开头。
            abstract：boolean，默认false，是否抽象包，true，可以定义一些拦截器，不可以写action。
        action配置
            name：请求地址
            class：请求类
            method：映射的请求，默认执行的方法
        include配置
            file：引入其他的配置文件。可以进行分模块。
        result配置
            name：action返回字符串匹配。
            type：请求转发类型，默认为转发。
                dispatcher，默认内部转发
                redirect，重定向，数据丢失。
                type为chain，则是转发到另一个action，数据会带过去。但是另一个action怎么获取上一个action的值，还不知道。
                type为redirectAction，则重定向另一个action，数据不会带过去。
                dispatcher、redirect、chain、redirectAction、其他的用到再说
        global-results配置，里面配置result
            当响应找不到action中的result，则取全局result中找。   
        *，通配符的使用：
            前台的请求 
                请求1_请求2
            后台的使用
                <action name="*_* 通配符" class="java.com.java1234.action.{1 取值}Action" method="{2 取值}">
        ！，动态方法：请求地址name！action类方法
            1.需要主动开启这个功能，现在官方不建议使用这个功能了。
                <constant name="struts.enable.DynamicMethodInvocation" value="true"/>
            2.前台请求
                请求1!请求2   
            3.后台使用
                <action name="请求1" class="java.com.java1234.action.GradeAction">
                请求2值请求1对应类的方法
    4.Action生命周期
        每次请求，action类的实例都是新的。
                
                
            
            
        