package user;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import own.jadezhang.learning.almond.mp.domain.AuthUser;
import own.jadezhang.learning.almond.mp.service.user.IAuthUserService;

/**
 * Created by Zhang Junwei on 2017/9/21 0021.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-user-test.xml"})
public class UserTester {

    @Autowired
    private IAuthUserService authUserService;

    @Test
    public void test() throws Exception {
        AuthUser authUser = authUserService.selectById(1L);
        System.out.println(JSON.toJSONString(authUser));
    }
}
