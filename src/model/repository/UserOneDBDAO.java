package model.repository;

import model.entity.UserOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserOneDBDAO implements UserOneDBDAORead, UserOneDBDAOWrite {
    private final String url = "jdbc:mysql://localhost:3306/messenger";
    private final String username = "root";
    private final String password = "Am311865186";

    private String query;

    private Statement statement;
    private Connection connection;

    public UserOneDBDAO() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            System.err.println("connected");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean listner(String id) throws Exception {
        query = "select listner from listener where chat_id =\"" + id + "\"";
        ResultSet set = statement.executeQuery(query);
        boolean isTrue = false;
        if (set.next()) {
            isTrue = set.getBoolean("listner");
        }
        if (isTrue)
            return true;
        return false;
    }

    @Override
    public List<UserOne> findByALl(String id) throws Exception {

        query = "select * from chat where username_private = \"" + id + "\"";
        ResultSet set = statement.executeQuery(query);
        List<UserOne> userOneList = new ArrayList<>();
        while (set.next()) {
            UserOne userOne = new UserOne();
            userOne.setUsername(set.getString("username_private"));
            userOne.setText(set.getString("text"));
            userOneList.add(userOne);
        }
        query = "update listener set  listner=false  where chat_id = \"" + id +
                "\" ";
        System.out.println(query);
        statement.executeUpdate(query);
        return userOneList;

    }

    @Override
    public boolean findByUsername(UserOne userOne) throws Exception {
        query = "select * from private where password =\"" + userOne.getPassword()
                + "\" and username =\"" + userOne.getUsername() + "\"";
        System.out.println(query);
        ResultSet set = statement.executeQuery(query);
        if (set.next()) {
            return true;
        }
        return false;
    }

    @Override
    public void save(UserOne userOne) throws Exception {
        query = "insert into chat (text , username_private) values (\""
                + userOne.getText() + "\" , \"" + userOne.getUsername() + "\")";
        statement.executeUpdate(query);
        query = "update listener set listner=true where chat_id = \"" + userOne.getUsername() +
                "\" ";
        statement.executeUpdate(query);
        System.out.println(query);

    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
        System.err.println("disconnected");
    }


}
