package ru.Sber.edu.Components;

public class Camera extends Component {

    public Camera() {
    }

    public Camera(int id, String name, boolean status) {
        super(id, name, status);
    }

    @Override
    public String toString() {
        return "Camera{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", status=" + super.isStatus() +
                '}';
    }
}
