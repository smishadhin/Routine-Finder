/*
 * This code is written by Muhiminul Islam Shadhin (website: shadhin.slasstec.com) and he is copyright owner
 * Only  Muhiminul Islam Shadhin (website: shadhin.slasstec.com) has the authority to change the code.
 * If you are viewing or editing the code without the permission of  Muhiminul Islam Shadhin (website: shadhin.slasstec.com) then its a crime and you
are breaking the law of copyright.
 */


package routine.finder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 *
 * @author Muhiminul Islam Shadhin <smi.shadhin at gmail.com>
 */
public class ConnectionDatabase {
    public  void databaseConnection(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:course.db");
            //System.out.println("Opened database successfully");

            stmt = c.createStatement();
             String sql2="DROP TABLE if exists courselist";
            String sql = "create table if not exists courselist(CourseCode   TEXT  )";
           stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
           // System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           // System.exit(0);
        }
        //System.out.println("Table created successfully");
    }
}
