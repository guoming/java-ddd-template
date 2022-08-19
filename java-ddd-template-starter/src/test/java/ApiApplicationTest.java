import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = ApiApplication.class)
public class ApiApplicationTest {

    @Resource
    com.example.ddd.acl.port.repository.user.userRepository userRepository;

    @Test
    public void Test()
    {}

}
