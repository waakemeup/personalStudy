import com.waakemeup.dao.UserMapper;
import com.waakemeup.pojo.User;
import com.waakemeup.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        /*List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        User userById = mapper.getUserById(2);
        System.out.println(userById);
        mapper.addUser(new User(4,"NaN4","748393"));
        mapper.UpdateUser(new User(4,"QwQ","741289"));*/
        mapper.deleteUser(4);
        sqlSession.close();
    }
}
