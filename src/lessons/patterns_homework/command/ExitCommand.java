package lessons.patterns_homework.command;

public class ExitCommand extends Command {
    public ExitCommand(TextProcessor processor) {
        super(processor);
    }
    @Override
    String name() {
        return "ExitCommand";
    }

    @Override
    boolean execute() {
        System.out.println("реализация ExitCommand");
        System.exit(0);
        return true;
    }
}
