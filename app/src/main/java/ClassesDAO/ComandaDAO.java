/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesDAO;

import java.util.List;
import sistema_padaria.Classes.Comanda;
import sistema_padaria.Classes.Produtos;

/**
 *
 * @author Pedro
 */
public interface ComandaDAO {
    
    public List<Comanda> getAllComandas();

    public Comanda getComandaByID(int id);

   // public Comanda getProdutoByDesc(String comanda);

    public void updateComanda(Comanda comanda);

    public int insertComanda(Comanda comanda);

    public void deleteComanda(int id);
    
}
