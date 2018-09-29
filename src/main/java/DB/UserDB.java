package DB;
import modules.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB extends BasicDB {

    public boolean creatUser(User u){
        return false;
    }

    public User getUser(long userID){
        return null;
    }
    public User getUser(String email){
        try {
            Connection conn = getConn();
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement("select userID, firstName, lastName, email, address from users where email = ?");
            pstmt.setString(1, email);
            ResultSet rs =  pstmt.executeQuery();


            if(rs.next()){
              User us = new User(rs.getLong("userID"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("email"),rs.getString("address"));
                conn.close();
                return us;
            }
            conn.close();
            return null;
        }catch (SQLException e){
            System.err.println(e.toString());
           return  null;
        }

    }
    public boolean updateUser(User u){
        return false;
    }
    public UserHistory getUserHistory(User u){
        return null;
    }
}
