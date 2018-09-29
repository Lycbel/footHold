package DB;

import modules.HouseBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseDB extends BasicDB {

    public boolean uploadHouse(HouseBean hb){
        try {
            Connection conn = getConn();
            PreparedStatement pstmt = null;

            pstmt = hb.getPreParedStatement(pstmt,conn);
            pstmt.executeUpdate();

            conn.close();
           return  true;
        }catch (SQLException e){
            System.err.println(e.toString());
            return false;
        }
    }
}
