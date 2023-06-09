package model.repository;

import model.entity.UserOne;

import java.util.List;

public interface UserOneDBDAORead {
    List<UserOne> findByALl(String  id) throws Exception;

    boolean findByUsername(UserOne userOne) throws Exception;

    void close() throws Exception;
}
