import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "AM@123aniket";

    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("Class not found error");
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            DataBaseManager DBMS = new DataBaseManager();

            while (true){
                System.out.println("----- Choose one -----");
                System.out.println("1. Add user");
                System.out.println("2. Read users");
                System.out.println("3. Update users");
                System.out.println("4. Exit");

                int option = scan.nextInt();

                if(option == 1){
                    PreparedStatement pstmt = connection.prepareStatement("insert into users(Id, username, email, password) values(?, ?, ?, ?)");
                    DBMS.insetToDB(pstmt, scan);
                } else if (option == 2) {
                    PreparedStatement pstmt = connection.prepareStatement("select * from users") ;
                    DBMS.readDB(pstmt);
                } else if (option == 3) {
                    System.out.println("not created yet");
                } else if (option == 4) {
                    System.out.println("Bye!");
                    break;
                } else {
                    System.out.println("This is not the valid option");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}