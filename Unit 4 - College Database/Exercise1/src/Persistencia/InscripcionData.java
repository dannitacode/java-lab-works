package Persistencia;

import Logica.Alumno;
import Logica.Inscripcion;
import Logica.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dannita
 */
public class InscripcionData {
    
    private AlumnoData alumnoData;
    private MateriaData materiaData;

    public InscripcionData(AlumnoData idAlumno, MateriaData idMateria) {
        this.alumnoData = idAlumno;
        this.materiaData = idMateria;
    }
    
    public void inscribirAlumno(Alumno alumno, Materia materia) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "INSERT INTO inscripcion (id_alumno, id_materia, nota) VALUES (?,?,0)";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, alumno.getIdAlumno());
            ps.setInt(2, materia.getId());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Alumno inscripto exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Los valores son incorrectos. No se pudo ejecutar la inscripcion.");
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "No se pudo procesar la consulta.");
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
    }
    
    public void anularInscripcion(int id) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "DELETE FROM inscripcion WHERE id_inscripto = ?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Alumno desinscripto existosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el id del inscripto correspondiente al alumno.");
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "No se pudo procesar la consulta");
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
    }
    
    public List<Inscripcion> listaInscripciones() {
        Connection conexion = null;
        List<Inscripcion> listaInscriptos = new ArrayList<>();
        int idAlumno = 0;
        int idMateria = 0;
        int nota = 0;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "SELECT * FROM inscripcion";
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idAlumno = rs.getInt("id_alumno");
                Alumno alumno = alumnoData.buscarAlumno(idAlumno);
                idMateria = rs.getInt("id_materia");
                Materia materia = materiaData.buscarMateria(idMateria);
                nota = rs.getInt("nota");
                Inscripcion inscripcion = new Inscripcion(
                        alumno,
                        materia,
                        nota
                );
                inscripcion.setId(rs.getInt("id_inscripto"));
                listaInscriptos.add(inscripcion);
            }            
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "No se pudo procesar la consulta.");
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
        return listaInscriptos;
    }
    
    public void cargarNotas(int id, int nota) {
        Connection conexion = null;
        try {
            conexion = DbConexion.establecerConexion();
            String query = "UPDATE inscripcion SET nota=? WHERE id_inscripto=?";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, nota);
            ps.setInt(2, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Se ha cargado la nota exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar el id señalado del inscripto.");
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "No se pudo procesar la consulta.");
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
    }
}
