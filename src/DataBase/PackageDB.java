package DataBase;

import food_picking.Eat;
import food_picking.Package;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class PackageDB extends DataBaseConnection{

    public PackageDB(Connect connect) {
        super(connect);
    }

    @Override
    public void printTableToConsole() {
        try {
            String query = "SELECT * FROM package";
            Statement statement = co.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                int id = res.getInt("package_id");
                String name = res.getString("package_name");
                int cal = res.getInt("cal");
                int proteins = res.getInt("proteins");
                int fats = res.getInt("fats");
                int carbohydrates = res.getInt("carbohydrates");
                System.out.println(id + "\t| " + name + "\t| " + cal + "\t| " + proteins + "\t| " + fats + "\t| " + carbohydrates + "\t| ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void InsertFromConsole() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter packageName: ");
            String name = scanner.nextLine();
            System.out.println("Enter package's calories: ");
            int cal = scanner.nextInt();
            System.out.println("Enter package's proteins: ");
            int proteins = scanner.nextInt();
            System.out.println("Enter package's fats: ");
            int fats = scanner.nextInt();
            System.out.println("Enter package's carbohydrates: ");
            int carbohydrates = scanner.nextInt();
            String query = "INSERT INTO package (package_name, cal, proteins, fats, carbohydrates) " +
                    "VALUES ('" + name + "'," + cal + "," + proteins + "," + fats + "," + carbohydrates + ")";
            Statement statement = co.createStatement();
            statement.executeUpdate(query);
            System.out.println("Rows added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public int findIdFromName(String name){
        try {
            String query = "SELECT package_id FROM package WHERE package_name = '"+name+"'";
            Statement statement = co.createStatement();
            ResultSet res = statement.executeQuery(query);
            int id = res.getInt("package_id");
            return id;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }
    public void addEatToPackage(String PackageName, String EatName, EatBD EatBDconnection){
        try {
            int eat = EatBDconnection.findIdFromName(EatName);
            int pac = findIdFromName(PackageName);
            System.out.println(pac+"|\t "+eat);
            String query = "INSERT INTO package_eat (packageId, eatId) VALUES ("+pac+", "+eat+")";
            Statement statement = co.createStatement();
            statement.executeUpdate(query);
            System.out.println("Rows added");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void getEatListFromPackage(int PackageID, Package inPac){
        try {
            ArrayList<Eat> foodList = new ArrayList<>();
            String query = "SELECT * FROM  package_eat LEFT JOIN eat \n" +
                    "    ON eatId = eat_id\n" +
                    "    WHERE package_eat.packageId = "+PackageID+";";
            Statement statement = co.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                int tempInt = res.getInt("id");
                tempInt = res.getInt("packageId");
                tempInt = res.getInt("eatId");
                tempInt = res.getInt("eat_id");
                String name = res.getString("eat_name");
                int cal = res.getInt("cal");
                int proteins = res.getInt("proteins");
                int fats = res.getInt("fats");
                int carbohydrates = res.getInt("carbohydrates");
                inPac.addFood(new Eat(name, cal,proteins, fats, carbohydrates, false));
                System.out.println(tempInt + "\t| " + name + "\t| " + cal + "\t| " + proteins + "\t| " + fats + "\t| " + carbohydrates + "\t| ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getEatListFromPackage(int PackageID){
        try {
            String query = "SELECT * FROM  package_eat LEFT JOIN eat \n" +
                    "    ON eatId = eat_id\n" +
                    "    WHERE package_eat.packageId = "+PackageID+";";
            Statement statement = co.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                int tempInt = res.getInt("id");
                tempInt = res.getInt("packageId");
                tempInt = res.getInt("eatId");
                tempInt = res.getInt("eat_id");
                String name = res.getString("eat_name");
                int cal = res.getInt("cal");
                int proteins = res.getInt("proteins");
                int fats = res.getInt("fats");
                int carbohydrates = res.getInt("carbohydrates");
                System.out.println(tempInt + "\t| " + name + "\t| " + cal + "\t| " + proteins + "\t| " + fats + "\t| " + carbohydrates + "\t| ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void printRelation(){
        try {
            String query = "SELECT * FROM package_eat";
            Statement statement = co.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                int id1 = res.getInt("packageId");
                int id2 = res.getInt("eatId");
                System.out.println(id1 + "\t| " + id2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteReletion(){
        try {
            String query = "DELETE FROM package_eat";
            Statement statement = co.createStatement();
            statement.executeUpdate(query);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
