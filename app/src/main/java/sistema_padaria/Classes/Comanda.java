/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_padaria.Classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Pedro
 */
public class Comanda {
    private int IDComanda;
    private ArrayList<ItemComanda> ItensComanda = new ArrayList<ItemComanda>();
  
    private Date DataComanda;

    public Comanda(int IDComanda, ArrayList<ItemComanda> ItensComanda, Date DataComanda) {
        this.IDComanda = IDComanda;
        this.ItensComanda = ItensComanda;
        this.DataComanda = DataComanda;
    }
    
    public Comanda(){}

    public Comanda(int idComanda, Date DataComanda) {
      this.IDComanda = idComanda;
      this.DataComanda = DataComanda;
    }

    public int getIDComanda() {
        return IDComanda;
    }

    public void setIDComanda(int IDComanda) {
        this.IDComanda = IDComanda;
    }

    public ArrayList<ItemComanda> getItensComanda() {
        return ItensComanda;
    }

    public void setItensComanda(ArrayList<ItemComanda> ItensComanda) {
        this.ItensComanda = ItensComanda;
    }



    public Date getDataComanda() {
        return DataComanda;
    }

    public void setDataComanda(Date DataComanda) {
        this.DataComanda = DataComanda;
    }
    
    
    public void addListComanda(ItemComanda item){
       this.ItensComanda.add(item);
    }
    
}
