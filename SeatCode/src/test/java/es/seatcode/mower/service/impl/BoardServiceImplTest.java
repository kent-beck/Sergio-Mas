package es.seatcode.mower.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import es.seatcode.mower.utils.TestUtils;
import es.seatcode.mower.domain.Board;

@RunWith(MockitoJUnitRunner.class)
public class BoardServiceImplTest {
	
	@InjectMocks
	private BoardServiceImpl boardServiceImpl;
	
	@Test 
	public void testCreateBoard() {
		
		Board result = boardServiceImpl.createBoard(null, null, null);
		
		assertNotNull(result);
		assertNull(result.getColumns());
		assertNull(result.getRows());
		
		result = boardServiceImpl.createBoard(TestUtils.TEST_POSITION, TestUtils.TEST_CELL, TestUtils.TEST_CELL_2);
		
		assertNotNull(result);
		assertNotNull(result.getColumns());
		assertNotNull(result.getRows());
				
	}
	
	@Test 
	public void testResolveMovement() {
		
		Board result = boardServiceImpl.createBoard(null, null, null);
		
		assertNotNull(result);
		assertNull(result.getColumns());
		assertNull(result.getRows());
		
		result = boardServiceImpl.createBoard(TestUtils.TEST_POSITION, TestUtils.TEST_CELL, TestUtils.TEST_CELL_2);
		
		assertNotNull(result);
		assertNotNull(result.getColumns());
		assertNotNull(result.getRows());
				
	}

}
