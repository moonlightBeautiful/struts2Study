#Struts2学习
拦截器   
    简介：          
        请求action之前和之后调用，可拔插，AOP的一种实现。
    预定义拦截器和拦截器栈
        在sruts2源码的struts-default.xml中
        其中，自己的package中extend="struts-default"，就是继承了sruts2预定义的拦截器。
        action方法执行之前和之后，是默认的拦截器进行了set和get     
    规则：
        1.拦截器是有顺序的，自上往下。
        2.如果action内指定拦截器，则默认的拦截器不会再被使用 
        3.默认的拦截器栈是可以更改的，default-interceptor-ref="新的拦截器" 
    自定义拦截器编码
        1.自义定拦截器类实现接口Interceptor，并实现3个方法int、destroy、intercept 
            1.void init();	 在服务器起动的时候，读取配置文件加载一次,并且只加载一次；
            2.void destroy();	在服务器关闭时销毁；
            3.String intercept(ActionInvocation invocation) throws Exception： 拦截器执行的方法 
                1.invocation.invoke()，调用下一个拦截器。如果没有下一个拦截器，那么调用Action。
                2.invocation.invoke()方法之前和之后是拦截器的操作，返回值是action的返回值 。
        2.在xml文件中定义拦截器和在action配置拦截器    
    自定义拦截器栈
    ActionContext actionContext=invocation.getInvocationContext(); 可以获取上下文，相当于servlet的上下文