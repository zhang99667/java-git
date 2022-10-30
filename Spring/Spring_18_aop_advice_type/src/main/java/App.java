import com.itheima.config.SpringConfig;
import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = ctx.getBean(UserDao.class);
        userDao.save();
    }
}