import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Menu{
    private  static Menu instance = null;
    private List<MenuCommand> entries  = new ArrayList<MenuCommand>();
    boolean isExit = false;
    void addEntry(MenuCommand titleName){
        entries.add(0, titleName);
    }
    private Menu(){
        entries.add(new MenuCommand("Exit"){
            @Override
            public void run(){
                isExit = true;
            }
        });
    }

    public static Menu getInstance() {
        if(instance == null){
            instance = new Menu();
        }
        return  instance;
    }

    public void printMenu(){
    for (MenuCommand it:
            entries) {
        System.out.println(it.getTitle());
    }

}
public void run(){
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (!isExit) {
        printMenu();
        try {
            String line = reader.readLine();
            int choice = Integer.parseInt(line);
            // Выбираем нажатый пункт меню и выполняем его код
            MenuCommand entry = entries.get(choice - 1);
            entry.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}