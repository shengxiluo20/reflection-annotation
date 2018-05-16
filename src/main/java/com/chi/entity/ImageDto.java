package com.chi.entity;

import com.chi.util.PicUrl;
import lombok.Data;
import lombok.ToString;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author chi  2018-05-16 18:05
 **/
@Data
@ToString
public class ImageDto {

    private String name;

    @PicUrl(isPrivate = true)
    private String privateUrl;

    @PicUrl
    private String publicUrl;

    @PicUrl(isPrivate = true)
    private Set<String> urls = new TreeSet<>();

}
