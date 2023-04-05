import java.sql.*;

public abstract class DataBaseConnection {
    protected Connection co;
    protected String coUrl;

    public DataBaseConnection(String coUrl) {
        try{
            Class.forName("org.sqlite.JDBC");
            this.coUrl = coUrl;
            this.co = DriverManager.getConnection(coUrl);
            test();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void test(){
        System.out.println("Connected");
    }
    public void insert(){}
    public void printTableToConsole(){}
    public void consoleInsertFromConsole(){}
    public void close(){
        try {
            co.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
