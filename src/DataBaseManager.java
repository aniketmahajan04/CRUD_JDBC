import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseManager {
//    private static final String url = "jdbc:mysql://localhost:3306/mydb";
//    private static final String user = "root";
//    private static final String password = "AM@123aniket";


    public void insetToDB(PreparedStatement pstmt, int id, String username, String email, String password) throws SQLException {
        try{
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
