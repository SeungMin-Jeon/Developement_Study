package com.greglturnquist.hackingspringbootch1reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 자동설정과 컴포넌트 탐색 기능을 포함하는 복합 애너테이션이다.
public class HackingSpringBootCh1ReactiveApplication {

	public static void main(String[] args) {

		SpringApplication.run(HackingSpringBootCh1ReactiveApplication.class, args);
		// 이 클래스를 애플리케이션 시작점으로 등록하는 스프링 부트 훅 이다
	}

}
