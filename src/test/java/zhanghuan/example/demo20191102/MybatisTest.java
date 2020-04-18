package zhanghuan.example.demo20191102;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zhanghuan.example.demo20191102.mybatis.mapper.UserMapper;
import zhanghuan.example.demo20191102.mybatisMuti.mapper1.BookMapper1;
import zhanghuan.example.demo20191102.mybatisMuti.mapper2.BookMapper2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
//    @Autowired
//    UserMapper mapper;

//    @Autowired
//    BookMapper1 mapper1;

//    @Autowired
//    BookMapper2 mapper2;

    @Test
    public void getUser(){
//        System.out.println(mapper.getAllUser());
    }

    @Test
    public void getBook(){
//        System.out.println(mapper1.getAllBook());

//        System.out.println(mapper2.getAllBook());

    }

}
