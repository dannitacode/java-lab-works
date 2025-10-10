package Persistencia;

import Logica.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dannita
 */
public class MateriaData {

    public void ingresarMateria(Materia materia) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "INSERT INTO materia (nombre, año, estado) VALUES (?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Materia agregada exitosamente.");
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

    public List<Materia> mostrarMateria() {
        Connection conexion = null;
        List<Materia> listaMaterias = new ArrayList<>();
        try {
            conexion = DbConexion.establecerConexion();
            String query = "SELECT * FROM materia";
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia(
                        rs.getString("nombre"),
                        rs.getInt("año")
                );
                materia.setEstado(rs.getBoolean("estado"));
                materia.setId(rs.getInt("id_materia"));
                listaMaterias.add(materia);
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
        return listaMaterias;
    }

    public boolean actualizarMateria(String nombre, int año, int id) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "UPDATE materia SET nombre=?, año=? WHERE id_materia=?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setInt(2, año);
            ps.setInt(3, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Materia actualizada exitosamente.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No existe esa materia con ese ID.");
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
            String query = "UPDATE materia SET estado=0 WHERE id_materia=?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Materia dada de baja exitosamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No existe una materia con ese ID.");
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
            String query = "UPDATE materia SET estado=1 WHERE id_materia=?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Materia dada de alta exitosamente");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No existe una materia con ese ID.");
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

    public boolean borrarMateria(int id) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "DELETE FROM materia WHERE id_materia = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Materia borrada exitosamente.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró una materia con ese ID.");
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
