package com.tokid.model;/*
* @Description: TODO
* @author king
* @date 2018/9/11  19:52
*/

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "dbo.amt_user_k")
public class KUser implements Serializable {

    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
