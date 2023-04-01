import java.util.Scanner;

public class UsersMenu implements Menu {
    private final Scanner scanner;

    public UsersMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void printMenu() {
        System.out.println("Введите имя пользователя");

    }

    @Override
    public void start(Human[] list) {
        if (this.scanner != null) {
            String username;
            printMenu();
            while (true){
                System.out.print("Введите номер меню: ");
                username = this.scanner.nextLine();
                for (int i = 0; i < list.length(); i++) {
                    if (list[i].name == username) break;
                }

                }
            }
        }
    }
}
