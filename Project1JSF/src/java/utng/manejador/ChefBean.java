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
import utng.modelo.Chef;

/**
 *
 * @author carlos arriaga
 */
@ManagedBean @SessionScoped
public class ChefBean implements Serializable {
    
    private List<Chef> chefs;
    private Chef chef;

public ChefBean(){
}

    public List<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(List<Chef> chefs) {
        this.chefs = chefs;
    }
    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

     public String listar(){
        ChefDAO dao =new ChefDAO();
        try{
            chefs= dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Chefs";
    }
      public String eliminar(){
        ChefDAO dao = new ChefDAO();
        try{
            dao.delete(chef);
           chefs = dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  "Eliminar";
        
        }
      
       public String iniciar(){
        chef = new Chef();
        return "Iniciar";
           
    }
    public String guardar(){
        ChefDAO dao = new ChefDAO();
        try{
            if(chef.getIdChef()!=0){
                dao.update(chef);
            }else{
                dao.insert(chef);
            }
            chefs = dao.getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Guardar";
    }
     public String cancelar(){
        return "Cancelar";
    }
    public String editar(Chef chef){
        this.chef = chef;
        return "Editar";
            }
}//final
