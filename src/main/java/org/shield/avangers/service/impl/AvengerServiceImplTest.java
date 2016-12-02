package org.shield.avangers.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.shield.avangers.dao.AvengerDAO;
import org.shield.avangers.model.Avenger;
import org.springframework.test.util.ReflectionTestUtils;

public class AvengerServiceImplTest {

	@Test
	public final void testGetAvenger() throws Exception {
		AvengerServiceImpl avengerService = new AvengerServiceImpl();
		
		AvengerDAO dao=Mockito.mock(AvengerDAO.class);
		//avengerService.avengerdao=dao;
		ReflectionTestUtils.setField(avengerService, "avengerdao", dao, AvengerDAO.class);
		Avenger av=new Avenger();
		Mockito.when(dao.getById(12)).thenReturn(av);
		
		
		Mockito.verify(dao).getById(12);
		
		Avenger avenger=avengerService.getAvenger(12);
		assertSame(av, avenger);
	}

	//@Test
	//public final void testSave() {
	//	fail("Not yet implemented"); // TODO
	//}

	//@Test
	//public final void testDelete() {
//		fail("Not yet implemented"); // TODO
	//}

//	@Test
	//public final void testFindAll() {
	//	fail("Not yet implemented"); // TODO
//	}

}
