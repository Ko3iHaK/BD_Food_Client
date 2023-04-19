package DataBase;


import food_picking.Eat;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EatBD extends DataBaseConnection {
    public EatBD(String coUrl) {
        super(coUrl);
    }

    @Override
    public void printTableToConsole() {
        try {
            String[] temp = coUrl.split(":");
            String[] temp2 = temp[temp.length - 1].split("\\.");
            String query = "SELECT * FROM eat";
            Statement statement = co.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                int id = res.getInt("eat_id");
                String name = res.getString("eat_name");
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
            System.out.println("Enter foodName: ");
            String name = scanner.nextLine();
            System.out.println("Enter food's calories: ");
            int cal = scanner.nextInt();
            System.out.println("Enter food's proteins: ");
            int proteins = scanner.nextInt();
            System.out.println("Enter food's fats: ");
            int fats = scanner.nextInt();
            System.out.println("Enter food's carbohydrates: ");
            int carbohydrates = scanner.nextInt();
            String query = "INSERT INTO eat (eat_name, cal, proteins, fats, carbohydrates) " +
                    "VALUES ('" + name + "'," + cal + "," + proteins + "," + fats + "," + carbohydrates + ")";
            Statement statement = co.createStatement();
            statement.executeUpdate(query);
            System.out.println("Rows added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Eat selectEat(String EatName){
        try {
            String[] temp = coUrl.split(":");
            String[] temp2 = temp[temp.length - 1].split("\\.");
            String query = "SELECT * FROM eat WHERE name = '" + EatName + "' LIMIT 1";;
            Statement statement = co.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                int cal = res.getInt("cal");
                int proteins = res.getInt("proteins");
                int fats = res.getInt("fats");
                int carbohydrates = res.getInt("carbohydrates");
                boolean veganFood = false;
                Eat tempEat = new Eat(name, cal, proteins, fats, carbohydrates, veganFood);
                System.out.println(id + "\t| " + name + "\t| " + cal + "\t| " + proteins + "\t| " + fats + "\t| " + carbohydrates + "\t| ");
                return tempEat;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }
    @Override
    public int findIdFromName(String name){
        try {
            String query = "SELECT eat_id FROM eat WHERE eat_name = '"+name+"'";
            Statement statement = co.createStatement();
            ResultSet res = statement.executeQuery(query);
            int id = res.getInt("eat_id");
            return id;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
