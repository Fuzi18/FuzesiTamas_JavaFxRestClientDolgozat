package com.example.demo;

import com.google.gson.annotations.Expose;

public class Players {
    private int id;
    @Expose
    private String name;
    @Expose
    private String location;
    @Expose
    private int age;
    @Expose
    private boolean score;

    public Players(int id, String name, String location, int age, String score) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.age = age;
        this.score= Boolean.parseBoolean(score);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setEmail(String location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isScore() {
        return score;
    }

    public void setScore(boolean score) {
        this.score = score;
    }
}
