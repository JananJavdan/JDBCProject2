package MySecondSqlConnection;

import java.sql.*;

public class myjdbc {
    public static void main(String[] args) {
        try {

            // STAP 01: de pakketten importeren
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // System.out.println("Step 1 -> Success: " + "Driver is configured");

            // STAP 2 : een verbinding openen
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thebelgianbrewerydb",
                    "Janan",
                    "2024");
            System.out.println(" Step 2 -> SUCCESS: " + "Connection is made between MYSQL and JAVA");

            // STAP 03: Een/Meerdere queries uitvoeren/Statement uitvoeren

            Statement statement = connection.createStatement();
            ResultSet selectResult = statement.executeQuery("select Id, Name, BrewerId, CategoryId, Price, Stock, Alcohol, Version, Image from Beers ");

            while (selectResult.next()) {
                System.out.println(selectResult.getRow() + " | " +
                        selectResult.getInt("Id") + " | " +
                        selectResult.getString("Name") + " | " +
                        selectResult.getInt("CategoryId") + " | " +
                        selectResult.getInt("Price") + " | " +
                        selectResult.getInt("Stock") + " | " +
                        selectResult.getInt("Alcohol")
                );

            }

            Statement insertStatement = connection.createStatement();
            insertStatement.execute("INSERT IGNORE INTO Beers VALUES (1557,'New Insert Janan',2,18,2.65,200,6,0,NULL)");
            System.out.println("MY Data inserted");

            Statement updateStatement = connection.createStatement();
            updateStatement.executeUpdate("UPDATE Beers" + " SET Name = 'MY New Name Janan' WHERE ID IN(1558)");
            System.out.println("My Data UPDATE");

            Statement deleteStatement = connection.createStatement();
            deleteStatement.execute("DELETE FROM Beers" + " WHERE Id = 1557");
            System.out.println("My Data Deleted");


        } //catch (ClassNotFoundException notFoundException){
        //System.err.println("Step 1 -> CLASS NOT FOUND EXCEPTION: " + notFoundException.getMessage());
        // }


        catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }
}





