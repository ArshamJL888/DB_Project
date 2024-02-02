package Main.DAO.repos;

import Main.classes.NormalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface UserRepo extends JpaRepository<NormalUser, Long> {

    @Query("select user from NormalUser user where user.phoneNumber= :phoneNumber")
    public NormalUser getUserPhone(@Param("phoneNumber") String phoneNumber);

    @Query("select user from NormalUser user where user.email= :email")
    public NormalUser getUserEmail(@Param("email") String email);

    @Modifying
    @Query("update NormalUser u set u.name = ?1, u.fname = ?2 where u.userId = ?3")
    void setUserInfoById(String firstname, String lastname, Long userId);

    @Modifying
    @Query("update NormalUser u set u.name = ?1, u.fname = ?2 where u.phoneNumber = ?3")
    void setUserInfoByPhone(String firstname, String lastname, String phone);

    @Modifying
    @Query("update NormalUser u set u.name = ?1, u.fname = ?2 where u.email = ?3")
    void setUserInfoByEmail(String firstname, String lastname, String email);
}
