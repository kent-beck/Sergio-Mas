package es.seatcode.mower.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cell {
	
	private Boolean busy;
	private String cardinalPoint;
	private Position position;
	
	public boolean isCellBusy() {
		return busy;
	}
	
	@Override
    public boolean equals(Object o){
		if(o instanceof Cell){
        	 Cell cell = (Cell) o;
              return this.position.getCoordinateX().equals(cell.getPosition().getCoordinateX()) &&  this.position.getCoordinateY().equals(cell.getPosition().getCoordinateY());
        } else
        return false;
    }
	 

	
	

	
	

}
