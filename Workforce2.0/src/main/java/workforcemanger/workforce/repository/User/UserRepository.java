package workforcemanger.workforce.repository.User;

import workforcemanger.workforce.entity.User;
import workforcemanger.workforce.repository.Repository;

public interface UserRepository extends Repository {
    public abstract User Login(String email , String password);
}
