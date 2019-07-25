package tests;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDbConnection {

    @Test
    public void testConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://u0541324.cp.regruhosting.ru:2083/u0541324_addressbook?" +
                    "user=u0541324_addressbook&password=LaubKupoWrabca7&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
            /**
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
             System.out.println(groups);
             */
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


    }

}
