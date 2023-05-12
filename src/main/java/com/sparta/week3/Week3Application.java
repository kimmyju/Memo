package com.sparta.week3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing//데이터 변동이 있을 떄 jpa가 자동으로 반영해주기 위해 존재, 이게 꼭 있어야 생성시간 및 수정시간이 바뀌었을 때 서버에 자동 반영 업데이트가 됨
@SpringBootApplication
public class Week3Application {

    public static void main(String[] args) {
        SpringApplication.run(Week3Application.class, args);
    }

}
