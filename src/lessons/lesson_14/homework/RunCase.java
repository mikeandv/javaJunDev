package lessons.lesson_14.homework;

import lessons.lesson_11.homework.task1.StInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunCase {
    private final String[] REG = {
            "\\s*([a-zA-Z]+)\\s*(\\=)\\s*((\\-?|\\+?)\\d+\\.\\d+|(\\-?|\\+?)\\d+)\\s*",
            "\\s*([a-zA-Z]+)\\s*(\\=)\\s*([a-zA-Z]+)\\s*",
            "\\s*([a-zA-Z]+|\\d+\\.\\d+|\\d+)\\s*(\\+)\\s*([a-zA-Z]+|\\d+\\.\\d+|\\d+)\\s*",
            "\\s*([a-zA-Z]+|\\d+\\.\\d+|\\d+)\\s*(\\-)\\s*([a-zA-Z]+|\\d+\\.\\d+|\\d+)\\s*",
            "\\s*([a-zA-Z]+|\\d+\\.\\d+|\\d+)\\s*(\\*)\\s*([a-zA-Z]+|\\d+\\.\\d+|\\d+)\\s*",
            "\\s*([a-zA-Z]+|\\d+\\.\\d+|\\d+)\\s*(\\/)\\s*([a-zA-Z]+|\\d+\\.\\d+|\\d+)\\s*",
            "(.+)(.+)"};

    public void start() {
        Calc cl = new Calc();

        while (true) {

            Double result = null;

            while (result == null) {

                try {
                    System.out.print("> ");
                    result = operation(StInput.read(), cl);

                } catch (Exception e) {
                    System.out.println("# " + e.getMessage());
                }
            }

            calcResult(result);
        }
    }


    private Double operation(String str, Calc cl) throws Exception {

        for (String s : regData()) {

            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(str);

            if (!matcher.matches())
                continue;

            switch (matcher.group(2)) {
                case "=":
                    cl.setValue(matcher.group(1),matcher.group(3));
                    return null;
                case "+":
                    return cl.addition(matcher.group(1), matcher.group(3));
                case "-":
                    return cl.substraction(matcher.group(1), matcher.group(3));
                case "*":
                    return cl.multiplic(matcher.group(1), matcher.group(3));
                case "/":
                    return cl.division(matcher.group(1), matcher.group(3));
                default:
                    throw new Exception("not a statement");
            }
        }
        return null;
    }


    private void calcResult(Double r) {
        System.out.println("# " + r);
    }

    public List<String> regData() {
        return new ArrayList<>(Arrays.asList(REG));

    }
}

