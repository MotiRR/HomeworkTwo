package ru.sber.edu.devices;

import ru.sber.edu.components.Component;

import java.util.TreeMap;

public abstract class Device {
    private int id;
    private String name;
    private TreeMap<Integer, Component> components;
    private Status status;

    public Device() {
    }

    public Device(int id, String name, TreeMap<Integer, Component> components, Status status) {
        this.id = id;
        this.name = name;
        this.components = components;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setComponents(TreeMap<Integer, Component> components) {
        this.components = components;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TreeMap<Integer, Component> getComponents() {
        return components;
    }

    public Status getStatus() {
        return status;
    }
}
