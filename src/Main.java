import DataBase.*;
import food_picking.*;
import Menu.MenuCommand;
import Menu.Menu;



/* Вариант 21. Разработайте объектно-ориентированную модель для конструктора расчётов рациона ( количества белков, жиров, углеводов ).
* Система должна быть расширяема по характеристикам человека, по режимам физической деятельности и ожидаемым результатам.
* Система должна поддерживать справочник продуктов растительного и животного происхождения.
* Также необходимо обеспечить возможность натройки комбинированных режимов питания с циклами различной длительности.
*/
public class Main {
    public static void main(String[] args) {
        try {
            UsersDB connection = new UsersDB("jdbc:sqlite:users.db");
            connection.printTableToConsole();


            Menu menu = Menu.getInstance();
            menu.addEntry(new MenuCommand("4)Print table") {
                @Override
                public void run() {
                    connection.printTableToConsole();
                }
            });
            menu.addEntry(new MenuCommand("3)Add User, Package, Eat") {
                @Override
                public void run() {
                    connection.InsertFromConsole();
                    connection.printTableToConsole();
                }
            });
            menu.addEntry(new MenuCommand("2)***") {
                @Override
                public void run() {
                    System.out.println("test2 run");
                }
            });
            menu.addEntry(new MenuCommand("1)Chose user") {
                @Override
                public void run() {
                    connection.selectUser("Gleb").printDataToConsole();
                }
            });
            menu.run();
        }
       catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
}