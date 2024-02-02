package Main.DAO.serviceInterfaces;

import Main.classes.NormalUser;

import java.util.List;

public interface UserService {
    public NormalUser getUserPhone(String phoneNumber);

    public NormalUser getUserEmail(String email);

    public List<NormalUser> getUsers();

    public void updateUserID(NormalUser normalUser);
    public void updateUserPhone(NormalUser normalUser);
    public void updateUserEmail(NormalUser normalUser);

    public void addUser(NormalUser normalUser);

    public void deleteUser(NormalUser normalUser);

    void deleteUser(Long id);
}
