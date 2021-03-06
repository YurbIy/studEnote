package com.epam.note;

import com.epam.note.config.AppConfig;
import com.epam.note.model.User;
import com.epam.note.repos.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class UserRepoTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void getAll() {
        User user = new User();
        user.setId(1);
        user.setName("Aru");
        user.setLogin("Ariha@yandex.ru");
        user.setPassword("1234");

        userRepository.save(user);
        User user1 = userRepository.getById(1);

        assertThat(user1.getName(), is("Aru"));
    }


    @Test
    public void getByName() {
        User user = new User();
        user.setId(1);
        user.setName("Ari");
        user.setLogin("Ariha@yandex.ru");
        user.setPassword("1234");

        userRepository.save(user);
        User one = userRepository.getByName("Ari");
        assertThat(one.getName(), is("Ari"));
    }

    @Test
    public void deleteById() {
        User user = new User();
        user.setId(1);
        user.setName("Peri");
        user.setLogin("Ariha@yandex.ru");
        user.setPassword("1234");

        User user1 = new User();
        user1.setId(2);
        user1.setName("Arisha");
        user1.setLogin("Ariha@yandex.ru");
        user1.setPassword("1234");

        userRepository.save(user);
        userRepository.save(user1);
        List<User> all = userRepository.findAll();
        all.forEach(t -> System.out.println(t.getName()));

    }

}
