package model.repository;

import model.entity.UserOne;

import java.util.List;

public interface UserOneDBDAORead {
    List<UserOne> findByALl(long id) throws Exception;

    void close() throws Exception;
}
