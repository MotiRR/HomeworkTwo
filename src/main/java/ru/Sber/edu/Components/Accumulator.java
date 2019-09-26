package ru.Sber.edu.Components;

public class Accumulator extends Component {

    public Accumulator(){}
    public Accumulator(int id, String name, boolean status) {
        super(id, name, status);
    }

    @Override
    public String toString() {
        return "Accumulator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
