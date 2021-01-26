package dao;

import com.mysql.cj.jdbc.Driver;
import models.Contact;
import sun.security.krb5.Config;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLContactsDao implements Contacts{

    private Connection connection;

    public MySQLContactsDao(Config config){
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
    public List<Contact> getContacts() {
        List<Contact> output = new ArrayList<>();
        String query = "SELECT * FROM contacts";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                output.add(
                        new Contact(
                                rs.getLong("id"),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("phone_number")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    @Override
    public long saveContact(Contact contact) {
        return 0;
    }

    @Override
    public void deleteContactById(long id) {

    }

    @Override
    public Contact getContactById(long id) {
        Contact contact = new Contact();

        String query = String.format("SELECT * FROM contacts WHERE id = %d", id);

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            if(rs.next()){
                contact.setId(rs.getLong("id"));
                contact.setFirstName(rs.getString("first_name"));
                contact.setLastName(rs.getString("last_name"));
                contact.setPhoneNumber(rs.getString("phone_number"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contact;
    }
}