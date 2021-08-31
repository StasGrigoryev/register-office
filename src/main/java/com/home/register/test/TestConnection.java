package com.home.register.test;

import java.sql.*;
import java.util.Properties;

public class TestConnection {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/library";
            Properties props = new Properties();
            props.setProperty("user","dev");
            props.setProperty("password","dev");
            Connection con = DriverManager.getConnection(url, props);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from books");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t"
                        + rs.getString(2) + "\t"
                        + rs.getString(3) + "\t"
                        + rs.getString(4));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
