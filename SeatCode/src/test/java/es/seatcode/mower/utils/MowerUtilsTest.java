package es.seatcode.mower.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.seatcode.mower.utils.MowerUtils;

public class MowerUtilsTest {
	
	@Test
	public void testMowerUtilsCanMoveNorth() {
		
		boolean result = MowerUtils.canMoveNorth(null, null);
		
		assertFalse(result);
		
		result = MowerUtils.canMoveNorth(null, null);
		
		assertFalse(result);
		
		result = MowerUtils.canMoveNorth(TestUtils.TEST_COORDINATE_X, TestUtils.TEST_ROWS_BOARD);
		
		assertFalse(result);
		
		result = MowerUtils.canMoveNorth(TestUtils.TEST_COORDINATE_X_VALUE_3, TestUtils.TEST_ROWS_BOARD);
		
		assertTrue(result);
		
	}
	
	@Test
	public void testMowerUtilsCanMoveSouth() {
		
		boolean result = MowerUtils.canMoveSouth(null);
		
		assertFalse(result);
		
		result = MowerUtils.canMoveSouth(TestUtils.TEST_COORDINATE_Y_VALUE_0);
		
		assertFalse(result);
		
		result = MowerUtils.canMoveSouth(TestUtils.TEST_COORDINATE_Y);
		
		assertTrue(result);
		
	}
	
	@Test
	public void testMowerUtilsCanMoveEast() {
		
		boolean result = MowerUtils.canMoveEast(null, null);
		
		assertFalse(result);
		
		result = MowerUtils.canMoveEast(null, null);
		
		assertFalse(result);
		
		result = MowerUtils.canMoveEast(TestUtils.TEST_COORDINATE_X, TestUtils.TEST_COLUMNS_BOARD);
		
		assertFalse(result);
		
		result = MowerUtils.canMoveEast(TestUtils.TEST_COORDINATE_X_VALUE_3, TestUtils.TEST_COLUMNS_BOARD);
		
		assertTrue(result);
		
	}
	
	@Test
	public void testMowerUtilsCanMoveWest() {
		
		boolean result = MowerUtils.canMoveWest(null);
		
		assertFalse(result);
		
		result = MowerUtils.canMoveSouth(TestUtils.TEST_COORDINATE_X_VALUE_0);
		
		assertFalse(result);
		
		result = MowerUtils.canMoveSouth(TestUtils.TEST_COORDINATE_X);
		
		assertTrue(result);
		
	}
	

}
