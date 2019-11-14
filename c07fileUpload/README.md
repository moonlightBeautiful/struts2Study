#Struts2学习
文件上传
    简介：
        基于拦截器实现，有个预定义拦截器叫fileupload，Struts2使用的是fileupload组件。
    单文件上传和多文件上传：
        JSP页面表单设置
            enctype="multipart/form-data"
        后台接收文件 
            private File 文件表单元素name; // 文件  多文件的话 就是 private File[] 
            private String 文件表单元素nameFileName;  // 文件名，不带路径 文件的话 就是 private String[] 
            private String 文件表单元素nameContentType;  // 文件类型  文件的话 就是 private String[]          
        其他设置
            只允许上传的文件类型和允许上传文件最大尺寸，配置fileUpload拦截器。上传不符合，则前台页面报错<s:fielderror></s:fielderror>。
                 <interceptor-ref name="fileUpload">
                    <param name="allowedTypes">image/bmp,image/x-png,image/gif,image/jpg,image/jpeg</param>
                    <param name="maximumSize">81101</param>
                 </interceptor-ref>
                 <interceptor-ref name="defaultStack"></interceptor-ref>
                fileUpload拦截器执行了2次，但是还ok。   
            文件上传大小默认最大是2M，可配置
                <constant name="struts.multipart.maxSize" value="20000000"></constant>
            验证失败指向页面
                 <!--输入校验失败等情况 ，会自动跳转到name为input的result-->
                 <result name="input">/fileupload.jsp</result>
    文件下载：返回的是文件流
        后台：
           InputStream getInputStream(){返回给浏览器下载}
        xml配置
            <!-- result类型是流(stream)类型，以流的形势返回给客户端。 name存在则跳转，不存在则不跳转。-->
            <result name="success" type="stream">
                <!-- inputName指向被下载文件的来源，对应Action中getInputStream()方法返回的InputStream  -->
                <!-- 最好指定inputName属性的值为inputName，默认从getInputName属性的值()获取流  -->
                <param name="inputName">inputStream</param>
                <!-- contentType指定下载的内容类型，如图片类型、文档类型等……     -->
                <param name="contentType">${contentType}</param>
                <!-- contentDisposition指定文件下载的处理方式，2种，内联(inline)：将文件内容直接显示在页面。附件(attachment)：会弹出文件保存对话框 -->
                <param name="contentDisposition">attachment;filename=${fileName}</param>
            </result>
    Content-Type
        在Http协议消息头中，使用Content-Type来表示具体请求中的媒体类型信息。
        一般格式：Content-Type: text/html;charset:utf-8;
            text/html ： HTML格式
            text/plain ：纯文本格式
            text/xml ：  XML格式
            image/gif ：gif图片格式
            image/jpeg ：jpg图片格式
            image/png：png图片格式
            application/xhtml+xml ：XHTML格式
            application/xml     ： XML数据格式
            application/atom+xml  ：Atom XML聚合格式
            application/json    ： JSON数据格式
            application/pdf       ：pdf格式
            application/msword  ： Word文档格式
            application/octet-stream ： 二进制流数据（如常见的文件下载）
            application/x-www-form-urlencoded ： <form encType=””>中默认的encType，form表单数据被编码为key/value格式发送到服务器（表单默认的提交数据的格式）
            multipart/form-data ： 需要在表单中进行文件上传时，就需要使用该格式
                 
       
    