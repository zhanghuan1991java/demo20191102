package zhanghuan.example.demo20191102.mybatisMuti.mapper1;

import org.apache.ibatis.annotations.Mapper;
import zhanghuan.example.demo20191102.mybatisMuti.bean.Book;

import java.util.List;

@Mapper
public interface BookMapper1 {
    List<Book> getAllBook();
}
