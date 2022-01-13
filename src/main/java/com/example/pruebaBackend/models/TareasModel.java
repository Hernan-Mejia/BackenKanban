package com.example.pruebaBackend.models;




import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tareas")
public class TareasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombreTarea")
    private String nombreTarea;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "idUsuario")
    private String id_Usuario;

    public String getIdUsuario() {
        return id_Usuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.id_Usuario = idUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
