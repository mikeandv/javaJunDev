package lessons.lesson_2.homework;

public class Task6 {
    public static void main(String[] args) {

        int luckyTicketCNT = 0;

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10 ; j++){
                for (int f = 0; f < 10; f++){
                    for (int g = 0; g < 10; g++){
                        for (int h = 0; h < 10; h++){
                            for (int k = 0; k < 10; k++){
                                if ((i == 0) && (j == 0) && (f == 0) && (g == 0) && (h == 0) && (k == 0)) {
                                    k = 1;
                                }
                                if ((i + j + f) == (g + h + k)){
                                    luckyTicketCNT++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("В одном рулоне " + luckyTicketCNT + " счастливых билетов.");
    }
}
