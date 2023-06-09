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
    public List<UserOne> findByALl(long id) {
        List<UserOne> userOneList;
        try {
            read = new UserOneDBDAO();
            userOneList = read.findByALl(id);
            read.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return userOneList;
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
