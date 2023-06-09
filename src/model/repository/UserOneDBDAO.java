package model.repository;

import model.entity.UserOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserOneDBDAO implements UserOneDBDAORead, UserOneDBDAOWrite {
    private final String url = "jdbc:mysql://localhost:3306/firstdb";
    private final String username = "root";
    private final String password = "Am311865186";

    private String query;

    private Statement statement;
    private Connection connection;

    public UserOneDBDAO() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            System.out.println("connected");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserOne> findByALl(long id) throws Exception {
        query = "select * from messenger where messenger_id = " + id;
        ResultSet set = statement.executeQuery(query);
        List<UserOne> userOneList = new ArrayList<>();
        while (set.next()) {
            UserOne userOne = new UserOne();
            userOne.setId(set.getInt("messenger_id"));
            userOne.setText(set.getString("messenger_text"));
            userOneList.add(userOne);
        }
        return userOneList;
    }

    @Override
    public void save(UserOne userOne) throws Exception {
        query = "insert into messenger (messenger_id , messenger_text) values ("
                + userOne.getId() + " , \"" + userOne.getText() + "\")";
        statement.executeUpdate(query);
        System.out.println(query);

    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
        System.out.println("disconnected");
    }
}
