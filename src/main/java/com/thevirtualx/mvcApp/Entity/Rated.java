package com.thevirtualx.mvcApp.Entity;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Rated {


    private String username;
    private int rating;

    protected Rated() {

    }
    public Rated(String username, int rating) {
        this.username = username;
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {

        if(o instanceof Rated) {
            Rated rated = (Rated)o;
            return this.username == rated.getUsername();
        }
        return false;
    }


}
