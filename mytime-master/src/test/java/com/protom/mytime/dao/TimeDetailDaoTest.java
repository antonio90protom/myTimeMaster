package com.protom.mytime.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.protom.mytime.dao.impl.filter.TimeDetailSearchFilter;
import com.protom.mytime.dto.TimeDetailDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TimeDetailDaoTest {

	@Autowired
	TimeDetailDao dao;
	
	@Test
	public void findTest() {
		List<TimeDetailDto> result = null;
		try {
			result = dao.findByFilter(
					TimeDetailSearchFilter.builder()
					.setIdTime(1)
					.setOwnerUsername("danilo.dinuzzo")
					);
			System.out.println(result);
		} catch ( Exception e ) {
			System.out.println(e);
		}
		//Assert.assertNull(result);
	}
}
