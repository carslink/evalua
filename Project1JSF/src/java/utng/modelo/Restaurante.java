/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author carlos arriaga esesteeeeeeeeee
 */
@Entity
@Table(name = "restaurante")
public class Restaurante implements Serializable{
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
  @Column(name = "id_restaurante")
    private Long idRestaurante;
    @Column(name = "nombre_restaurante", length = 10)
    private String nombreRestaurante;
    @Column(length = 15)
    private String telefono;
    @Column(length = 15)
     private String descripcion;
   
    @ManyToOne
    @JoinColumn(name = "id_chef")
    private Chef chef;

    public Restaurante(Long idRestaurante, String nombreRestaurante, String telefono, String descripcion, Chef chef) {
        this.idRestaurante = idRestaurante;
        this.nombreRestaurante = nombreRestaurante;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.chef = chef;
    }
    
     public Restaurante() {
        this.idRestaurante = 0L;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }
    
     
}//final
