/* Вариант 21. Разработайте объектно-ориентированную модель для конструктора расчётов рациона ( количества белков, жиров, углеводов ).
* Система должна быть расширяема по характеристикам человека, по режимам физической деятельности и ожидаемым результатам.
* Система должна поддерживать справочник продуктов растительного и животного происхождения.
* Также необходимо обеспечить возможность натройки комбинированных режимов питания с циклами различной длительности.
*/
public class Main {
    public static void main(String[] args) {
        Menu menu = Menu.getInstance();
        menu.addEntry(new MenuCommand("3)Add User") {
            @Override
            public void run() {
                System.out.println("test1 run");
            }
        });
        menu.addEntry(new MenuCommand("2)Enter maximal body mass") {
            @Override
            public void run() {
                System.out.println("test2 run");
            }
        });
        menu.addEntry(new MenuCommand("1)Chose user") {
            @Override
            public void run() {
                System.out.println("test3 run");
            }
        });
        menu.run();
    }
}