/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassesDAO;

import java.util.List;
import sistema_padaria.Classes.Categoria;

/**
 *
 * @author Pedro
 */
public interface CategoriaDAO {

    public List<Categoria> getAllCategorias();

    public Categoria getCategoria(int id);

    public Categoria getCategoria(String descricao);

    public void updateCategoria(Categoria categoria);

    public int insertCategoria(Categoria categoria);

    public void deleteCategoria(int id);

}
