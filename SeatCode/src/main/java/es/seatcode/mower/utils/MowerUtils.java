package es.seatcode.mower.utils;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import es.seatcode.mower.domain.Board;
import es.seatcode.mower.domain.Cell;
import es.seatcode.mower.domain.Position;

public class MowerUtils {
		
	public static boolean canMoveNorth(Integer coordinateY, Integer rows) {
		if (Objects.nonNull(coordinateY) && Objects.nonNull(rows)) {
			return  coordinateY+1<=rows;
		}else {
			return false;
		}
	}
	
	public static boolean canMoveSouth(Integer coordinateY) {
		if (Objects.nonNull(coordinateY)) {
			return  coordinateY-1>=0;
		}else {
			return false;
		}
	}
	
	public static boolean canMoveEast(Integer coordinateX, Integer columns) {
		if (Objects.nonNull(coordinateX) && Objects.nonNull(columns)) {
			return  coordinateX+1<columns;
		}else {
			return false;
		}
	}
	
	public static boolean canMoveWest(Integer coordinateX) {
		if (Objects.nonNull(coordinateX)) {
			return  coordinateX-1>=0;
		}else {
			return false;
		}
	}
	
	public static boolean isValidPosition(Position position) {
		return Objects.nonNull(position) && Objects.nonNull(position.getCoordinateX()) && Objects.nonNull(position.getCoordinateY());
	}
	
	public static boolean isValidCell(Cell cell) {
		return Objects.nonNull(cell) && Objects.nonNull(cell.getPosition().getCoordinateX()) && Objects.nonNull(cell.getPosition().getCoordinateY());
	}
	
	public static boolean isValidBoard(Board board) {
		return Objects.nonNull(board) && Objects.nonNull(board.getColumns()) && Objects.nonNull(board.getRows());
	}
	
	public static boolean isValidString(String movement) {
		return StringUtils.isNotEmpty(movement);
		
	}
	
	public static String calculateNewCardinalPoint(String cardinalPointOld, String movement) {
		if (isValidString(cardinalPointOld)) {
	     	switch (cardinalPointOld) { 
		     	case "N":
		         	switch (movement) { 
			         	case "L":
			     			return "W";
			         	case "R":
			     			return "E";
			     		default:return "";
		         	}
		     	case "S":
		         	switch (movement) { 
			         	case "L":
			     			return "E";
			         	case "R":
			     			return "W";
			     		default:return "";
		         	}
		     	case "E":
		         	switch (movement) { 
			         	case "L":
			     			return "N";
			         	case "R":
			     			return "S";
			     		default:return "";
		         	}
		     	case "W":
		         	switch (movement) { 
			         	case "L":
			     			return "S";
			         	case "R":
			     			return "N";
			     		default:return "";
		         	}
			    default:
			    	return "";
	     	}
		}else {
			return StringUtils.EMPTY;
		}
	}

}
