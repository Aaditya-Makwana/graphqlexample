package com.aaditya.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test")
public class Test {
    @Id
    private Integer id;
    private String desc;

    public Test(Integer id, String desc){
        this.id = id;
        this.desc = desc;
    }

    public Test(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
