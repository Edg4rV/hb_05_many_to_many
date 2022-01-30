package io.hibernate.testJDBC

import java.sql.Connection
import java.sql.DriverManager

class TestJDBC {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC"
        String user = "hbstudent"
        String pass = "hbstudent"


        try {
            println "Connecting to database: ${jdbcUrl}"

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl, user, pass)

            println myConn

            println "Connection successful!!!"
        } catch (Exception exc) {
            exc.printStackTrace()
        }


    }
}
