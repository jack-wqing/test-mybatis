package com.test.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User implements Serializable{

    private static final long serialVersionUID = 1221899750956708487L;

    private Long id;
    
    private String username;
    
    private Integer age;
    
    private Date createTime;
    
    private Date updateTime;

    public User() {
        super();
    }

    public User(Long id, String username, Integer age, Date createTime,
            Date updateTime) {
        super();
        this.id = id;
        this.username = username;
        this.age = age;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", age=" + age
                + ", createTime=" + createTime + ", updateTime=" + updateTime
                + "]";
    }
    
}
