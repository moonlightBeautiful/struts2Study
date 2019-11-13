package com.java1234.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class SensitiveWordValidators extends FieldValidatorSupport {

    @Override
    public void validate(Object object) throws ValidationException {
        String fieldName = this.getFieldName();
        String value = this.getFieldValue(fieldName, object).toString();
        if (containSensitiveWord(value)) {
            this.addFieldError(fieldName, object); //��֤ʧ�ܼ��������Ϣ
        }
    }

    public boolean containSensitiveWord(String value) {
        String sensitiveWords[] = {"��", "����"};
        for (String s : sensitiveWords) {
            if(s.indexOf(value) > -1){
                return true;
            }
        }
        return false;
    }

}
