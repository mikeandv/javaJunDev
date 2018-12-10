package lessons.lesson_19.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)
            throws NoSuchFieldException,
            IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException {
        //каждый загруженный клас имеет соответствующи java.lang.Class объект,
        // который дает доступ к структуре класса


        //у каждого типа есть вой литерал
        System.out.println(String.class);
        System.out.println(int.class);

        Child child = new Child("str", 2);
//        Child child = new Child();
        //строковый литерал объекта
        System.out.println(child.getClass());
        //строковы   литерал класса наследника

        Class cls;
        cls = child.getClass();
        System.out.println("child name " + cls.getName());

        cls = cls.getSuperclass();
        System.out.println("child extends " + cls.getName());

        //доступ к структуре класса

        //класс объекта
        Class<Child> childClass = Child.class;

        //доступ к полям
        Field[] fields = childClass.getFields();
        System.out.println(Arrays.toString(fields));

        //доступ к declared полям
        Field[] declaredFields = childClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        //доступ к методам
        Method[] methods = childClass.getMethods();
        System.out.println(Arrays.toString(methods));

        //доступ к методам которые объявлены только в классе (declared)
        Method[] declaredMethods = childClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        //достук к констуркторам

        Constructor<?>[] declaredConst = childClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConst));

        //доступ к конкретному полю?, методам и конструкторам
        Field field = childClass.getDeclaredField("name");

        //получить доступ к полю
        field.setAccessible(true);
        field.set(child, "Fenix");
        System.out.println(field.get(child));

        //получить доступ к методу
        Method method = childClass.getDeclaredMethod("getInfo");
        method.setAccessible(true);
        String data = (String) method.invoke(child);
        System.out.println(data);


        //Получить доступ к конструктору
        Constructor<Child> childConstructor = childClass.getDeclaredConstructor(String.class, int.class);
        //создание объекта
        Child child1 = childConstructor.newInstance("CHILD 1", 3);
        System.out.println(child1);

        boolean isFinal = Modifier.isFinal(field.getModifiers());
        boolean isPrivate = Modifier.isPrivate(field.getModifiers());

        Class<?>[] interfaces = childClass.getInterfaces();







    }
}
