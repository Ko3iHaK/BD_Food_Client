import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class UsersDB extends DataBaseConnection {
    public UsersDB(String coUrl) {
        super(coUrl);
    }

    @Override
    public void insert() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter age: ");
            int age = scanner.nextInt();
            System.out.println("Enter is_male: ");
            boolean is_male = scanner.nextBoolean();
            System.out.println("Enter height: ");
            double height = scanner.nextDouble();
            System.out.println("Enter body_mass: ");
            double body_mass = scanner.nextDouble();
            String query = "INSERT INTO users (name, age, is_male, height, body_mass) " +
                    "VALUES ('" + name + "'," + age + "," + is_male + "," + height + "," + body_mass + ")";
            Statement statement = co.createStatement();
            statement.executeUpdate(query);
            System.out.println("Rows added");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void printTableToConsole(){
        try {
            String[] temp = coUrl.split(":");
            String[] temp2 = temp[temp.length - 1].split("\\.");
            String query = "SELECT * FROM " + temp2[0];
            Statement statement = co.createStatement();
            ResultSet res = statement.executeQuery(query);
            while(res.next()){
                int id = res.getInt("id");
                String name = res.getString("name");
                int age = res.getInt("age");
                boolean is_male = res.getBoolean("is_male");
                double height = res.getDouble("height");
                double body_mass = res.getDouble("body_mass");
                System.out.println(id+"\t| "+name+"\t| "+age+"\t| "+is_male+"\t| "+height+"\t| "+body_mass);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
