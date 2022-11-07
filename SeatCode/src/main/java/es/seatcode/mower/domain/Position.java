package es.seatcode.mower.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Position {
	
	private Integer coordinateX;
	private Integer coordinateY;

}
