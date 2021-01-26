package models;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class JDBCLecture {
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new Driver());

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/codeup_test_db?serverTimezone=UTC&useSSL=false",
                    "root",
                    "P4$$w0rd4242"
            );

            // =================== Create a statement object

            Statement statement = connection.createStatement();

            // =================== Get a single result from a list of results

            String query = "SELECT * FROM albums";
            ResultSet rs = statement.executeQuery(query);

            // calling .next() once, iterates over the resultset one time.
            rs.next();

//            System.out.println(rs.getString(1));
//            System.out.println(rs.getString(2));
//            System.out.println(rs.getString(3));
//            System.out.println(rs.getString(4));
//            System.out.println(rs.getString(5));
//            System.out.println(rs.getString(6));


            rs.beforeFirst();
            //rs.previous();

            while(rs.next()){
                System.out.println("====================");
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("artist"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("release_date"));
                System.out.println(rs.getString("sales"));
                System.out.println(rs.getString("genre"));
            }

            // ================================== Getting Metadata

            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();

            for (int i = 1; i <= colCount; i += 1){
                System.out.println(rsmd.getColumnName(i));
            }

            // ================================== Working with album model (Bean)

            // move cursor back to beginning of result set
            rs.beforeFirst();

            // grab the first result
            rs.next();

            Album album = new Album(
                    rs.getLong("id"),
                    rs.getString("artist"),
                    rs.getString("name"),
                    rs.getInt("release_date"),
                    rs.getDouble("sales"),
                    rs.getString("genre")
            );

            System.out.println(album);
            System.out.println(album.getName());
            System.out.println(album.getReleaseDate());

            //========================= Update a record in the database

            Album updatedAlbum = new Album(
                    37,
                    "Nine Inch Nails",
                    "Broken",
                    1991,
                    100,
                    "industrial"
            );

            String updateQuery = String.format("UPDATE albums SET artist = '%s', name ='%s', release_date = %d, sales = %f, genre = '%s' WHERE id = %d",
                    updatedAlbum.getArtist(),
                    updatedAlbum.getName(),
                    updatedAlbum.getReleaseDate(),
                    updatedAlbum.getSales(),
                    updatedAlbum.getGenre(),
                    updatedAlbum.getId()
            );


            // returns true if the return type is a ResultSet; otherwise it returns false
            boolean success = statement.execute(updateQuery);
            int numbersOfRowsAffected = statement.executeUpdate(updateQuery);

            System.out.println(success);
            System.out.println(numbersOfRowsAffected);

            // =============================== Insert a record

            Album brandNewAlbum = new Album(
                    "Polyphia",
                    "G.O.A.T",
                    2019,
                    50,
                    "math rock"
            );

            String insertQuery = String.format("INSERT INTO albums (artist, name, release_date, sales, genre) VALUES ('%s','%s',%d,%f,'%s')",
                    brandNewAlbum.getArtist(),
                    brandNewAlbum.getName(),
                    brandNewAlbum.getReleaseDate(),
                    brandNewAlbum.getSales(),
                    brandNewAlbum.getGenre()
            );

            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet newSet = statement.getGeneratedKeys();

            if (newSet.next()){
                System.out.println("Inserted id is: " + newSet.getLong(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

