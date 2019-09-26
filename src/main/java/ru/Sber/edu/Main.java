package ru.Sber.edu;

import ru.Sber.edu.Components.Accumulator;
import ru.Sber.edu.Components.Camera;
import ru.Sber.edu.Components.Component;
import ru.Sber.edu.Devices.Device;
import ru.Sber.edu.Devices.Mobile;
import ru.Sber.edu.Devices.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TreeMap;

public class Main {

    private TreeMap<Integer, Device> tm;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private Main() {
        tm = new TreeMap<Integer, Device>();
    }

    private TreeMap<Integer, Device> getTm() {
        return tm;
    }

    private void setTm(TreeMap<Integer, Device> tm) {
        this.tm = tm;
    }

    private void Event(int deviceId, int componentId, String event) {
        Device device = tm.get(deviceId);
        Component component = device.getComponents().get(componentId);
        boolean status = component.isStatus();
        if (event == "ErrorEvent")
            component.setStatus(false);
        else if (event == "RestoreEvent")
            component.setStatus(true);
        if (status != component.isStatus())
            checked(device);
    }

    private void checked(Device device) {
        int count = 0;
        int size = device.getComponents().size();
        for (Component component : device.getComponents().values()) {
            if (component.isStatus() == false)
                count++;
        }
        if (count == 0) {
            device.setStatus(Status.normal);
            logger.info("Устройство id = " + device.getId() + ", name = " + device.getName() + " изменило свое состояние на " + Status.normal);
            return;
        }
        if (count == 1) {
            device.setStatus(Status.warning);
            logger.info("Устройство id = " + device.getId() + ", name = " + device.getName() + " изменило свое состояние на " + Status.warning);
            return;
        }
        if (count >= size / 2) {
            device.setStatus(Status.error);
            logger.info("Устройство id = " + device.getId() + ", name = " + device.getName() + " изменило свое состояние на " + Status.error);
        }
    }

    public static void main(String[] arg) {
        Main m = new Main();
        Accumulator cameron = new Accumulator(10, "Cameron", true);
        Camera front_camera = new Camera(20, "canon", true);
        Camera back_camera = new Camera(30, "pixer", true);

        TreeMap<Integer, Component> tr = new TreeMap<Integer, Component>();
        tr.put(cameron.getId(), cameron);
        tr.put(front_camera.getId(), front_camera);
        tr.put(back_camera.getId(), back_camera);

        Mobile sumsung = new Mobile(1, "sumsung", tr, Status.normal);
        m.tm.put(sumsung.getId(), sumsung);

        m.Event(1, 10, "ErrorEvent");
        m.Event(1, 20, "ErrorEvent");
        m.Event(1, 10, "RestoreEvent");
        m.Event(1, 20, "RestoreEvent");

    }
}
