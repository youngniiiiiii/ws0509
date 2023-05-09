package com.kbstar.adm;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Cust;
import com.kbstar.service.AdmService;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@Slf4j
@SpringBootTest
class InsertTests {
	@Autowired
	AdmService service;

	@Test
	void contextLoads() {
		Adm obj = new Adm("id21", "pwd21", 1);
		try {
			service.register(obj);
			log.info("등록정상...");
		} catch (Exception e) {
			if (e instanceof DuplicateKeyException) {
				log.info("......ID가 중복되었습니다.......");
			} else {
				log.info("......시스템장애입니다.........");
				e.printStackTrace();
			}

		}
	}
}
