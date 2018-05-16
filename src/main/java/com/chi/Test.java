package com.chi;

import com.chi.entity.ImageDto;
import com.chi.entity.ImageEntity;
import com.chi.util.QiniuCovertUtil;

import java.util.TreeSet;

/**
 * @author chi  2018-05-16 18:23
 **/
public class Test {

    public static void main(String[] args) throws Exception{
        ImageEntity imageEntity = new ImageEntity();
        TreeSet<String> urls = new TreeSet<>();
        urls.add("1.jpg");
        urls.add("2.jpg");
        urls.add("3.jpg");
        imageEntity.setUrls(urls);

        System.out.println(imageEntity.toString());

        ImageDto imageDto = QiniuCovertUtil.covertObject(imageEntity, ImageDto.class);
        System.out.println(imageDto.toString());
    }
}
