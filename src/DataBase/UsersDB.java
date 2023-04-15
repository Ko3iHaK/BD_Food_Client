package DataBase;

import DataBase.DataBaseConnection;
import food_picking.Human;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class UsersDB extends DataBaseConnection {
    public UsersDB(String coUrl) {
        super(coUrl);
    }

    @Override
    public void InsertFromConsole() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter result you want, 1 for more mass, -1 for less mass, 0 for nothing: ");
            int res = scanner.nextInt();
            System.out.println("Is you active(true/false): ");
            boolean isActive = scanner.nextBoolean();
            System.out.println("You are man?(true/false): ");
            boolean isMale = scanner.nextBoolean();
            System.out.println("Enter height: ");
            double height = scanner.nextDouble();
            System.out.println("Enter body_mass: ");
            double body_mass = scanner.nextDouble();
            String query = "INSERT INTO users (name, res, isActive, isMale, height, body_mass) " +
                    "VALUES ('" + name + "'," + res + "," + isActive + "," + isMale + "," + height + "," + body_mass + ")";
            Statement statement = co.createStatement();
            statement.executeUpdate(query);
            System.out.println("Rows added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printTableToConsole() {
        try {
            String[] temp = coUrl.split(":");
            String[] temp2 = temp[temp.length - 1].split("\\.");
            String query = "SELECT * FROM " + temp2[0];
            Statement statement = co.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                int result = res.getInt("res");
                boolean isActive = res.getBoolean("isActive");
                boolean is_male = res.getBoolean("isMale");
                double height = res.getDouble("height");
                double body_mass = res.getDouble("body_mass");
                System.out.println(id + "\t| " + name + "\t| " + result + "\t| " + isActive + "\t| " + is_male + "\t| " + height + "\t| " + body_mass);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Human selectUser(String UserName) {
        try {
            String[] temp = coUrl.split(":");
            String[] temp2 = temp[temp.length - 1].split("\\.");
            String query = "SELECT * FROM " + temp2[0] + " WHERE name = '" + UserName + "' LIMIT 1";
            Statement statement = co.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                int result = res.getInt("res");
                boolean isActive = res.getBoolean("isActive");
                boolean is_male = res.getBoolean("isMale");
                double height = res.getDouble("height");
                double body_mass = res.getDouble("body_mass");
                Human tempUser = new Human(name, result, isActive, is_male, height, body_mass);
                System.out.println(id + "\t| " + name + "\t| " + result + "\t| " + isActive + "\t| " + is_male + "\t| " + height + "\t| " + body_mass);
                return tempUser;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }
}
