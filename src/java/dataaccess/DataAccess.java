/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jhlee
 */
public class DataAccess {

    Connection connection = null;
    PreparedStatement pStatement = null;
    ResultSet result = null;
    int numOfrow = 0;

    /**
     * Connection method to connect to database
     */
    public void connection() {
        String driverName = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String connectionURL = "jdbc:mysql://localhost/cars";
        String user = "root";
        String pass = "";

        try {
            connection = DriverManager.getConnection(connectionURL, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Disconnect method to disconnect from database
     */
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * select method to retrieve all order records from the OrderInfo table.
     *
     * @return ArrayList of OrderInfo object
     */
    public boolean select(int custNo) {
        boolean custIdValid = false;
        String query = "select customerId from customer where customerId = ?;";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, String.valueOf(custNo));
            result = pStatement.executeQuery();
            if (result.next()) {
              custIdValid = true;  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return custIdValid;
    }
}
