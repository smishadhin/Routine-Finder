/*
 * This code is written by Muhiminul Islam Shadhin (website: shadhin.slasstec.com) and he is copyright owner
 * Only  Muhiminul Islam Shadhin (website: shadhin.slasstec.com) has the authority to change the code.
 * If you are viewing or editing the code without the permission of  Muhiminul Islam Shadhin (website: shadhin.slasstec.com) then its a crime and you
are breaking the law of copyright.
 */
package routine.finder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Muhiminul Islam Shadhin <smi.shadhin at gmail.com>
 */
public class DataRetrive {

    String[] array = new String[1000];

    void retrivedata() throws ClassNotFoundException, SQLException {
        Connection c = null;
        Statement stmt = null;
        Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:course.db");
        c.setAutoCommit(false);
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT DISTINCT CourseCode FROM courselist");
        while (rs.next()) {
            String course = rs.getString("CourseCode");
            // System.out.println(course);

        }
        rs.close();
        stmt.close();
        c.close();
    }

}
