/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrer.tpcustomerandrer.customerManager.ejb; // A MODIFIER suivant le paquetage de base... 

import com.andrer.tpcustomerandrer.entities.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Stateless
public class CustomerManager {

    /**
     * modification (ajout, suppression, consultation) table customer
     */
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public void persist(Customer customer) {
        em.persist(customer);
    }

    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");

        return query.getResultList();
    }

    public Customer update(Customer customer) {
        return em.merge(customer);
    }

public Customer findById(int idCustomer) {  
  return em.find(Customer.class, idCustomer);  
}

}