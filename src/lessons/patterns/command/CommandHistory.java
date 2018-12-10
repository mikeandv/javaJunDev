package lessons.patterns.command;

import java.util.Stack;

public class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void addCommand(Command command) {
        history.push(command);
    }

    public Command remove(){
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public Command lastElem() {
        return history.lastElement();
    }


}
