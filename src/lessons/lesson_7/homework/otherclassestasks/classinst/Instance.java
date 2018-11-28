package lessons.lesson_7.homework.otherclassestasks.classinst;

public class Instance {
    private String str = "This is instance class";
    static private Instance  i = new Instance();

    private Instance() { }

    public static Instance getInstance() {
        return i;
    }
}
