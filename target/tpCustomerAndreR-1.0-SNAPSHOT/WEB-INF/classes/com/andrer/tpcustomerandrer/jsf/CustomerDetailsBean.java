package com.andrer.tpcustomerandrer.jsf;
import com.andrer.tpcustomerandrer.customerManager.ejb.CustomerManager;
import com.andrer.tpcustomerandrer.entities.Customer;
import java.io.Serializable;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
//import com.andrer.tpcustomerandrer.customerManager.ejb.CustomerManager;
import com.andrer.tpcustomerandrer.discountManager.ejb.DiscountManager;
import com.andrer.tpcustomerandrer.entities.Discount;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import java.util.List;

/**
 * Backing bean pour la page customerDetails.xhtml.
 */
@Named
@ViewScoped
public class CustomerDetailsBean implements Serializable {
  private int idCustomer;
  private Customer customer;

  @EJB
  private DiscountManager discountManager;
  
  @EJB
  private CustomerManager customerManager ;

  public int getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(int idCustomer) {
    this.idCustomer = idCustomer;
  }

  /**
   * Retourne les détails du client courant (contenu dans l'attribut customer de
   * cette classe).
     * @return 
   */
    public Customer getCustomer() {
      return customer;
    }

  /**
   * Action handler - met à jour dans la base de données les données du client
   * contenu dans la variable d'instance customer.
   * @return la prochaine page à afficher, celle qui affiche la liste des clients.
   */
    
  public String update() {
    // Modifie la base de données.
    // Il faut affecter à customer (sera expliqué dans le cours).
    customer = customerManager.update(customer);
    return "customerList";
  }

  public void loadCustomer() {
    this.customer = customerManager.findById(idCustomer);
  }
    public List<Discount> getDiscounts() {
    return discountManager.getAllDiscounts();
  }
}

/**
 *
 * @author Nirina
 */
