package com.example;

public class NameService {
    private String name;

    public NameService(String name) {
        this.name = name;
    }

    public String getName() {
        return name.toUpperCase();
    }
}
