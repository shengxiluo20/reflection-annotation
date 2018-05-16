package com.chi.util;


import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chi  2018-05-14 15:29
 **/
public class QiniuUrl {


    /**
     * 获得url的具体地址
     *
     * @param fileName
     * @param isPrivate true:私有地址   false:共有地址
     * @return
     */
    public static String getUrl(String fileName, boolean isPrivate) {
        if (isPrivate) {
            return "pic.baidu.com/" + fileName + "?token=11111";
        } else {
            return "pic.baidu.com/" + fileName;
        }
    }

    /**
     * 默认开放地址
     *
     * @param fileName
     * @return
     */
    public static String getUrl(String fileName) {
        return getUrl(fileName, false);
    }

    /**
     * 支持set统一转换
     *
     * @param set
     * @param isPrivate
     * @return
     */
    public static Set<String> getUrls(Set<String> set, final boolean isPrivate) {
        return set.stream().map(name -> QiniuUrl.getUrl(name, isPrivate)).collect(Collectors.toSet());
    }
}
