package DataBase;

import java.sql.*;

public abstract class DataBaseConnection {
    Connect connect;
    Connection co;
    protected String coUrl;

    public DataBaseConnection(Connect connect) {
        this.connect = connect;
        co = connect.getCo();
    }
    public void test(){
        System.out.println("Connected");
    }
    public void insert(){}
    public void printTableToConsole(){}
    public void InsertFromConsole(){}
    public void close(){
        try {
            co.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int findIdFromName(String name) {
        return 0;
    }
}
