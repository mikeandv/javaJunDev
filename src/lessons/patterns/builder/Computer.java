package lessons.patterns.builder;

//Конкретный продукт
//builder - абстрактный строитель
//конкретная реализация
//director - на основе реализации создает конкретный продукт


public class Computer {
    private String display = null;
    private String systemBlock = null;
    private String manipulators = null;

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setSystemBlock(String systemBlock) {
        this.systemBlock = systemBlock;
    }

    public void setManipulators(String manipulators) {
        this.manipulators = manipulators;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "display='" + display + '\'' +
                ", systemBlock='" + systemBlock + '\'' +
                ", manipulators='" + manipulators + '\'' +
                '}';
    }
}
