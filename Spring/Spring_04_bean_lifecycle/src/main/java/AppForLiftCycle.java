import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForLiftCycle {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.registerShutdownHook(); // 注册钩子，表示关闭 Java 虚拟机之前销毁

        // BookDao bookDao = (BookDao) ctx.getBean("BookDao");
        // bookDao.save();
        ctx.close();
        BookService bookService = (BookService) ctx.getBean("BookService");
        bookService.save();
    }
}