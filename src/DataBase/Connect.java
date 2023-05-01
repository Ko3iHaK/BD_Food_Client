package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect{
    private Connection co;
    private String coUrl;
    private static Connect instance;

    public Connection getCo() {
        return co;
    }

    private Connect(String coUrl) {
        try{
            Class.forName("org.sqlite.JDBC");
            this.coUrl = coUrl;
            this.co = DriverManager.getConnection(coUrl);
            System.out.println("Connected");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static Connect getInstance(String coUrl){
        if(instance == null){
            instance = new Connect(coUrl);
        }
        return instance;
    }
    public void close(){
        try {
            co.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
