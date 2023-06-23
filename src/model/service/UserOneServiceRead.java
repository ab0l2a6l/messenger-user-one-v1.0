package model.service;

import model.entity.UserOne;

import java.util.List;

public interface UserOneServiceRead {
    List<UserOne> findByALl(String  id);

    boolean findByUsername(UserOne userOne);


    boolean listner (String id);
}
