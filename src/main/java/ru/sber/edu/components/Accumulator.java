package ru.sber.edu.components;

public class Accumulator extends Component {

    public Accumulator() {
    }

    public Accumulator(int id, String name, boolean status) {
        super(id, name, status);
    }

    @Override
    public String toString() {
        return "Accumulator{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", status=" + isStatus() +
                '}';
    }
}
