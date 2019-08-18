package com.javabasics.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Utils {
    public static Class<?> getGenericTypeClassFromObjectByIndex(Object obj,int genericTypeIndex) {
        Type genericSuperClass=obj.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType=null;
        while(parameterizedType==null) {
            if(genericSuperClass instanceof ParameterizedType) {
                parameterizedType=(ParameterizedType)genericSuperClass;
            } else {
                genericSuperClass=((Class<?>)genericSuperClass).getGenericSuperclass();
            }
        }
        return (Class<?>)parameterizedType.getActualTypeArguments()[genericTypeIndex];
    }
}
