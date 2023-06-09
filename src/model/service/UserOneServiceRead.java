package model.service;

import model.entity.UserOne;

import java.util.List;

public interface UserOneServiceRead {
    List<UserOne> findByALl(long id);
}
