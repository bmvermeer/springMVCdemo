package nl.brianvermeer.snyk.springmvc.repo;

import nl.brianvermeer.snyk.springmvc.model.Message;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository
public class MessageRepo {

    public static final String JDBC_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";

    public static final String USER = "sa";
    public static final String PASS = "";


    public List<Message> searchMessage(String text) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT * FROM message WHERE text LIKE '" + text + "'";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            List<Message> foundMessages = createUsersFromResultSet(result);
            return foundMessages;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    public List<Message> findAllMessages() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT * FROM message";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            List<Message> allMessages = createUsersFromResultSet(result);

            return allMessages;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }



    private List<Message> createUsersFromResultSet(ResultSet result) throws SQLException{
        List<Message> messages = new ArrayList<>();
        while (result.next()) {
            Message message = new Message();
            message.setText(result.getString("text"));
            message.setUserId(result.getString("user"));
            messages.add(message);
        }
        return messages;
    }

    public void createDatabase() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "CREATE TABLE MESSAGE " +
                    "(id VARCHAR(255) not NULL, " +
                    " text VARCHAR(255), " +
                    " user VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertMessage(Message message) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            var id = UUID.randomUUID().toString();
            String sql = "INSERT INTO MESSAGE (ID, TEXT, USER) VALUES ('"+id+"','"+message.getText()+"','"+message.getUserId()+"')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
