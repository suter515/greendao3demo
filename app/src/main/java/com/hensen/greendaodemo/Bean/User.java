package com.hensen.greendaodemo.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类注释：
 * Created by sujingtai on 2017/6/27 0027 上午 10:42
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String image_url;
    @Transient
    private int tempUsageCount;
    @Generated(hash = 286018229)
    public User(Long id, String name, String image_url) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage_url() {
        return this.image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
