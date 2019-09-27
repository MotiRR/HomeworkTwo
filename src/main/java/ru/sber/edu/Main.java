package ru.sber.edu;

import ru.sber.edu.components.Accumulator;
import ru.sber.edu.components.Camera;
import ru.sber.edu.components.Component;
import ru.sber.edu.devices.Device;
import ru.sber.edu.devices.Mobile;
import ru.sber.edu.devices.Status;

import java.util.TreeMap;

public class Main {

    private TreeMap<Integer, Device> deviceTreeMap;

    private Main() {
        deviceTreeMap = new TreeMap<Integer, Device>();
    }

    public static void main(String[] arg) {
        Main m = new Main();
        CheckingEvent checkEvent = new CheckingEvent();

        Accumulator cameron = new Accumulator(10, "Cameron", true);
        Camera frontCamera = new Camera(20, "canon", true);
        Camera backCamera = new Camera(30, "pixer", true);

        TreeMap<Integer, Component> tr = new TreeMap<Integer, Component>();
        tr.put(cameron.getId(), cameron);
        tr.put(frontCamera.getId(), frontCamera);
        tr.put(backCamera.getId(), backCamera);

        Mobile sumsung = new Mobile(1, "sumsung", tr, Status.normal);
        m.deviceTreeMap.put(sumsung.getId(), sumsung);

        checkEvent.Event(1, 10, "ErrorEvent", m.deviceTreeMap);
        checkEvent.Event(1, 20, "ErrorEvent", m.deviceTreeMap);
        checkEvent.Event(1, 10, "RestoreEvent", m.deviceTreeMap);
        checkEvent.Event(1, 20, "RestoreEvent", m.deviceTreeMap);

    }
}
