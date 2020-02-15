package com.protom.mytime.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.protom.mytime.dao.exception.DaoException;
import com.protom.mytime.dto.StatusDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StatusDaoTest {
	
	@Autowired
	StatusDao dao;
	
	@Test
	public void getAllActive() {
		try {
			List<StatusDto> result = dao.getAllActive();
			Assert.assertNotNull(result);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
