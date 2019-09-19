package Devices;

import Components.Component;
import java.util.ArrayList;
import java.util.TreeMap;

public abstract class Device {
    protected int id;
    protected String name;
    protected TreeMap<Integer, Component> components;
    protected Status status;

    public Device(){}

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

   /* public void setComponents(TreeMap<Integer, Component>) {
        this.components = components;
    }*/

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
