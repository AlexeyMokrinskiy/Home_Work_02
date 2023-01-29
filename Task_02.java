import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

// 2) Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.

public class Task_02 {
private static String encoding = System.getProperty("console.encoding", "cp866");
public static  Scanner iScanner = new Scanner(System.in, encoding);
    public static void main(String[] args) throws IOException {
        
        Logger logger = Logger.getLogger(Task_02.class.getName());
        FileHandler fh = new FileHandler("log_02.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.setUseParentHandlers(false);

    System.out.println("Введите размер массива:");
    int a = iScanner.nextInt();
    int[] RandArray;
    RandArray = new int[a];
        for (int i = 0; i < RandArray.length; i++) {
        RandArray[i] = ((int)(Math.random() * (a - 100) + 100));
        System.out.print(RandArray[i] + " ");
        }
    System.out.println();

    bubbleSort(RandArray);
    for(int i = 0; i < RandArray.length; i++){
        System.out.print(RandArray[i] + " ");
        }
    }
    public static void bubbleSort(int[] sortArr){
        Logger logger = Logger.getLogger(Task_02.class.getName());
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int temp = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = temp;
                    logger.log(Level.INFO, "Перемещение в конец массива числа: {0}", temp);
                }
            }
        }
    }
}
