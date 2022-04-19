/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesDAO;

import java.util.List;
import sistema_padaria.Classes.UnidadeMedida;
import sistema_padaria.Classes.Usuario;

/**
 *
 * @author Pedro
 */
public interface UnidadeMedidaDAO {
    
    
     public List<UnidadeMedida> getAllUnidadesMedida();

    public UnidadeMedida getUnidadeMedidaByID(int id);

    public UnidadeMedida getUnidadeMedidaByDesc(String unidadeMedida);

    public void updateUnidadeMedida(UnidadeMedida unidadeMedida);

    public int insertUnidadeMedida(UnidadeMedida unidadeMedida);

    public void deleteUnidadeMedida(int id);
    
}
