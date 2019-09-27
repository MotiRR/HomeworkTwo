package ru.sber.edu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sber.edu.components.Component;
import ru.sber.edu.devices.Device;
import ru.sber.edu.devices.Status;

import java.util.TreeMap;

public class CheckingEvent {

    private static final Logger logger = LoggerFactory.getLogger(CheckingEvent.class);

    public void Event(int deviceId, int componentId, String event, TreeMap<Integer, Device> tm) {
        Device device = tm.get(deviceId);
        Component component = device.getComponents().get(componentId);
        boolean status = component.isStatus();
        if ("ErrorEvent".equalsIgnoreCase(event))
            component.setStatus(false);
        else if ("RestoreEvent".equalsIgnoreCase(event))
            component.setStatus(true);
        if (component.isStatus() != status)
            checked(device);
    }

    private int countBrokenComponent(Device device) {
        return (int) device.getComponents().values().stream()
                .filter(component -> !component.isStatus())
                .count();
    }

    private void checked(Device device) {
        int count = 0;
        int size = device.getComponents().size();
        count = countBrokenComponent(device);
        if (count == 0) {
            device.setStatus(Status.normal);
            logger.info("Устройство id = {}, name = {} изменило свое состояние на " +
                    "{}", device.getId(), device.getName(), Status.normal);
            return;
        }
        if (count == 1) {
            device.setStatus(Status.warning);
            logger.info("Устройство id = {}, name = {} изменило свое состояние на " +
                    "{}", device.getId(), device.getName(), Status.warning);
            return;
        }
        if (count >= size / 2) {
            device.setStatus(Status.error);
            logger.info("Устройство id = {}, name = {} изменило свое состояние на " +
                    "{}", device.getId(), device.getName(), Status.error);
        }
    }
}
