package t_server;

import com.lsf.bean.User;
import com.lsf.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2020/2/21.
 */
/**
 * **
 *  * 使用Junit单元测试：测试我们的配置
 *  * Spring整合junit的配置
 *  *      1、导入spring整合junit的jar:spring-test(坐标)
 *  *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *  *             @Runwith
 *  *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *  *          @ContextConfiguration
 *  *                  locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *  *                  classes：指定注解类所在地位置
 *  *
 *  *   当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 *  */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/*.xml"})
public class TestUserService {

    @Autowired
    private UserMapper uMaper;

    @Test
    public void testGetUser(){
        User user = uMaper.selectByPrimaryKey(1);
        System.err.print("wwwwwwwwww-------"+user.toString());
    }

}
