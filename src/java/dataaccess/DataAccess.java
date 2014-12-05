/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import pricing.PriceSchedule;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
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

        String connectionURL = "jdbc:mysql://localhost/Cars";
        String user = "root";
        String pass = "1111";

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
     * method to check if customer number exist in the database
     *
     * @return the value that if customer id exist in the database
     */
    public boolean doesCustNumberExist(int custNo) {
        boolean custIdValid = false;
        String query = "select customerId from Customer where customerId = ?;";
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

    public PriceSchedule getCarTypePriceSchedule(String carType) throws CarTypeNotFoundException {
        PriceSchedule resultPriceSchedule = null;
        String query = "select * from CarType where ShortName = ?;";

        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, carType);
            result = pStatement.executeQuery();

            if (result.next()) {
                resultPriceSchedule = new PriceSchedule(carType, result.getBigDecimal("WeekdayRate"), result.getBigDecimal("WeekendRate"), result.getBigDecimal("WeeklyRate"));
            } else {
                System.out.println("Car Type Not Found");
                throw new CarTypeNotFoundException();
            }

            return resultPriceSchedule;
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }

        return resultPriceSchedule;
    }
}
