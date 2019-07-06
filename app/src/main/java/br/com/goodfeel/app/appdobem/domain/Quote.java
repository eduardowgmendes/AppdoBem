package br.com.goodfeel.app.appdobem.domain;

import java.io.Serializable;

public class Quote implements Serializable {

    private Author author;
    private String content;

    public Quote(String content, Author author) {
        this.content = content;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
