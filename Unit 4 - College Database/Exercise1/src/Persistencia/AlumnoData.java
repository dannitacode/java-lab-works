package Persistencia;

import java.sql.*;
import java.util.Date;
import Logica.Alumno;
import javax.swing.JOptionPane;

/**
 *
 * @author dannita
 */
public class AlumnoData {

    public void ingresarAlumno(Alumno alumno) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "INSERT INTO alumno (dni, apellido, nombre, fecha_nacimiento, estado) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            java.sql.Date fechasql = new java.sql.Date(alumno.getFechaNacimiento().getTime());
            ps.setDate(4, fechasql);
            ps.setBoolean(5, alumno.isEstado());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Alumno agregado exitosamente.");
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo procesar la consulta.");
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

//    public void mostrarAlumnos() {
//        Connection conexion = null;
//        try {
//            conexion = DbConexion.establecerConexion();
//            String query = "SELECT * FROM alumno";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Alumno alumno = new Alumno(
//                        rs.getInt("dni"),
//                        rs.getString("apellido"),
//                        rs.getString("nombre"),
//                        rs.getDate("fecha_nacimiento")
//                );
//                alumno.setEstado(rs.getBoolean("estado"));
//                alumno.setIdAlumno(rs.getInt("id_alumno"));
//                System.out.println("Id alumno: " + alumno.getIdAlumno() + "\nDNI: " + alumno.getDni() + "\nNombre: " + alumno.getNombre() + "\nApellido: " + alumno.getApellido() + "\nFecha de nacimiento: " + alumno.getFechaNacimiento() + "\nEstado: " + (alumno.isEstado() ? "Activo" : "Inactivo"));
//            }
//        } catch (SQLException s) {
//            System.out.println("Error: No se pudo procesar la consulta.");
//            s.printStackTrace();
//        } finally {
//            if (conexion != null) {
//                try {
//                    conexion.close();
//                } catch (SQLException s) {
//                    s.printStackTrace();
//                }
//            }
//        }
//    }
//
    public boolean actualizarAlumno(int dni, String nombre, String apellido, Date fechaNac, int referencia) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "UPDATE alumno SET dni=?, nombre=?, apellido=?, fecha_nacimiento=? WHERE dni=?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            java.sql.Date fechasql = new java.sql.Date(fechaNac.getTime());
            ps.setDate(4, fechasql);
            ps.setInt(5, referencia);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Alumno actualizado exitosamente.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El DNI ingresado no apunta a ningun alumno. Intentelo nuevamente.");
                return false;
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo realizar la consulta.");
            s.printStackTrace();
            return false;
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
//
//    public Alumno buscarAlumno(int dni) {
//        Connection conexion = null;
//        Alumno alumno = null;
//        try {
//            conexion = DbConexion.establecerConexion();
//            String query = "SELECT * FROM alumno WHERE dni=?";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ps.setInt(1, dni);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                alumno = new Alumno(
//                        rs.getInt("dni"),
//                        rs.getString("apellido"),
//                        rs.getString("nombre"),
//                        rs.getDate("fecha_nacimiento").toLocalDate(),
//                        rs.getBoolean("estado")
//                );
//                alumno.setIdAlumno(rs.getInt("id_alumno"));
//                System.out.println("Alumno encontrado.");
////                System.out.println("Id alumno: " + alumno.getIdAlumno() + "\nDNI: " + alumno.getDni() + "\nNombre: " + alumno.getNombre() + "\nApellido: " + alumno.getApellido() + "\nFecha de nacimiento: " + alumno.getFechaNacimiento() + "\nEstado: " + (alumno.isEstado() ? "Activo" : "Inactivo"));
//            } else {
//                System.out.println("El alumno con ese DNI no fue encontrado.");
//            }
//        } catch (SQLException s) {
//            System.out.println("Error: No se pudo realizar la consulta.");
//            s.printStackTrace();
//        } finally {
//            if (conexion != null) {
//                try {
//                    conexion.close();
//                } catch (SQLException s) {
//                    s.printStackTrace();
//                }
//            }
//        }
//        return alumno;
//    }
//
//    public void bajaLogica(int dni) {
//        Connection conexion = null;
//        try {
//            conexion = DbConexion.establecerConexion();
//            String query = "UPDATE alumno SET estado=0 WHERE dni=?";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ps.setInt(1, dni);
//            int filas = ps.executeUpdate();
//            if (filas > 0) {
//                System.out.println("Alumno dado de baja exitosamente");
//            } else {
//                System.out.println("No existe un alumno con ese DNI.");
//            }
//        } catch (SQLException s) {
//            System.out.println("No se pudo procesar la consulta.");
//            s.printStackTrace();
//        } finally {
//            if (conexion != null) {
//                try {
//                    conexion.close();
//                } catch (SQLException s) {
//                    s.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public void altaLogica(int dni) {
//        Connection conexion = null;
//        try {
//            conexion = DbConexion.establecerConexion();
//            String query = "UPDATE alumno SET estado=1 WHERE dni=?";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ps.setInt(1, dni);
//            int filas = ps.executeUpdate();
//            if (filas > 0) {
//                System.out.println("Alumno dado de alta exitosamente");
//            } else {
//                System.out.println("No existe un alumno con ese DNI.");
//            }
//        } catch (SQLException s) {
//            System.out.println("No se pudo procesar la consulta.");
//            s.printStackTrace();
//        } finally {
//            if (conexion != null) {
//                try {
//                    conexion.close();
//                } catch (SQLException s) {
//                    s.printStackTrace();
//                }
//            }
//        }
//    }
//
    public boolean borrarAlumno(int id) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "DELETE FROM alumno WHERE id_alumno = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Alumno borrado exitosamente.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un alumno con ese ID.");
                return false;
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "No se pudo procesar la consulta.");
            s.printStackTrace();
            return false;
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
