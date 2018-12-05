package lessons.patterns.decorator;

public class Main {
    public static void main(String[] args) {

        IService iService = new RepairDecorator(new WashDecorator(new TO()));
        System.out.println(iService.getPrice());
        System.out.println(iService.getDescription());

        IService iService1 = new WashDecorator(new TO());
        System.out.println(iService1.getPrice());
        System.out.println(iService1.getDescription());
    }
}
