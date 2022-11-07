package es.seatcode.mower.service.impl;

import es.seatcode.mower.domain.Board;
import es.seatcode.mower.domain.Cell;
import es.seatcode.mower.domain.Position;
import es.seatcode.mower.service.BoardService;
import es.seatcode.mower.utils.MowerUtils;

public class BoardServiceImpl implements BoardService {
	
	@Override
	public Board createBoard(Position upperRightCoordinates, Cell mower1, Cell mower2) {
		
		Board board = new Board();
		board.createBoard(upperRightCoordinates);
		board.putMowers(mower1, mower2);
		
		return board;
	}

	@Override
	public void resolveMovement(Board board, Cell cellMower1, String movementMower1, Cell cellMower2,String movementMower2) {
		if (isValidParameters(board,cellMower1,movementMower1,cellMower2,movementMower2)) {
			printResult(board, cellMower1, movementMower1);
			printResult(board, cellMower2, movementMower2);	
		}
	}
	
	private void printResult(Board board,Cell cell, String movementMower) {
		
		Cell newCell = cell;
		Integer rowsBoard = board.getRows();
		Integer columnsBoard = board.getColumns();
		
		for (char character: movementMower.toCharArray ()) {
			switch (character) { 
				case 'L':
					newCell.setCardinalPoint(MowerUtils.calculateNewCardinalPoint(newCell.getCardinalPoint(),"L"));
					board.resetCell(newCell);
			    break;
			    case 'R':
			    	newCell.setCardinalPoint(MowerUtils.calculateNewCardinalPoint(newCell.getCardinalPoint(),"R"));
					board.resetCell(newCell);
			    break;
			    default:
			    	String cardinalPoint = newCell.getCardinalPoint();
			    	Integer coordinateX = newCell.getPosition().getCoordinateX();
			    	Integer coordinateY = newCell.getPosition().getCoordinateY();
			    	Integer coordinateYUp = coordinateY+1;
			    	Integer coordinateYDown = coordinateY-1;
			    	Integer coordinateXUp = coordinateX+1;
			    	Integer coordinateXDown = coordinateX-1;

			     	switch (cardinalPoint) { 
			     		case "N":
			     			if (MowerUtils.canMoveNorth(coordinateX,rowsBoard) && !board.getCell(coordinateX, coordinateYUp).isCellBusy()) {
					     		board.resetCell(Cell.builder().busy(Boolean.FALSE).cardinalPoint("").position(Position.builder().coordinateX(coordinateX).coordinateY(coordinateY).build()).build());
					     		newCell = Cell.builder().busy(Boolean.TRUE).cardinalPoint("N").position(Position.builder().coordinateX(coordinateX).coordinateY(coordinateYUp).build()).build();
					     		board.resetCell(newCell);
			     			}
					     	break;
			     		case "S":
			     			if (MowerUtils.canMoveSouth(coordinateY) && !board.getCell(coordinateX, coordinateYDown).isCellBusy()) {
					     		board.resetCell(Cell.builder().busy(Boolean.FALSE).cardinalPoint("").position(Position.builder().coordinateX(coordinateX).coordinateY(coordinateY).build()).build());
					     		newCell = Cell.builder().busy(Boolean.TRUE).cardinalPoint("S").position(Position.builder().coordinateX(coordinateX).coordinateY(coordinateYDown).build()).build();
					     		board.resetCell(newCell);
			     			}
					     	break;
			     		case "E":
			     			if (MowerUtils.canMoveEast(coordinateX,columnsBoard) && !board.getCell(coordinateXUp, coordinateY).isCellBusy()) {
					     		board.resetCell(Cell.builder().busy(Boolean.FALSE).cardinalPoint("").position(Position.builder().coordinateX(coordinateX).coordinateY(coordinateY).build()).build());
					     		newCell = Cell.builder().busy(Boolean.TRUE).cardinalPoint("E").position(Position.builder().coordinateX(coordinateXUp).coordinateY(coordinateY).build()).build();
					     		board.resetCell(newCell);
			     			}
			     			break;
			     		case "W":
			     			if (MowerUtils.canMoveWest(coordinateX) && !board.getCell(coordinateXDown, coordinateY).isCellBusy()) {
					     		board.resetCell(Cell.builder().busy(Boolean.FALSE).cardinalPoint("").position(Position.builder().coordinateX(coordinateX).coordinateY(coordinateY).build()).build());
					     		newCell = Cell.builder().busy(Boolean.TRUE).cardinalPoint("W").position(Position.builder().coordinateX(coordinateXDown).coordinateY(coordinateY).build()).build();
					     		board.resetCell(newCell);
			     			}
			     			break;
					    default:
					    	throw new RuntimeException("Cardinal point unknown.");
			     	}
			  }
		}
		System.out.println(newCell.getPosition().getCoordinateX()+""+newCell.getPosition().getCoordinateY()+newCell.getCardinalPoint());
	}
	
	public boolean isValidParameters(Board board, Cell cellMower1, String movementMower1, Cell cellMower2,String movementMower2) {
		return MowerUtils.isValidCell(cellMower1) && MowerUtils.isValidCell(cellMower2) && MowerUtils.isValidBoard(board) && MowerUtils.isValidString(movementMower1) && MowerUtils.isValidString(movementMower2);
		
	}


}
