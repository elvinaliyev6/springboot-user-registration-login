package com.company;


import com.company.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user=new User();
        user.setEmail("parvinaliydevinfo@gmail.com");
        user.setPassword("parvin12345");
        user.setFirstName("Parvrin");
        user.setLastName("Aliyev");

        User savedUser=repo.save(user);

       User existUser= entityManager.find(User.class,savedUser.getId());

       assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email="test@gmail.com";

        User user=repo.findByEmail(email);

        assertThat(user).isNotNull();
    }



}
