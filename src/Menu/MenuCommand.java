package Menu;

public abstract class MenuCommand {
    private String title;
    public MenuCommand(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public abstract void run();
}
