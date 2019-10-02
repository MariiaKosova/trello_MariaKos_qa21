package com.trello.qa.model;

public class BoardData {
    private String title;
    private String status;

//    public BoardData(String title, String status) {
//        this.title = title;
//        this.status = status;
//    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public BoardData setTitle(String title) {
        this.title = title;
        return this;
    }

    public BoardData setStatus(String status) {
        this.status = status;
        return this;
    }
}
