import com.itheima.service.BookService;
import com.itheima.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = (BookService) ctx.getBean(BookService.class);
        BookService bookService1 = (BookService) ctx.getBean(BookService.class);
        System.out.println("bookService = " + bookService);
        System.out.println("bookService1 = " + bookService1);
        bookService.save();
        ctx.close();
    }
}