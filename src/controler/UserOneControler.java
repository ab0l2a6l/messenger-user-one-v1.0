package controler;

import model.entity.UserOne;
import model.service.UserOneService;
import model.service.UserOneServiceRead;
import model.service.UserOneServiceWrite;

import java.util.List;

public class UserOneControler {
    UserOneServiceWrite write = new UserOneService();
    UserOneServiceRead read = new UserOneService();

    public void save(UserOne userOne) {
        write.save(userOne);
    }

    public List<UserOne> findByAll(String  id) {
        return read.findByALl(id);
    }

    public boolean findByUsername(UserOne userOne) {
        return read.findByUsername(userOne);
    }
}
