/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.ChefDAO;
import utng.datos.RestauranteDAO;
import utng.modelo.Chef;
import utng.modelo.Restaurante;


/**
 *
 * @author carlos arriaga
 */
@ManagedBean(name = "restauranteBean")@SessionScoped
public class RestauranteBean implements Serializable{
    private List<Restaurante> restaurantes;
    private Restaurante restaurante;
    private List<Chef> chefs;
    public RestauranteBean(){
        restaurante = new Restaurante();
        restaurante.setChef(new Chef());
    } 

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(List<Chef> chefs) {
        this.chefs = chefs;
    }
    
     public String listar(){
        RestauranteDAO dao = new RestauranteDAO();
        try{
            restaurantes= dao.getAll();
        }catch(Exception e){ e.printStackTrace();}
        return "Restaurantes";
        }
     public String eliminar(){
        RestauranteDAO dao = new RestauranteDAO();
        try{
            dao.delete(restaurante);
            restaurantes = dao.getAll();
        }catch(Exception e){e.printStackTrace();}
        return "Eliminar";
        }
     public String iniciar(){
        
       restaurante = new Restaurante();
       restaurante.setChef(new Chef());
       try{
           chefs = new ChefDAO().getAll();
       }catch(Exception e){e.printStackTrace();}
       return "Iniciar";
       }
      public String guardar(){
        RestauranteDAO dao = new RestauranteDAO();
        try{ 
            if(restaurante.getIdRestaurante()!=0){
                dao.update(restaurante);
        }else{ dao.insert(restaurante);}
           
        }catch(Exception e){e.printStackTrace();
        } 
        restaurantes = dao.getAll();
        return "Guardar";
    }
      
    public String cancelar(){ return"Cancelar";}
    public String editar(Restaurante restaurante){
        this.restaurante = restaurante;
        try{
           chefs = new ChefDAO().getAll();
        }catch (Exception e){e.printStackTrace();}
        return "Editar";
    }
}//final
