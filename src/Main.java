import DataBase.*;
import food_picking.*;
import Menu.MenuCommand;
import Menu.Menu;
import Menu.InputMenu;
import food_picking.Package;

import java.util.Scanner;


/* Вариант 21. Разработайте объектно-ориентированную модель для конструктора расчётов рациона ( количества белков, жиров, углеводов ).
* Система должна быть расширяема по характеристикам человека, по режимам физической деятельности и ожидаемым результатам.
* Система должна поддерживать справочник продуктов растительного и животного происхождения.
* Также необходимо обеспечить возможность натройки комбинированных режимов питания с циклами различной длительности.
*/
public class Main {
    public static void main(String[] args) {
        try {
            Connect connect = Connect.getInstance("jdbc:sqlite:users.db");
            UsersDB connection = new UsersDB(connect);
            //connection.printTableToConsole();
            EatBD connection2 = new EatBD(connect);
            //connection2.printTableToConsole();
            PackageDB connection3 = new PackageDB(connect);
            //connection3.printTableToConsole();
            final Human[] user0 = {new Human()};
            System.out.println("||---------------------------------------------------------||");
            System.out.println(connection2.findIdFromName("Гренки белые жареные"));
            //-------------------------------------------------------------------------------//
            Menu menu = Menu.getInstance();
            menu.addEntry(new MenuCommand("5)Work with Packages") {
                @Override
                public void run() {
                    InputMenu menu_5_1 = new InputMenu();
                    menu_5_1.addEntry(new MenuCommand("3)Delete a connections") {
                        @Override
                        public void run() {
                            connection3.deleteReletion();
                        }
                    });
                    menu_5_1.addEntry(new MenuCommand("2)Create a connection between the package and the food") {
                        @Override
                        public void run() {
                            Scanner in = new Scanner(System.in);
                            System.out.print("Input package name: ");
                            String pack = in.nextLine();
                            System.out.print("Input eat name: ");
                            String eat = in.nextLine();
                            System.out.println(pack+"\t|"+eat);
                            connection3.addEatToPackage(pack, eat, connection2);
                        }
                    });
                    menu_5_1.addEntry(new MenuCommand("1)Output the relation table") {
                        @Override
                        public void run() {
                            connection3.printRelation();
                        }
                    });
                    menu_5_1.run();
                }
            });
            menu.addEntry(new MenuCommand("4)Print table") {
                @Override
                public void run() {
                    InputMenu menu_4_1 = new InputMenu();
                    menu_4_1.addEntry(new MenuCommand("3)Print Eat Table") {
                        @Override
                        public void run() {
                            connection2.printTableToConsole();
                        }
                    });
                    menu_4_1.addEntry(new MenuCommand("2)Print Package Table") {
                        @Override
                        public void run() {
                            connection3.printTableToConsole();
                        }
                    });
                    menu_4_1.addEntry(new MenuCommand("1)Print User Table") {
                        @Override
                        public void run() {
                            connection.printTableToConsole();
                        }
                    });
                    menu_4_1.run();
                }
            });
            menu.addEntry(new MenuCommand("3)Add User, Package, Eat") {
                @Override
                public void run() {
                    InputMenu menu_3_1 = new InputMenu();
                    menu_3_1.addEntry(new MenuCommand("3)Eat DB") {
                        @Override
                        public void run() {
                            connection2.InsertFromConsole();
                            connection2.printTableToConsole();
                        }
                    });
                    menu_3_1.addEntry(new MenuCommand("2)Package DB") {
                        @Override
                        public void run() {
                            connection3.InsertFromConsole();
                            connection3.printTableToConsole();
                        }
                    });
                    menu_3_1.addEntry(new MenuCommand("1)Users DB") {
                        @Override
                        public void run() {
                            connection.InsertFromConsole();
                            connection.printTableToConsole();
                        }
                    });
                    menu_3_1.run();
                }
            });
            menu.addEntry(new MenuCommand("2)Packages control") {
                @Override
                public void run() {
                    InputMenu menu_2_1 = new InputMenu();
                    menu_2_1.addEntry(new MenuCommand("2)") {
                        @Override
                        public void run() {

                        }
                    });
                    menu_2_1.addEntry(new MenuCommand("1)Add Package") {
                        @Override
                        public void run() {
                            System.out.println("Enter Package ID: ");
                            Scanner scanner = new Scanner(System.in);
                            int ID = scanner.nextInt();
                            Package pac = new Package();
                            connection3.getEatListFromPackage(ID, pac);
                            user0[0].setUser_package(pac);
                        }
                    });
                }
            });
            menu.addEntry(new MenuCommand("1)Chose user") {
                @Override
                public void run() {
                    System.out.println("Enter UserName: ");
                    Scanner scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    user0[0] = connection.selectUser(name);
                    user0[0].printDataToConsole();
                }
            });
            menu.run();
        }
       catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
}