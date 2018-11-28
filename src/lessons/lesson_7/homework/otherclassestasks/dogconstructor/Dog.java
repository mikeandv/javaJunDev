package lessons.lesson_7.homework.otherclassestasks.dogconstructor;

public class Dog {
    private String name = "puppy dog";
    private int age = 2;
    private double weight = 4;
    private String color = "Brown";
    private String homeAddress = "missing";
    private static int count = 0;

    public Dog(String name) {
        this.setName(name);
        count++;
    }

    public Dog (String name, int age, int weight) {
        this.setName(name);
        this.setAge(age);
        this.setWeight(weight);
        count++;
    }

    public Dog (String name, int age) {
        this.setName(name);
        this.setAge(age);
        this.setWeight(3);
        count++;
    }

    public Dog (double weight, String color) {
        this.setWeight(weight);
        this.setColor(color);
        this.setName("");
        this.setAge(0);
        this.setHomeAddress("");
        count++;
    }
    public Dog (double weight, String color, String homeAddress){
        this.setWeight(weight);
        this.setColor(color);
        this.setHomeAddress(homeAddress);
        this.setName("");
        this.setAge(0);
        count++;
    }

    public void setName(String name) {

        if (name == ""){
            return;
        }
        this.name = name;
    }

    public void setAge(int age) {

        if (age <= 0){
            return;
        }
        this.age = age;
    }

    public void setWeight(double weight) {
        if (weight <= 0){
            return;
        }
        this.weight = weight;
    }

    public void setColor(String color) {

        if(color == "") {
            return;
        }
        this.color = color;
    }

    public void setHomeAddress(String homeAddress) {

        if(homeAddress == "") {
            return;
        }
        this.homeAddress = homeAddress;
    }

    public static int getDogCNT() {
        return count;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                '}';
    }
}
