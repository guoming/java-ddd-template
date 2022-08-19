import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan({"com.example.**"})
@MapperScan({"com.example.ddd.acl.**.mapper"})
public class JobApplication {
    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class);
    }
}
