/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesDAO;

import java.util.List;
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Perfil;

/**
 *
 * @author Pedro
 */
public interface PerfilDAO {
    
    
    public List<Perfil> getAllPerfis();

    public Perfil getPerfilByID(int id);

    public Perfil getPerfilByDesc(String descricao);

    public void updatePerfil(Perfil perfil, String Descricao);

    public int insertPerfil(Perfil perfil);

    public void deletePerfil(int id);

    
}
