package es.seatcode.mower.utils;

import es.seatcode.mower.domain.Board;
import es.seatcode.mower.domain.Cell;
import es.seatcode.mower.domain.Position;

public abstract class TestUtils {
	
	public static final String TEST_MOVEMENT = "LRRRL";
	
	public static final Integer TEST_COORDINATE_X = 5;
	
	public static final Integer TEST_COORDINATE_Y = 5;
	
	public static final Integer TEST_COORDINATE_X_VALUE_3 = 3;
	
	public static final Integer TEST_COORDINATE_Y_VALUE_3 = 3;
	
	public static final Integer TEST_COORDINATE_X_VALUE_0 = 0;
	
	public static final Integer TEST_COORDINATE_Y_VALUE_0 = 0;
	
	public static final Integer TEST_ROWS_BOARD = 5;
	
	public static final Integer TEST_COLUMNS_BOARD = 5;
	
	private static final String TEST_CARDINAL_POINT_NORTH = "N";
	
	public static final Position TEST_POSITION = Position.builder().coordinateX(TEST_COORDINATE_X).coordinateY(TEST_COORDINATE_Y).build();
	
	public static final Position TEST_POSITION_2 = Position.builder().coordinateX(TEST_COORDINATE_X_VALUE_3).coordinateY(TEST_COORDINATE_Y_VALUE_3).build();
	
	public static final Position TEST_POSITION_3 = Position.builder().coordinateX(TEST_COORDINATE_X_VALUE_0).coordinateY(TEST_COORDINATE_Y_VALUE_0).build();

	public static final Cell TEST_CELL = Cell.builder().position(TEST_POSITION).build();
	
	public static final Cell TEST_CELL_2 = Cell.builder().busy(Boolean.TRUE).cardinalPoint(TEST_CARDINAL_POINT_NORTH).position(TEST_POSITION_2).build();
	
	public static final Cell TEST_CELL_3 = Cell.builder().busy(Boolean.TRUE).cardinalPoint(TEST_CARDINAL_POINT_NORTH).position(TEST_POSITION_3).build();
	
	private static final Cell[][] TEST_ARRAY_CELL = new Cell[TEST_COLUMNS_BOARD][TEST_ROWS_BOARD]; 
	
	public static final Board TEST_BOARD = Board.builder().columns(TEST_COLUMNS_BOARD).rows(TEST_ROWS_BOARD).elements(TEST_ARRAY_CELL).build();




}
