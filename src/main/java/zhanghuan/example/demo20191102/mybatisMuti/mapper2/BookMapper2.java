package zhanghuan.example.demo20191102.mybatisMuti.mapper2;

import org.apache.ibatis.annotations.Mapper;
import zhanghuan.example.demo20191102.mybatisMuti.bean.Book;

import java.util.List;

@Mapper
public interface BookMapper2 {
    List<Book> getAllBook();
}
