package com.chi.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author chi  2018-05-16 15:26
 **/
public class QiniuCovertUtil {

    /**
     * 接收对象,并生成新对象
     * @param source
     * @param targetClass
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T covertObject(Object source, Class<T> targetClass) throws Exception {
        Class<?> sourceClass = source.getClass();
        T target = (T) targetClass.newInstance();
        BeanUtils.copyProperties(source, target);
        //获取所有的字段
        Field[] fields = targetClass.getDeclaredFields();
        for (Field field : fields) {
            boolean fieldHasAnno = field.isAnnotationPresent(PicUrl.class);
            if (fieldHasAnno) {
                PicUrl fieldAnno = field.getAnnotation(PicUrl.class);
                Class<?> type = field.getType();

                //输出注解属性
                System.out.println(field.getName() + " 有相应注解,值为: " + fieldAnno.isPrivate());

                if (type == String.class) {
                    //找到相应的set方法
                    Method targetSetMethod = targetClass.getDeclaredMethod(parSetName(field.getName()), String.class);
                    Method sourceGetMethod = sourceClass.getDeclaredMethod(parGetName(field.getName()));
                    //赋set值
                    targetSetMethod.invoke(target, QiniuUrl.getUrl((String) sourceGetMethod.invoke(source), fieldAnno.isPrivate()));
                } else if (type == Set.class) {
                    //找到相应的set方法
                    Method targetSetMethod = targetClass.getDeclaredMethod(parSetName(field.getName()), Set.class);
                    Method sourceGetMethod = sourceClass.getDeclaredMethod(parGetName(field.getName()));
                    //赋set值
                    targetSetMethod.invoke(target, QiniuUrl.getUrls((Set) sourceGetMethod.invoke(source), fieldAnno.isPrivate()));
                }

            }
        }

        return target;
    }


    /**
     * 拼接在某属性的 get方法
     *
     * @param fieldName
     * @return String
     */
    private static String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_')
            startIndex = 1;
        return "get"
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);
    }

    /**
     * 拼接在某属性的 set方法
     *
     * @param fieldName
     * @return String
     */
    private static String parSetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_')
            startIndex = 1;
        return "set"
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);
    }
}
