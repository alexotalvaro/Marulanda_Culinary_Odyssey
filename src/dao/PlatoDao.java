package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Conexion;
import model.Plato;

public class PlatoDao {

	private static Connection conexion;

	public static List<Plato> getPlatos() {
		List<Plato> platos = new ArrayList<>();

		try {
			conexion = Conexion.getConexion();
			if (conexion != null) {
				String query = "SELECT * FROM PLATO";
				PreparedStatement stmt = conexion.prepareStatement(query);
				stmt.execute();
				ResultSet resultSet = stmt.getResultSet();

				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nombre = resultSet.getString("nombre");
					String descripcion = resultSet.getString("descripcion");
					double precio = resultSet.getDouble("precio");
					String imagen = resultSet.getString("imagen");
					String localizacion = resultSet.getString("localizacion");
					String origen = resultSet.getString("origen");
					boolean baja= resultSet.getBoolean("baja");
					Plato plato = new Plato(id, nombre, descripcion, precio, imagen, localizacion, origen,baja);
					platos.add(plato);
				}

				stmt.close();
			} else {
				System.out.println("Conexion no realizada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			if (conexion != null) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return platos;

	}

	public static Plato getPlatoById(int idPlato) {
		Plato platoRecuperado = null;
		try {
			conexion = Conexion.getConexion();
			if (conexion != null) {
				String query = "SELECT * FROM PLATO WHERE ID='" + idPlato + "'";
				PreparedStatement stmt = conexion.prepareStatement(query);
				stmt.execute();
				ResultSet resultSet = stmt.getResultSet();

				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nombre = resultSet.getString("nombre");
					String descripcion = resultSet.getString("descripcion");
					double precio = resultSet.getDouble("precio");
					String imagen = resultSet.getString("imagen");
					String localizacion = resultSet.getString("localizacion");
					String origen = resultSet.getString("origen");
					boolean baja= resultSet.getBoolean("baja");
					platoRecuperado = new Plato(id, nombre, descripcion, precio, imagen, localizacion, origen,baja);
				}

				stmt.close();
			} else {
				System.out.println("Conexion no realizada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			if (conexion != null) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return platoRecuperado;

	}

	public static List<Plato> getPlatoByOrigen(String origenDelPlato) {
		List<Plato> lista = new ArrayList<>();
		Plato platoRecuperado = null;
		try {
			conexion = Conexion.getConexion();
			if (conexion != null) {
				String query = "SELECT * FROM PLATO WHERE LOCALIZACION='" + origenDelPlato + "'";
				PreparedStatement stmt = conexion.prepareStatement(query);
				stmt.execute();
				ResultSet resultSet = stmt.getResultSet();

				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String nombre = resultSet.getString("nombre");
					String descripcion = resultSet.getString("descripcion");
					double precio = resultSet.getDouble("precio");
					String imagen = resultSet.getString("imagen");
					String localizacion = resultSet.getString("localizacion");
					String origen = resultSet.getString("origen");
					boolean baja= resultSet.getBoolean("baja");
					platoRecuperado = new Plato(id, nombre, descripcion, precio, imagen, localizacion, origen,baja);
					lista.add(platoRecuperado);
				}

				stmt.close();
			} else {
				System.out.println("Conexion no realizada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			if (conexion != null) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		return lista;
	}

	public static boolean insertarPlato(Plato plato) {
		boolean insertado = false;		
		try {
			conexion = Conexion.getConexion();
			String query="INSERT INTO plato(nombre,descripcion,precio,imagen,localizacion,origen) VALUES(?,?,?,?,?,?)";
			PreparedStatement stmt=conexion.prepareStatement(query);
			stmt.setString(1, plato.getNombre());
			stmt.setString(2, plato.getDescripcion());
			stmt.setDouble(3, plato.getPrecio());
			stmt.setString(4, plato.getImagen());
			stmt.setString(5, plato.getLocalizacion());
			stmt.setString(6, plato.getOrigen());
			
			int filasInsertadas=stmt.executeUpdate();
			
			if(filasInsertadas > 0) {
				insertado=true;
			}
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			if (conexion != null) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return insertado;
	}
	
	public static boolean editarPlato(Plato plato) {
		boolean insertado = false;		
		try {
			conexion = Conexion.getConexion();
			String query="UPDATE plato SET nombre=?, descripcion=?, precio=?, imagen=?, localizacion=?, origen=? where id="+plato.getId();
			PreparedStatement stmt=conexion.prepareStatement(query);
			stmt.setString(1, plato.getNombre());
			stmt.setString(2, plato.getDescripcion());
			stmt.setDouble(3, plato.getPrecio());
			stmt.setString(4, plato.getImagen());
			stmt.setString(5, plato.getLocalizacion());
			stmt.setString(6, plato.getOrigen());
			
			int filasInsertadas=stmt.executeUpdate();
			
			if(filasInsertadas > 0) {
				insertado=true;
			}
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			if (conexion != null) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return insertado;
	}
	
	public static boolean bajaAltaLogica(Plato plato) {
		boolean insertado = false;		
		try {
			conexion = Conexion.getConexion();
			String query="UPDATE plato SET baja=? where id="+plato.getId();
			PreparedStatement stmt=conexion.prepareStatement(query);
			stmt.setBoolean(1, plato.isBaja());		
			int filasInsertadas=stmt.executeUpdate();
			
			if(filasInsertadas > 0) {
				insertado=true;
			}
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
			if (conexion != null) {
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return insertado;
	}
	
}
