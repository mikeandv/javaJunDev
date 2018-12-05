package lessons.patterns.decorator;

public class RepairDecorator extends ServiceDecorator{
    public RepairDecorator(IService service) {
        super(service);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 500;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Repair";
    }
}
