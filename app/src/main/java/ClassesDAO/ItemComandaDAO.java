/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesDAO;

import java.util.List;
import sistema_padaria.Classes.Comanda;
import sistema_padaria.Classes.ItemComanda;

/**
 *
 * @author Pedro
 */
public interface ItemComandaDAO {

    public List<ItemComanda> getAllItensComanda();
    public ItemComanda getItemComandaByID(int id);   
    public ItemComanda getItemComandaByIDComanda(int id);
   
    // public Comanda getProdutoByDesc(String comanda);
    public void updateItemComanda(ItemComanda comanda);

    public int insertItemComanda(ItemComanda itemComanda, int idComanda);

    public void deleteItemComanda(int id);
    public void deleteItemComandaByIDComanda(int idComanda);

}
