package lessons.patterns.command;

import java.io.*;
import java.util.List;

public class CancelCommand extends Command{

    public CancelCommand(TextProcessor processor) {
        super(processor);
    }

    @Override
    String name() {
        return "CancelCommand";
    }

    @Override
    boolean execute() {
        System.out.println(name());

        if(this.processor.getHistory().isEmpty()) {
            return false; //ничего не делаем
        } else if(this.processor.getHistory().lastElem().name().equals("CancelCommand")) {
            return false; //ничего не делаем
        } else if(this.processor.getHistory().lastElem().name().equals("ProcessCommand")
                && !this.processor.getStrListTmp().isEmpty()) {
            lineRemover(this.processor.getFileOut(), this.processor.getStrListTmp());
            this.processor.removeAllTmp();
        } else if(this.processor.getHistory().lastElem().name().equals("RepeatCommand")
                && !this.processor.getStrListTmp().isEmpty()) {
            lineRemover(this.processor.getFileOut(), this.processor.getStrListTmp());
            this.processor.removeAllTmp();
        }
        return false;
    }

    private void lineRemover(File f, List<String> l) {
        try(
                InputStreamReader in = new InputStreamReader(new FileInputStream(f));
                BufferedReader buff = new BufferedReader(in)
        ) {

            StringBuilder sb = new StringBuilder();

            int lines = 0;
            String str;

        while((str = buff.readLine()) != null) {
            ++lines;
            if(lines > (lineCount(f) - l.size()))
                continue;

            sb.append(str).append("\n");
            }

            try(OutputStream out = new FileOutputStream(f)) {
                out.write(sb.toString().getBytes());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private int lineCount(File f) {
        int lines = 0;
        try(
                InputStreamReader in = new InputStreamReader(new FileInputStream(f));
                BufferedReader buff = new BufferedReader(in);
        ) {

            while((buff.readLine()) != null) {
                lines++;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }
}
