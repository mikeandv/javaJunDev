package lessons.patterns.command;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ProcessCommand extends Command {

    public ProcessCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "ProcessCommand";
    }

    @Override
    boolean execute() {
        System.out.println(name());

        if(this.processor.getStrList().isEmpty())
            return false;
        if(!this.processor.getHistory().isEmpty()
                && this.processor.getHistory().lastElem().name().equals("ProcessCommand"))
        {
            this.processor.removeAllTmp();
            return false;
        }

        StringBuilder sb = new StringBuilder();

        try(
                OutputStream out = new FileOutputStream(this.processor.getFileOut(), true)
                )
        {
            for(String s : this.processor.getStrList()){
                sb.append(s).append("\n");
                this.processor.addStrToTmp(s);
            }
            out.write(sb.toString().getBytes());
            out.flush();

            this.processor.removeAllFromStrList(this.processor.getStrListTmp());

        } catch (IOException e) {
            e.getMessage();
        }
        return true;
    }

}
