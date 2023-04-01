import java.util.Scanner;
public class CaseMenu implements Menu {
    private final Scanner scanner;

    public CaseMenu(Scanner scanner) {
        this.scanner = scanner;
    }
    @Override
    public void printMenu() {
        System.out.println("Конструктор расчёта рациона");
        System.out.println("    1. Добавить ограничение по каллориям в рационе;");
        System.out.println("    2. Добвить пользователя;");
        System.out.println("    3. Создания двумерного массива;");
        System.out.println("    4. Выход из приложения;");
    }
    @Override
    public void start() {
        if (this.scanner != null) {
            int key;
            do {
                printMenu();
                System.out.print("Введите номер меню: ");
                key = this.scanner.nextInt();
                switch (key) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("Завершение программы...");
                        break;
                    default:
                        System.out.println("Вы ввели неверное значение меню...\n");
                }
            } while (key != 4);
        }
    }
}