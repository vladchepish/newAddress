package tests;

import objects.Group;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDbConnection {

    @Test
    public void testConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://31.31.196.140:3306/u0541324_addressbook?" +
                    "user=u0541324_address&password=LaubKupoWrabca7&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("select group_id, group_name, group_header, group_footer from group_list");
             List<Group> groups = new ArrayList<>();
             while (rs.next()){
             Group group = new Group();
             group.setGroupId(rs.getInt("group_id"));
             group.setGroupName(rs.getString("group_name"));
             groups.add(group);
             }
             rs.close();
             st.close();
             conn.close();
            for (Group g : groups) {
                System.out.println(g);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


    }

}
