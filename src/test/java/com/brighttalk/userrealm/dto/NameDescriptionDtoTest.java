package com.brighttalk.userrealm.dto;

import com.brighttalk.userrealm.entity.Realm;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.Test;

public class NameDescriptionDtoTest {

    @Test
    public void testGetter(){
        PojoClass pojoClass = PojoClassFactory.getPojoClass(Realm.class);
        Validator validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new GetterTester())
                .build();
        validator.validate(pojoClass);
    }
}