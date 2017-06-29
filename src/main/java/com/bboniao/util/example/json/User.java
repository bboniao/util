package com.bboniao.util.example.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * Created by guhb on 27/06/2017.
 */
//是为了反序列化的时候，如果遇到不认识的filed，忽略之
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    private String name;
    private Integer age;
    private Date birthday;
    private String email;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public User setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}
