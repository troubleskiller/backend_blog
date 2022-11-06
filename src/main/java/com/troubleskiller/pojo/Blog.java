package com.troubleskiller.pojo;

import java.sql.Timestamp;

public class Blog {
    private Integer id;
    private Integer category_id;
    private String title;
    private String content;
    private int type;
    private int status;
    private Timestamp publish_time;

    public Blog( Integer category_id, String title, String content, int type, int status, Timestamp publish_time) {
        this.category_id = category_id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.status = status;
        this.publish_time = publish_time;
    }

    public Blog() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getcategory_id() {
        return category_id;
    }

    public void setcategory_id(Integer category_id) {
        this.category_id = category_id;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Timestamp publish_time) {
        this.publish_time = publish_time;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", publish_time='" + publish_time + '\'' +
                '}';
    }



}
