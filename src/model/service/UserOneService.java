package model.service;

import model.entity.UserOne;
import model.repository.UserOneDBDAO;
import model.repository.UserOneDBDAORead;
import model.repository.UserOneDBDAOWrite;

import java.util.List;

public class UserOneService implements UserOneServiceRead, UserOneServiceWrite {
    UserOneDBDAOWrite write;
    UserOneDBDAORead read;

    @Override
    public List<UserOne> findByALl(String  username) {
        List<UserOne> userOneList;
        try {
            read = new UserOneDBDAO();
            userOneList = read.findByALl(username);
            read.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return userOneList;
    }

    @Override
    public boolean findByUsername(UserOne userOne) {
        boolean ByUsername;
        try {
            read = new UserOneDBDAO();
            ByUsername = read.findByUsername(userOne);
            read.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ByUsername;
    }

    @Override
    public void save(UserOne userOne) {
        try {
            write = new UserOneDBDAO();
            write.save(userOne);
            write.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
