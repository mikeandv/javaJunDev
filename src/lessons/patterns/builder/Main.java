package lessons.patterns.builder;

public class Main {
    public static void main(String[] args) {

        Director director = new Director();
        ComputerBuilder computerBuilder = new SomeComputerBuilder();

        director.setComputerBuilder(computerBuilder);
        director.constructComputer();

        Computer computer = director.getComputer();
        System.out.println(computer);
    }
}
