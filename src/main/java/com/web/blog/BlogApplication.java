package com.web.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableJpaAuditing //JPA Auditing 기능을 사용하기 위한 어노테이션
@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	//HiddenHttpMethodFilter를 Bean으로 등록하지 않으면 @PutMapping과, @DeleteMapping이 작동하지 않았다. 따라서 메인 클래스에 HiddenHttpMethodFilter를 Bean으로 등록해주었다.
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}
}
