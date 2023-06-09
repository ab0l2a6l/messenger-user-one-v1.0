package model.repository;

import model.entity.UserOne;

import java.util.List;

public class UserOneDBDAO implements UserOneDBDAORead , UserOneDBDAOWrite{
    @Override
    public List<UserOne> findByALl() {
        return null;
    }

    @Override
    public void save(UserOne userOne) {

    }
}
