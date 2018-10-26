package lessons.lesson_4.lessonwork;

import java.lang.reflect.Array;
import java.util.Arrays;

//Класс хранилище
public class Storage {
    //Переменная для размера хранилища
    private int size = 3;
    //Создание массива с типом класса и заданного размера
    private  Good[] goods = new Good[size];

    //Метод для добавления товара в храшилище
    public void addGoods(Good good){
        for (int i = 0; i < goods.length; i++) {
            if (goods[i] == null) {
                goods[i] = good;
                return;
            }

        }
        System.out.println("Места нет");

    }

    public void showGoods () {
        System.out.println(Arrays.toString(goods));
    }

    public Good[] getGoods() {
        return goods;
    }
}
