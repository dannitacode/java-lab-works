package Persistencia;

import java.sql.*;
import java.util.Date;
import Logica.Alumno;
import java.util.ArrayList;
import java.util.List;
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

    public List<Alumno> mostrarAlumnos() {
        Connection conexion = null;
        List<Alumno> listaAlumnos = new ArrayList<>();
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
                        rs.getDate("fecha_nacimiento")
                );
                alumno.setEstado(rs.getBoolean("estado"));
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                listaAlumnos.add(alumno);
            }
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo procesar la consulta.");
            ex.getMessage();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException s) {
                    s.getMessage();
                }
            }
        }
        return listaAlumnos;
    }

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
    
    public boolean bajaLogica(int id) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "UPDATE alumno SET estado=0 WHERE id_alumno=?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Alumno dado de baja exitosamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No existe un alumno con ese ID.");
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

    public boolean altaLogica(int id) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "UPDATE alumno SET estado=1 WHERE id_alumno=?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Alumno dado de alta exitosamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No existe un alumno con ese ID.");
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
    
    public Alumno buscarAlumno(int id) {
        Alumno alumno = null;
        Connection conexion = null;
        String query = "SELECT * FROM alumno WHERE id_alumno=?";
        try {
            conexion = DbConexion.establecerConexion();
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno(
                        rs.getInt("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDate("fecha_nacimiento")
                );
                alumno.setEstado(rs.getBoolean("estado"));
                alumno.setIdAlumno(rs.getInt("id_alumno"));
//                JOptionPane.showMessageDialog(null, "Alumno encontrado: " + alumno.getNombre() + " " + alumno.getApellido());
            } else {
//                JOptionPane.showMessageDialog(null, "No se encontro al alumno con el ID " + id);
            }
        } catch (SQLException s) {
            s.getMessage();
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException s) {
                    s.getMessage();
                }
            }
        }
        return alumno;
    }
}
