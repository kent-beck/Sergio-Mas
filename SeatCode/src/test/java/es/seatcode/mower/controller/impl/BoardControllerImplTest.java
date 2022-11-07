package es.seatcode.mower.controller.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import es.seatcode.mower.utils.TestUtils;
import es.seatcode.mower.domain.Board;
import es.seatcode.mower.service.impl.BoardServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BoardControllerImplTest {
		
	@InjectMocks
	private BoardControllerImpl boardControllerImpl;
	
	@InjectMocks
	private BoardServiceImpl boardServiceImpl;
	
	@Test 
	public void testCreateBoard() {
		
		Board result = boardControllerImpl.createBoard(null, null, null);
		
		assertNotNull(result);
		assertNull(result.getColumns());
		assertNull(result.getRows());
		
		result = boardControllerImpl.createBoard(TestUtils.TEST_POSITION, TestUtils.TEST_CELL, TestUtils.TEST_CELL_2);
		
		assertNotNull(result);
		assertNotNull(result.getColumns());
		assertNotNull(result.getRows());
		
	}
	
	@Test 
	public void testResolveMovement() {
	
		boardControllerImpl.resolveMovement(null, null, null, null, null);
		boardControllerImpl.resolveMovement(TestUtils.TEST_BOARD, null, null, null, null);
		boardControllerImpl.resolveMovement(TestUtils.TEST_BOARD, TestUtils.TEST_CELL, null, null, null);
		boardControllerImpl.resolveMovement(TestUtils.TEST_BOARD, TestUtils.TEST_CELL, TestUtils.TEST_MOVEMENT, null, null);
		boardControllerImpl.resolveMovement(TestUtils.TEST_BOARD, TestUtils.TEST_CELL, TestUtils.TEST_MOVEMENT, TestUtils.TEST_CELL_2, null);
		boardControllerImpl.resolveMovement(TestUtils.TEST_BOARD, TestUtils.TEST_CELL_2, TestUtils.TEST_MOVEMENT, TestUtils.TEST_CELL_3, TestUtils.TEST_MOVEMENT);
		
	}

}
