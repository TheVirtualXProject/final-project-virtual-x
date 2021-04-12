package com.thevirtualx.mvcApp.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {
//neeeds fleshed out
    //html codes, embedded in thymeleaf
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
