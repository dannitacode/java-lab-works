package Persistencia;

import Logica.Materia;
import java.sql.*;
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

//    public void mostrarMateria() {
//        Connection conexion = null;
//        try {
//            conexion = DbConexion.establecerConexion();
//            String query = "SELECT * FROM materia";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Materia materia = new Materia(
//                        rs.getString("nombre"),
//                        rs.getInt("año")
//                );
//                materia.setEstado(rs.getBoolean("estado"));
//                materia.setId(rs.getInt("id_materia"));
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
//    public void actualizarMateria(int id, int año) {
//        Connection conexion = null;
//        try {
//            conexion = DbConexion.establecerConexion();
//            String query = "UPDATE materia SET año=? WHERE id=?";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ps.setInt(1, año);
//            ps.setInt(2, id);
//            int filas = ps.executeUpdate();
//            if (filas > 0) {
//                System.out.println("Materia actualizada exitosamente.");
//            } else {
//                System.out.println("No existe esa materia con ese ID.");
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
//    }
//
//    public void buscarMateria(int id) {
//        Connection conexion = null;
//        try {
//            conexion = DbConexion.establecerConexion();
//            String query = "SELECT * FROM materia WHERE id=?";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Materia materia = new Materia(
//                        rs.getString("nombre"),
//                        rs.getInt("año")
//                );
//                materia.setEstado(rs.getBoolean("estado"));
//                materia.setId(rs.getInt("id_materia"));
//                System.out.println("Materia encontrada.");
//            } else {
//                System.out.println("La materia con ese ID no fue encontrada.");
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
//    }
//
//    public void bajaLogica(int id) {
//        Connection conexion = null;
//        try {
//            conexion = DbConexion.establecerConexion();
//            String query = "UPDATE materia SET estado=0 WHERE id=?";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ps.setInt(1, id);
//            int filas = ps.executeUpdate();
//            if (filas > 0) {
//                System.out.println("Materia dada de baja exitosamente");
//            } else {
//                System.out.println("No existe una materia con ese ID.");
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
//    public void altaLogica(int id) {
//        Connection conexion = null;
//        try {
//            conexion = DbConexion.establecerConexion();
//            String query = "UPDATE materia SET estado=1 WHERE id=?";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ps.setInt(1, id);
//            int filas = ps.executeUpdate();
//            if (filas > 0) {
//                System.out.println("Materia dada de alta exitosamente");
//            } else {
//                System.out.println("No existe una materia con ese ID.");
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
//    public void borrarMateria(int id) {
//        Connection conexion = null;
//        try {
//            conexion = DbConexion.establecerConexion();
//            String query = "DELETE FROM materia WHERE id_materia = ?";
//            PreparedStatement ps = conexion.prepareStatement(query);
//            ps.setInt(1, id);
//            int filas = ps.executeUpdate();
//            if (filas > 0) {
//                System.out.println("Materia borrada exitosamente.");
//            } else {
//                System.out.println("No se encontró una materia con ese ID.");
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
}
