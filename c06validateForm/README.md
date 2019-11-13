#Struts2学习
验证前台jsp表单
    简介：
        基于拦截器，用xml写验证规则，就OK。
    xml验证规则
        1.xml名字默认为action类名-validation.xml，要和action类同目录。
        2.验证标签：
             <field name="user.userName">   //验证字段，要和form表单字段名一直
                <field-validator type="requiredstring"> //验证类型
                    <message>请输入用户名</message>       //验证不通过提示，默认在验证字段的上方提示
                </field-validator>
                 <field-validator type="stringlength">
                    <param name="minLength">6</param>
                    <param name="maxLength">10</param>
                    <message>用户名必须在${minLength}和${maxLength}之间</message>
                </field-validator>
             </field>
             <validator type="expression">  //表达式验证表单字段
                <param name="expression"><![CDATA[!user.name.equals(user.userName)]]></param>  //表达式验证规则，不会。
                <message>用户名和真实姓名不能相同</message>
             </validator>
    预定义验证器
        在源码的validator.xml中
    自定义验证器
        自己写验证器
            实现：继承类FieldValidatorSupport，实现方法validate(Object object)：这个object入参可能是传入的键值对对象
                    String fieldName = this.getFieldName();
                    String fieldValue = this.getFieldValue(fieldName, object).toString();
                    验证失败则添加错误提示信息：this.addFieldError(fieldName, object); //验证失败加入错误消息
                    验证成功什么不用做
        内置的验证：在源码的validator.xml中注册，放在resources目录下
        
            
        
                