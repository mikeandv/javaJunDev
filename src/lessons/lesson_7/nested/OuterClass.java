package lessons.lesson_7.nested;

public class OuterClass {
    String value;
    static String statVal;

    public OuterClass(String value){
        this.value = value;
    }

    public InnerClass getInner(){
        return new InnerClass("Объект внутреннего класса");
    }

    static class InnerClass {
        String val;

        public InnerClass(String val) {
            this.val = val;
        }

        public void someMeth() {
            statVal += 1;
            System.out.println(statVal);
            //System.out.println(setValue); //Нельзя обратится к нестатическим метода/переменным внешнего класса
        }

    }
}
