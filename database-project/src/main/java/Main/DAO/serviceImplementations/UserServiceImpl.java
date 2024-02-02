package Main.DAO.serviceImplementations;

import Main.DAO.repos.UserRepo;
import Main.DAO.serviceInterfaces.UserService;
import Main.classes.NormalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public NormalUser getUserPhone(String phoneNumber) {
        return userRepo.getUserPhone(phoneNumber);
    }

    @Override
    public NormalUser getUserEmail(String email) {
        return userRepo.getUserEmail(email);
    }

    @Override
    public List<NormalUser> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public void updateUserID(NormalUser normalUser) {
        userRepo.setUserInfoById(normalUser.getName(), normalUser.getFname(), normalUser.getUserId());
    }

    @Override
    public void updateUserPhone(NormalUser normalUser) {
        userRepo.setUserInfoByPhone(normalUser.getName(), normalUser.getFname(), normalUser.getPhoneNumber());
    }

    @Override
    public void updateUserEmail(NormalUser normalUser) {
        userRepo.setUserInfoByEmail(normalUser.getName(), normalUser.getFname(), normalUser.getEmail());
    }

    @Override
    public void addUser(NormalUser normalUser) {
        if (normalUser.getUserId()!=null&&userRepo.findById(normalUser.getUserId()).isPresent()){
            normalUser.setUserId(null);
        }
        userRepo.save(normalUser);
    }

    @Override
    public void deleteUser(NormalUser normalUser) {
        userRepo.delete(normalUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

}
