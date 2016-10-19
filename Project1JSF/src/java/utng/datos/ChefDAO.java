/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Chef;

/**
 *
 * @author carlos arriaga
 */
public class ChefDAO extends DAO<Chef>{
    public ChefDAO(){
        super(new Chef());
    }
     public Chef getOneById(Chef chef)
            throws HibernateException{
        return super.getOneById(chef.getIdChef());
    }
}//final
