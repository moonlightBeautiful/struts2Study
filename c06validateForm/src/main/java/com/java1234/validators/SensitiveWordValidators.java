package com.java1234.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class SensitiveWordValidators extends FieldValidatorSupport {

    @Override
    public void validate(Object object) throws ValidationException {
        String fieldName = this.getFieldName();
        String value = this.getFieldValue(fieldName, object).toString();
        if (containSensitiveWord(value)) {
            this.addFieldError(fieldName, object); //验证失败加入错误消息
        }
    }

    public boolean containSensitiveWord(String value) {
        String sensitiveWords[] = {"操", "你妈"};
        for (String s : sensitiveWords) {
            if(s.indexOf(value) > -1){
                return true;
            }
        }
        return false;
    }

}
