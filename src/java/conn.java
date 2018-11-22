
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed_Hesham
 */
public class conn {
    public static Connection getConnection(){
        try {
            Connection conn ;
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("root");
            dataSource.setDatabaseName("faculty");
            dataSource.setServerName("localhost");
            conn = dataSource.getConnection();
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(conn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null ;
    }

    public static Student getdata(int ID){
        Student sd = new Student();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM faculty.` student` where faculty.` student`.id =" +  ID);
             rs.next();
            sd.ID = (rs.getInt(1));
            sd.name = (rs.getString(2));
            sd.address = (rs.getString(3));
            sd.GPA = (rs.getFloat(4));
        } catch (SQLException ex) {
            return new Student();
        }
        return sd;
    }
    
    public static int addStudent(int ID , String name, String address, float gpa){
        int rs ;
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeUpdate("INSERT INTO `faculty`.` student`"
                    + "(`id`, `name`, `address`, `gpa`)"
                    + "VALUES"
                    + "(" + ID + ",'" + name + "','" + address + "',"+ gpa + ");");
        } catch (SQLException ex) {
            Logger.getLogger(conn.class.getName()).log(Level.SEVERE, null, ex);
            return 0 ;
        }
        return rs;
    }
    
    public static int updateID(int ID , float gpa){
        int rs ;
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            rs = stmt.executeUpdate("UPDATE `faculty`.` student`"
                    + "SET"
                    + "`gpa` = " + gpa
                    + "where faculty.` student`.id =" + ID + ";");
        } catch (SQLException ex) {
            Logger.getLogger(conn.class.getName()).log(Level.SEVERE, null, ex);
            return 0 ;
        }
        return rs;
    }
}

class Student {
    public int ID;
    public String name;
    public String address;
    public float GPA;

    public Student() {
        this.ID = 0;
        this.name = "Null";
        this.address = "Null";
        this.GPA = (float) 0.0;
    }

}



