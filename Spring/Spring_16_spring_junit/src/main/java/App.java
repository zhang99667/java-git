import com.itheima.pojo.User;
import com.itheima.service.UserService;
import config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        User user = userService.selectById(2);
        System.out.println("user = " + user);
    }
}