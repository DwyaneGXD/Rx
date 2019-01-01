package com.oasis.rx.product.tool.reflect;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

/**
 * @author
 * @Time 2017年10月31日
 */
public class ReflectHelper {
    public static Object getFieldValue(Object obj, String fieldName)
            throws IllegalAccessException {

        if (obj == null) {
            return null;
        }

        Field targetField = getTargetField(obj.getClass(), fieldName);

        return FieldUtils.readField(targetField, obj, true);
    }

    public static Field getTargetField(Class<?> targetClass, String fieldName) {
        Field field = null;

        if (targetClass == null) {
            return field;
        }

        if (Object.class.equals(targetClass)) {
            return field;
        }

        field = FieldUtils.getDeclaredField(targetClass, fieldName, true);
        if (field == null) {
            field = getTargetField(targetClass.getSuperclass(), fieldName);
        }

        return field;
    }

    public static void setFieldValue(Object obj, String fieldName, Object value) throws IllegalAccessException {
        if (null == obj) {
            return;
        }
        Field targetField = getTargetField(obj.getClass(), fieldName);
        FieldUtils.writeField(targetField, obj, value);
    }
}
