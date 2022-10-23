import com.itheima.pojo.Account;
import com.itheima.mapper.AccountMapper;
import com.itheima.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class App {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        mapper.update(new Account(7,"trump",200.0));
        sqlSession.commit();
        sqlSession.close();
    }
}