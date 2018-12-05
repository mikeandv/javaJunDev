package lessons.patterns.builder;

public class SomeComputerBuilder extends ComputerBuilder {


    @Override
    public void buildDisplay() {
        computer.setDisplay("Some display");
    }

    @Override
    public void buildSystemBlock() {
        computer.setSystemBlock("Some system block");
    }

    @Override
    public void buildManipulators() {
        computer.setManipulators("Some manipulators");
    }
}
