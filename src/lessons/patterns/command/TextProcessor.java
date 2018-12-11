package lessons.patterns.command;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class TextProcessor {
    private CommandHistory history = new CommandHistory();
    private File fileOut = new File("files/command/outputdata.txt");
    private List<String> strList = new ArrayList<>();
    private List<String> strListTmp = new ArrayList<>();

    //сохранить все команды в качестве констант

    private final String EXIT = "/exit";
    private final String PROCESS = "/process";
    private final String CANCEL = "/cancel";
    private final String REPEAT = "/repeat";
    private final String UNSUPCOMMAND = "\\/.*";

    private void executeCommand(Command command) {
        if(command.execute()) {
            history.addCommand(command);
        }

    }

    public void start() {

        Scanner in = new Scanner(System.in);

        while (true) {
            String str = in.nextLine();



            switch (str) {
                case EXIT:
                    executeCommand(new ExitCommand(this));
                    break;
                case PROCESS:
                    executeCommand(new ProcessCommand(this));
                    break;
                case CANCEL:
                    executeCommand(new CancelCommand(this));
                    break;
                case REPEAT:
                    executeCommand(new RepeatCommand(this));
                    break;
                default:
                    if(str.matches(UNSUPCOMMAND)) {
                        System.out.println("Некоррекная команда");
                        break;
                    }
                    strList.add(str);
            }
        }
    }
    //Getters
    public File getFileOut() {
        return fileOut;
    }

    public List<String> getStrList() {
        return strList;
    }

    public List<String> getStrListTmp() {
        return strListTmp;
    }

    public CommandHistory getHistory() {
        return history;
    }
    //Additional methods
    public void addStrToTmp(String s) {
        this.strListTmp.add(s);
    }
    public void addStrToTmp(List<String> s) {
        for (String str: s) {
            this.strListTmp.add(str);
        }
    }

    public void removeAllFromStrList(List<String> ls) {
        this.strList.removeAll(ls);
    }
    public void removeAllTmp() {

        ListIterator<String> listIterator = this.strListTmp.listIterator();
        while(listIterator.hasNext()){
            listIterator.next();
            listIterator.remove();
        }
    }


}
