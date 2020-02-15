package com.protom.mytime.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.protom.mytime.dao.entity.TimeEntity;
import com.protom.mytime.dao.exception.DaoException;
import com.protom.mytime.dao.impl.filter.TimeSearchFilter;
import com.protom.mytime.dto.TimeDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TimeDaoTest {
	
	@Autowired
	TimeDao dao;
	
	@Autowired
	TimeDetailDao detailDao;
    
	@Test
	public void selectAll() {
		List<TimeDto> result = null;
		try {
			result = dao.findByFilter(
					TimeSearchFilter
					.builder()
					.setOwnerUsername("danilo.dinuzzo")
					.setIdStatus(2)
					);
			//System.out.println(result.size());
		} catch (DaoException e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(result);
	}
	
	//@Test
	@WithMockUser(username="danilo.dinuzzo",roles={"USER","ADMIN"})
	public void insert() {
		TimeEntity te = new TimeEntity();
		te.setApproverUser("salvatore.sica");
		te.setInsertDate(new Date());
		te.setInsertUser("danilo.dinuzzo");
		te.setMonth(12);
		te.setOwnerUser("danilo.dinuzzo");
		te.setPeriod(2);
		te.setYear(2019);
		try {
			dao.persist(te);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
}
