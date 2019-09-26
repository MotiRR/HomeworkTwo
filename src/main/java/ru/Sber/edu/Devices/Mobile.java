package ru.Sber.edu.Devices;

import ru.Sber.edu.Components.Component;

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
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", components='" + super.getComponents() + '\'' +
                ", status=" + super.getStatus() +
                '}';
    }
}
