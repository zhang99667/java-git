import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // 1. 加载类路径下的配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml.bak");
        // 2. 从文件系统下加载配置文件
        // ApplicationContext fctx = new FileSystemXmlApplicationContext("E:\\java-git\\Spring\\Spring_10_container\\src\\main\\resources\\applicationContext.xml.bak");
        // 3. 加载多个配置文件
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml.bak","applicationContext2.xml");

        // BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        // BookDao bookDao1 = ctx.getBean("bookDao", BookDao.class);
        BookDao bookDao2 = ctx.getBean(BookDao.class);
        bookDao2.save();
    }
}