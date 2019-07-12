package com.brighttalk.userrealm.dto;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import org.junit.Test;

public class NameDescriptionDtoTest {

    @Test
    public void testGetter() {
        PojoClass pojoClass = PojoClassFactory.getPojoClass(NameDescriptionDto.class);
        Validator validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new GetterTester())
                .build();
        validator.validate(pojoClass);
    }
}