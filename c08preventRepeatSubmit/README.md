#Struts2学习
防止form重复提交
    重复提交例子
        Thread.sleep(5000);
    防止重复提交方式
        1.拦截器token，重复提交跳转到指定页面
            jsp页面form中添加标签<s:token> + 重复提交跳转到指定页面中添加标签<s:actionerror/> 
            xml中action配置拦截器token和配置重复提交<result name="invalid.token">则跳转到指定页面</result>
        2.action拦截器tokenSession，无视重复提交
            jsp页面form中添加标签<s:token> + 添加标签<s:actionerror/> 
            xml中action配置拦截器tokenSession
