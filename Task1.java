// Задача 1:
// Напишите программу, которая запрашивает у пользователя число и проверяет, 
// является ли оно положительным. Если число отрицательное или равно нулю, 
// программа должна выбрасывать исключение InvalidNumberException с сообщением "Некорректное число". 
// В противном случае, программа должна выводить сообщение "Число корректно".

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try {
            int number = getNumber();
            checkNumber(number);
            System.out.println("Число корректно");
        } catch (InvalidNumberException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void checkNumber(int num) throws InvalidNumberException {
        if (num <= 0) {
            throw new InvalidNumberException("Некорректное число");
        }
    }

    public static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            try {
                System.out.println("Введите число: ");
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Некорректный ввод");
                scanner.nextLine();
            }
        }
        scanner.close();
        return number;
    }
}

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}
