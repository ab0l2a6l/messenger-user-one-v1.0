package model.repository;

import model.entity.UserOne;

public interface UserOneDBDAOWrite {
    void save(UserOne userOne) throws Exception;

    void close() throws Exception;
}
