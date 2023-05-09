package com.kbstar.adm;

import com.kbstar.dto.Adm;
import com.kbstar.service.AdmService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class SelectTests {
	@Autowired
	AdmService service;

	@Test
	void contextLoads() {
		List<Adm> list = null;

		try {
			list=service.get();

//			for(Adm obj:list){
//				log.info(obj.toString());
			} catch (Exception e) {

				log.info("......에러다.........");
				e.printStackTrace();
			}

		}
	}

