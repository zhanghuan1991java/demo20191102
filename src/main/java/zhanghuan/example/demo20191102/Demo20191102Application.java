package zhanghuan.example.demo20191102;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
//@MapperScan(basePackages = "zhanghuan.example.demo20191102.mybatis.mapper")
public class Demo20191102Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo20191102Application.class, args);
	}

}
