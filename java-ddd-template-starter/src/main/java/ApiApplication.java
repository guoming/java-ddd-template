import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({"com.example.**"})
@MapperScan({"com.example.ddd.acl.**.mapper"})
public class ApiApplication
{
    public static void main(String[] args) {

        SpringApplication.run(ApiApplication.class);
    }
}
