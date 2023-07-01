// Задача 2:
// Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление. 
// Если второе число равно нулю, программа должна выбрасывать исключение DivisionByZeroException 
// с сообщением "Деление на ноль недопустимо". 
// В противном случае, программа должна выводить результат деления.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        try {
        int a = getNumber();
        int b = getNumber();
        checkNumber(b);
        System.out.println(a + " / " + b + " = " + a/b);
        } catch (DivisionByZeroException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        

    }

    public static void checkNumber(int num) throws DivisionByZeroException{
        if (num == 0) {
            throw new DivisionByZeroException("Деление на ноль недопустимо.");
        }
    }

    public static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            try {
                System.out.println("Введите число: ");
                num = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод.");
                scanner.nextLine();
            }            
        }
        return num;
    }
}

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}
