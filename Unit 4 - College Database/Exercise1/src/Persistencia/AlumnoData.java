package Persistencia;

import java.sql.*;
import Logica.Alumno;

/**
 *
 * @author dannita
 */
public class AlumnoData {

    /*
    Ingresar alumno-x
    Mostrar alumnos-x
    Actualizar alumno-x
    Buscar alumno-x
    Baja lógica de alumno-x
    Alta lógica de alumno-x
    Borrar alumno-x
     */
    public void ingresarAlumno(Alumno alumno) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "INSERT INTO alumno (dni, apellido, nombre, fecha_nacimiento, estado) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.getEstado());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Alumno agregado exitosamente.");
            }
        } catch (SQLException s) {
            System.out.println("Error: No se pudo procesar la consulta.");
            s.printStackTrace();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }
        }
    }

    public void mostrarAlumnos() {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "SELECT * FROM alumno";
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno(
                        rs.getInt("dni"),
                        rs.getString("apellido"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getBoolean("estado")
                );
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                System.out.println("Id alumno: " + alumno.getIdAlumno() + "\nDNI: " + alumno.getDni() + "\nNombre: " + alumno.getNombre() + "\nApellido: " + alumno.getApellido() + "\nFecha de nacimiento: " + alumno.getFechaNacimiento() + "\nEstado: " + (alumno.getEstado() ? "Activo" : "Inactivo"));
            }
        } catch (SQLException s) {
            System.out.println("Error: No se pudo procesar la consulta.");
            s.printStackTrace();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }
        }
    }

    public void actualizarAlumno(int dni, String apellido) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "UPDATE alumno SET apellido=? WHERE dni=?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, apellido);
            ps.setInt(2, dni);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Alumno actualizado exitosamente.");
            } else {
                System.out.println("No existe ese alumno con ese DNI.");
            }
        } catch (SQLException s) {
            System.out.println("Error: No se pudo realizar la consulta.");
            s.printStackTrace();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }
        }
    }

    public void buscarAlumno(int dni) {
        Connection conexion = null;
        Alumno alumno = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "SELECT * FROM alumno WHERE dni=?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno(
                        rs.getInt("dni"),
                        rs.getString("apellido"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getBoolean("estado")
                );
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                System.out.println("Alumno encontrado.");
                System.out.println("Id alumno: " + alumno.getIdAlumno() + "\nDNI: " + alumno.getDni() + "\nNombre: " + alumno.getNombre() + "\nApellido: " + alumno.getApellido() + "\nFecha de nacimiento: " + alumno.getFechaNacimiento() + "\nEstado: " + (alumno.getEstado() ? "Activo" : "Inactivo"));
            } else {
                System.out.println("El alumno con ese DNI no fue encontrado.");
            }
        } catch (SQLException s) {
            System.out.println("Error: No se pudo realizar la consulta.");
            s.printStackTrace();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }
        }
    }

    public void bajaLogica(int dni) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "UPDATE alumno SET estado=0 WHERE dni=?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, dni);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Alumno dado de baja exitosamente");
            } else {
                System.out.println("No existe un alumno con ese DNI.");
            }
        } catch (SQLException s) {
            System.out.println("No se pudo procesar la consulta.");
            s.printStackTrace();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }
        }
    }

    public void altaLogica(int dni) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "UPDATE alumno SET estado=1 WHERE dni=?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, dni);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Alumno dado de alta exitosamente");
            } else {
                System.out.println("No existe un alumno con ese DNI.");
            }
        } catch (SQLException s) {
            System.out.println("No se pudo procesar la consulta.");
            s.printStackTrace();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }
        }
    }

    public void borrarAlumno(int id) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "DELETE FROM alumno WHERE id_alumno = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Alumno borrado exitosamente.");
            } else {
                System.out.println("No se encontró un alumno con ese id.");
            }
        } catch (SQLException s) {
            System.out.println("No se pudo procesar la consulta.");
            s.printStackTrace();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }
        }
    }
}
