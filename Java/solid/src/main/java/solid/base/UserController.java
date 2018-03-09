package solid.base;

import java.util.ArrayList;
import java.util.List;

public class UserController implements UserService {

    private UserService userService;
    private List<Validator> validators = new ArrayList<>();

    public UserController(UserService userService, List<Validator> validators) {
        this.userService = userService;
        this.validators = validators;
    }

    public void createUser(String userName){
        boolean isAllValid=true;
        for(Validator validator:validators){
            if(!validator.isValid(userName)){
                isAllValid=false;
                break;
            }
        }
        if (isAllValid){
            save(new User(userName));
        }
    }

    @Override
    public void save(User user) {
        userService.save(user);
    }
}
