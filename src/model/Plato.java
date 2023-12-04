package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {

	private int id;
	private String nombre;
	private String descripcion;
	private double precio;
	private String imagen;
	private String localizacion;
	private String origen;
	private boolean baja;
	
}
