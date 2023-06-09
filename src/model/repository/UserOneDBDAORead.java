package model.repository;

import model.entity.UserOne;

import java.util.List;

public interface UserOneDBDAORead {
    List<UserOne> findByALl();
}
