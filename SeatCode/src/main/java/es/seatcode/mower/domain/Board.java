package es.seatcode.mower.domain;

import es.seatcode.mower.utils.MowerUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
	
	private Cell[][] elements;
	private Integer rows;
	private Integer columns;
	
	public void createBoard(Position upperRightCoordinates) {
		if (MowerUtils.isValidPosition(upperRightCoordinates)) {
			Integer coordinatesX=upperRightCoordinates.getCoordinateX();
			Integer coordinatesY=upperRightCoordinates.getCoordinateY();
			rows = coordinatesX+1;
			columns = coordinatesY+1;
			elements= new Cell[columns][rows];
			
			for (int y=coordinatesY;y>=0;y--){
				for (int x=0; x<=coordinatesX;x++){
					elements[y][x]=Cell.builder().cardinalPoint("").busy(Boolean.FALSE).position(Position.builder().coordinateX(y).coordinateY(x).build()).build();
				}
			}
		}
	}
	
	public void putMowers(Cell mower1, Cell mower2) {
		if (MowerUtils.isValidCell(mower1) && MowerUtils.isValidCell(mower2)) {
			elements[mower1.getPosition().getCoordinateX()][mower1.getPosition().getCoordinateY()]=mower1;
			elements[mower2.getPosition().getCoordinateX()][mower2.getPosition().getCoordinateY()]=mower2;
		}
	}
	
	public void resetCell(Cell cell) {
		if (MowerUtils.isValidCell(cell)) {
			elements[cell.getPosition().getCoordinateX()][cell.getPosition().getCoordinateY()]=cell;	
		}
	}
	
	public Cell getCell(Integer coordinateX, Integer coordinateY) {
		return elements[coordinateX][coordinateY];
	}
	
}
