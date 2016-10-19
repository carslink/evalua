/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Restaurante;

/**
 *
 * @author carlos arriaga
 */
public class RestauranteDAO extends DAO<Restaurante>{
    public RestauranteDAO(){
        super (new Restaurante());
    }
    
    public Restaurante getOneById(Restaurante restaurante)
            throws HibernateException{
        return super.getOneById(restaurante.getIdRestaurante());
    }
     
}//final
