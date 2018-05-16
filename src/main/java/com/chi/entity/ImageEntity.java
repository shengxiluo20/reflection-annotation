package com.chi.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author chi  2018-05-16 18:05
 **/
@Data
@ToString
public class ImageEntity {

    private String name = "join";

    private String privateUrl = "privateUrl.jpg";

    private String publicUrl = "publicUrl.jpg";

    private Set<String> urls = new TreeSet<String>();

}
