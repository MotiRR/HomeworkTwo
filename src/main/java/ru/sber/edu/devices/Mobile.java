package ru.sber.edu.devices;

import ru.sber.edu.components.Component;

import java.util.TreeMap;

public class Mobile extends Device {

    public Mobile() {
        super();
    }

    public Mobile(int id, String name, TreeMap<Integer, Component> components, Status status) {
        super(id, name, components, status);
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", components='" + getComponents() + '\'' +
                ", status=" + getStatus() +
                '}';
    }
}
