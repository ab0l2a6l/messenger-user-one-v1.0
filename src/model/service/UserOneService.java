package model.service;

import model.entity.UserOne;

import java.util.List;

public class UserOneService implements UserOneServiceRead , UserOneServiceWrite{
    @Override
    public List<UserOne> findByALl() {
        return null;
    }

    @Override
    public void save(UserOne userOne) {

    }
}
