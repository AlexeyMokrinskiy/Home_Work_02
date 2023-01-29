import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

// 4) К калькулятору из предыдущего дз добавить логирование.

public class Task_04 {
private static String encoding = System.getProperty("console.encoding", "cp866");
public static  Scanner iScanner = new Scanner(System.in, encoding);
    public static void main(String[] args) throws IOException {
        
        Logger logger = Logger.getLogger(Task_04.class.getName());
        FileHandler fh = new FileHandler("log_04.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.setUseParentHandlers(false);

    int x = FirstValue();
    logger.info("Ведено первое число: " + x);

    int y = SecondValue();
    logger.info("Ведено первое число: " + y);

    String operation = Operation();

    float result = calculation(x, y, operation);
    System.out.println("Результат вычисления равен: " + result);
    logger.info("Результат вычисления равен: " + result);
    
    }
    public static int FirstValue() {
        Logger logger = Logger.getLogger(Task_04.class.getName());
        System.out.println("Введите первое число:");
        int a;
        if(iScanner.hasNextInt()) {
            a = iScanner.nextInt();
        } 
        else {
            String b = iScanner.next();
            logger.warning("Введен неверный символ " + b);
            System.out.println("Ошибка, введите цифры ");
            a = FirstValue(); 
        }
        return a;
    }
    public static int SecondValue() {
        Logger logger = Logger.getLogger(Task_04.class.getName());
        System.out.println("Введите второе число:");
        int a;
        if(iScanner.hasNextInt()) {
            a = iScanner.nextInt();
        } 
        else {
            String b = iScanner.next();
            logger.warning("Введен неверный символ " + b);
            System.out.println("Ошибка, введите цифры ");
            a = FirstValue(); 
        }
        return a;
    }
    public static String Operation() {
        System.out.println("Операцию, где:\n+ - сложение\n- - вычитание\n* - умножение\n/ - деление\nИли stop для выхода");
        String a = iScanner.nextLine();
        return a;
    }
    public static float calculation(int num1, int num2, String operation){
        Logger logger = Logger.getLogger(Task_04.class.getName());
        float result;
        switch (operation){
            case "+":
                result = num1 + num2;
                logger.info("Ведена операция: сложение");
                break;
            case "-":
                result = num1 - num2;
                logger.info("Ведена операция: вычитание");
                break;
            case "*":
                result = num1 * num2;
                logger.info("Ведена операция: умножение");
                break;
            case "/":
                result = num1 / num2;
                logger.info("Ведена операция: деление");
                break;
            case "stop":
                result = num1 / 0;
                System.out.println("До свидания!");
                logger.info("Программа остоновлена");
                break;
            default:
                System.out.println("Ошибка ввода. (+ - * /)");
                result = calculation(num1, num2, Operation()); //при неправильном вводе отправляем в рекурсию
        }
        return result; // делит криво (5 / 2 = 2.0) пробовал фдот и дабл
    }
}









