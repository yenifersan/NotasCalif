package com.santiago.notascalif.models;

import com.orm.dsl.Table;

@Table
public class Nota {

    private Long id;
    private String title;
    private String content;
    private Long date;

    public Nota(String title, String content, Long date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Nota(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
