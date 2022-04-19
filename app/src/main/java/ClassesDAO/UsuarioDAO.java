/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesDAO;

import java.util.List;
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Usuario;

/**
 *
 * @author Pedro
 */
public interface UsuarioDAO {
    
    public List<Usuario> getAllUsers();

    public Usuario getUserById(int id);

    public Usuario getUserByDesc(String nomeUsuario);

    public void updateUser(Usuario user);

    public int insertUser(Usuario user);

    public void deleteUser(int id);

    
}
