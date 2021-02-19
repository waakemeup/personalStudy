import com.waakemeup.dao.UserMapper;
import com.waakemeup.pojo.User;
import com.waakemeup.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {


    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUsers(1);
        System.out.println(user);
        sqlSession.close();
        System.out.println("=======================");
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUsers(1);
        System.out.println(user2);
        System.out.println(user==user2);
        User user3 = mapper2.queryUsers(2);
        System.out.println(user3);

        User user4 = mapper2.queryUsers(2);
        System.out.println(user3);

        sqlSession2.close();
    }
}
