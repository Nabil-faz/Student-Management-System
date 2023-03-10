import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**This class was built to test the database system's connectivity.**/

public class DbCon {

    public static void main(String [] args){


        String url = "jdbc:mysql://localhost:0000/student_manager";
        String username = "";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username,password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from user");

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));

            }
            connection.close();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Something went wrong");
        }



    }
}
