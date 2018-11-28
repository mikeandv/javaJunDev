package lessons.lesson_14;

public class ExceptionExmpl {

    public static void main(String[] args) {

        // Обработка исключений
        // try-catch

        Object data = "42";
        //Integer intData = (Integer) data; //может возникнуть исключение ClassCastException

        try {
            //Integer intData = (Integer) data;
            System.out.println("After exception");

        } catch (NullPointerException e) {

        } finally {
            //Обычно используется для освобождения ресурса открытого в блоке try (например кооннект к базе или открытие файла)
        }
        //Вариант 1
//        catch (ClassCastException e) { //Указанный клас исключений и все его наследники
//
//            System.out.println("Обработка исключения\n" +
//                    e.getMessage());
//        } catch (NullPointerException e) {
//
//        }
        //Варант 3
//        catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
//
//        }
        //Вариант 2
//        catch (RuntimeException e) {
//
//        }


        //checked exception - Необходимо обрабатывать в любомом случае
//        throw new Exception("checked exception");

        try {
            vidWithException();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void vidWithException() throws Exception {  //Выбрасываение исключения на уровень выше
        throw new Exception("checked exception");
    }
}
