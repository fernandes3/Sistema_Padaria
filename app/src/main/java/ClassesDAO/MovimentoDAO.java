/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesDAO;

import java.util.List;
import sistema_padaria.Classes.Comanda;
import sistema_padaria.Classes.Movimento;

/**
 *
 * @author Pedro
 */
public interface MovimentoDAO {
     
    public List<Movimento> getAllMovimentos();

    public Movimento getMovimentoByID(int id);

    public Movimento getMovimentoByDesc(String descricaoMovimento);

    public void updateMovimento(Movimento movimento);

    public int insertMovimento(Movimento movimento);

    public void deleteMovimento(int id);
}
