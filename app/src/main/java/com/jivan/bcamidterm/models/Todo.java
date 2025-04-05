package com.jivan.bcamidterm.models;

public class Todo {
    private String title;
    private String desc;
    private boolean isCompleted;

    public Todo(String title, String desc, boolean isCompleted) {
        this.title = title;
        this.desc = desc;
        this.isCompleted = isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
