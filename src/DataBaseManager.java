import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DataBaseManager {



    public void insetToDB(PreparedStatement pstmt, Scanner scan) {
        try{
            System.out.println("Enter User's Id");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter user's username");
            String username = scan.nextLine();
            System.out.println("Enter user's email");
            String email = scan.nextLine();
            System.out.println("Enter user's password");
            String password = scan.nextLine();

            pstmt.setInt(1, id);
            pstmt.setString(2, username);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            pstmt.executeUpdate();
            System.out.println("User added successfully!");

        } catch (SQLException e) {
            System.out.println("Something went wrong" + e);
            e.printStackTrace();
        }
    }
}
