import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> outputAds = new ArrayList<>();
        String query = "SELECT * FROM ads";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                outputAds.add(
                        new Ad(
                                rs.getLong("id"),
                                rs.getLong("user_id"),
                                rs.getString("title"),
                                rs.getString("description")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outputAds;
    }

    @Override
    public Long insert(Ad ad) {
        long insertedAd = 0;
        String insert = String.format("INSERT INTO ads (id, user_id, title, description) VALUES ('%d', '%d', '%s', '%s')", ad.getId(), ad.getUserId(), ad.getTitle(), ad.getDescription());

        try {
            Statement statement = connection.createStatement();
            insertedAd = statement.executeUpdate(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insertedAd;
    }
}

