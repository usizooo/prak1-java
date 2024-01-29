package org.example; //Объявление пакета

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
//Импорт пакетов

public class Main { //Объявление класса
    public static void main(String[] args) { //Метод main
        Scanner s = new Scanner(System.in); //Инициализация Scanner

        try { //Блок try
            int numberOfStudents = getNumberOfStudents(s); //Получение количества студентов

            //Инициализирует объект FileWriter для записи данных в файл "students.txt"
            try (FileWriter fileWriter = new FileWriter("students.txt")) {
                for (int i = 0; i < numberOfStudents; i++) { //Цикл для ввода данных о студентах
                    String studentName = getStudentName(s);
                    int studentAge = getStudentAge(s);
                    double studentAverageGrade = getStudentAverageGrade(s);
                    //Получение имени, возраста и оценки студента

                    writeStudentDataToFile(fileWriter, studentName, studentAge, studentAverageGrade);
                    //Запись данных о студенте в файл
                }

                System.out.println("Данные студентов были записаны в файл <students.txt>");
                //Вывод сообщения об успешной записи данных в файл

            } catch (IOException e) { //Обработка исключения при записи в файл
                System.out.println("Произошла ошибка при записи данных в файл.");
                System.out.println("<<************************>>");
            }

        } finally { //Завершение программы и закрытие Scanner
            s.close();
        }
    }

    //Метод получения количества студентов
    private static int getNumberOfStudents(Scanner s) {
        System.out.println("Введите количество студентов: ");
        return s.nextInt();
    }

    //Метод получения имени студента
    private static String getStudentName(Scanner s) {
        System.out.print("Введите имя студента: ");
        s.nextLine(); // Очистим буфер после считывания числа
        return s.nextLine();
    }

    //Метод получения возраста студента
    private static int getStudentAge(Scanner s) {
        System.out.print("Введите возраст студента: ");
        return s.nextInt();
    }

    //Метод получения средней оценки студента
    private static double getStudentAverageGrade(Scanner s) {
        System.out.print("Введите среднюю оценку студента: ");
        return s.nextDouble();
    }

    //Метод записи данных о студенте в файл
    private static void writeStudentDataToFile(FileWriter fileWriter, String studentName,
                                               int studentAge, double studentAverageGrade) throws IOException {
        fileWriter.write("Имя: " + studentName + "\n" + "Возраст: " + studentAge + "\n" +
                "Средний балл: " + studentAverageGrade + "\n" +
                "********************" + "\n");
    }
}