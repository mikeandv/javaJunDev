package lessons.patterns.command;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class RepeatCommand extends Command {

    public RepeatCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "RepeatCommand";
    }

    @Override
    boolean execute() {
        System.out.println(name());

        if(this.processor.getHistory().isEmpty()) {
            return false; //ничего не делаем
        } else if(!this.processor.getStrList().isEmpty()) {
            write(this.processor.getFileOut(), this.processor.getStrList());
            write(this.processor.getFileOut(), this.processor.getStrList());

            this.processor.addStrToTmp(this.processor.getStrList()); //перенос записей в темп
            this.processor.addStrToTmp(this.processor.getStrList()); //перенос записей в темп

            this.processor.removeAllFromStrList(this.processor.getStrListTmp()); // удаление записей ил листа

        } else if(this.processor.getHistory().lastElem().name().equals("ProcessCommand")
                && !this.processor.getStrListTmp().isEmpty()) {
            write(this.processor.getFileOut(), this.processor.getStrListTmp());
        }
        return true;
    }

    private void write(File file, List<String> list) {

        StringBuilder sb = new StringBuilder();

        try(
                OutputStream out = new FileOutputStream(file, true)
        )
        {
            for(String s : list){
                sb.append(s).append("\n");

            }
            out.write(sb.toString().getBytes());
            out.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
