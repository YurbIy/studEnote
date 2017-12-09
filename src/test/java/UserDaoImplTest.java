import com.epam.note.config.AppConfig;
import com.epam.note.dao.UserDaoImpl;
import com.epam.note.model.User;
import com.epam.note.persistence.UserRepository;
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
public class UserDaoImplTest {

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



}