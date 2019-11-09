#Struts2学习
    1.hello
        简介：
            Struts2是Struts1+WebWork的结合，是一个全新的MVC框架。Struts1已经不流行了。
            Struts2更适合企业级团队开发，方便系统维护。采用拦截器机制来处理用户请求，在模块化的处理和页面的展现方面发挥吊炸天作用。
        编码：
            1.pom引入依赖
            2.web.xml配置核心分发器
            3.struts.xml配置文件
            4.Action类，要实现implements Action接口
    2.核心知识
        1.自动set/get数据：action类要有set/get方法
            请求，自动set匹配参数，按照名字匹配
                属性驱动：作为action类的属性
                    基本数据类型：前台表单元素name=Action类属性名
                    数组：前台表单元素name相同多个表单元素，比如checkbox
                    bean类型：前台表单元素name=Action类bean属性名.bean类属性名
                    List<bean>类型：前台表单元素name=Action类bean属性名[index].bean类属性名
                模型驱动：实现ModelDriven<T>接口，只能接受一种数据类型
                    基本数据类型：前台表单元素name=Action类属性名
                    bean类型：前台表单元素name=Action类bean类属性名
            响应，页面自动get要获取的参数  
        2.ActionSupport
            extends ActionSupport，以后不再用Action接口。
            why
                功能更强大，ActionSupport实现了Action接口和其他很多接口（验证、国际化等）。
        3.配置文件
            package配置
                name：仅仅是包的名字，没啥用，用来分模块吧。
                extends：继承哪个package，有的package有特殊功能，比如拦截器等
                namespace：请求和响应地址的前缀，/开头。
                abstract：boolean，默认false，是否抽象包。
            action配置
                name：请求地址
                class：请求类
                method：请求类的方法
            include配置
                file：其他的配置文件，引入其他的配置文件。
            result配置
                name：action返回字符串匹配。
                type：请求转发类型，默认为转发。
                    type为chain，则是转发到另一个action，数据会带过去。但是另一个action怎么获取上一个action的值，还不知道。
                    type为redirectAction，则从定向另一个action，数据不会带过去。
                    dispatcher、redirect、chain、redirectAction、其他的用到再说
            global-results配置，里面配置result
                当响应找不到action中的result，则取全局result中找。   
            *，通配符的使用：action配置上使用
                请求地址name上可以用通配符匹配请求地址，处理请求的类class和方法method可以用{index，从1开始}获取通配符匹配的字符串
            ！，动态方法：请求地址name！action类方法
                需要主动开启这个功能，现在官方不建议使用这个功能了。
                开启：<constant > </>
                action配置上：method不要配置。
                前台请求为：请求地址!action类的方法。
            
        4.Action生命周期
            每次请求，action类的实例都是新的。
                
                
            
            
        