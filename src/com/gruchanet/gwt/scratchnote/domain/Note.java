package com.gruchanet.gwt.scratchnote.domain;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {

    private String text;
    private Date createdAt;

    public Note() {
        this("");
    }

    public Note(String text) {
        this.text = text;
        this.createdAt = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
