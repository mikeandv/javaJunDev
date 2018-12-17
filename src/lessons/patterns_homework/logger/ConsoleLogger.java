package lessons.patterns_homework.logger;

public class ConsoleLogger implements ILogger {

    @Override
    public void write(Object o) {
        StringBuilder sb = new StringBuilder();
        sb.append(o);

        System.out.println(">> " + new String(sb));

    }
}
