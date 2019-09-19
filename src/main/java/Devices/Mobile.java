package Devices;

import Components.Component;
import java.util.ArrayList;
import java.util.TreeMap;

public class Mobile extends Device {

    public Mobile(){
        super();
    }

    public Mobile(int id, String name, TreeMap<Integer, Component> components, Status status) {
        super(id, name, components, status);
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", components='" + components + '\'' +
                ", status=" + status +
                '}';
    }
}
