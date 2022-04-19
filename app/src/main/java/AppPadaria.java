
import ClassesDAO.CategoriaDAO;
import ClassesDAO.CategoriaDAOImpl;
import ClassesDAO.ComandaDAO;
import ClassesDAO.ComandaDAOImpl;
import ClassesDAO.ItemComandaDAO;
import ClassesDAO.ItemComandaDAOImpl;
import ClassesDAO.MovimentoDAO;
import ClassesDAO.MovimentoDAOImpl;
import ClassesDAO.PerfilDAO;
import ClassesDAO.PerfilDAOImpl;
import ClassesDAO.ProdutosDAO;
import ClassesDAO.ProdutosDAOImpl;
import ClassesDAO.UnidadeMedidaDAO;
import ClassesDAO.UnidadeMedidaDAOImpl;
import ClassesDAO.UsuarioDAO;
import ClassesDAO.UsuarioDAOImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import sistema_padaria.Classes.Categoria;
import sistema_padaria.Classes.Comanda;
import sistema_padaria.Classes.ItemComanda;
import sistema_padaria.Classes.Perfil;
import sistema_padaria.Classes.Produtos;
import sistema_padaria.Classes.UnidadeMedida;
import sistema_padaria.Classes.Usuario;
import sistema_padaria.Classes.Movimento;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Pedro
 */
public class AppPadaria {

    public static void main(String[] args) throws Exception {

        /*Categoria cat = new Categoria();
        CategoriaDao catDao = new CategoriaDaoImpl();

        for (Categoria categoria : catDao.getAllCategorias()) {
            System.out.println("ID = " + categoria.getId() + "|" + " Descricao = " + categoria.getDescricao());
        }*/
 /*Categoria cat = new Categoria();
        cat.setDescricao("Categoria de teste");
         */
 /*CategoriaDAO catDao = new CategoriaDAOImpl();
        catDao.deleteCategoria(4);
         */
 /* Perfil perf =  new Perfil();
        perf.setDescricao("Gerente Regional");
        PerfilDAO perfDAO =  new PerfilDAOImpl();
        perfDAO.updatePerfil(perf, "Administrador");*/
 /*     Usuario user = new Usuario();
        UsuarioDAO userDAO = new UsuarioDAOImpl();

        user = userDAO.getUserByDesc("admin");
         */
//        ProdutosDAO produtoDAO = new ProdutosDAOImpl();

        /*  for(Produtos p  : produtoDAO.getAllProducts()){
            System.out.println("IDProduto = " + p.getIDProduto() + " | " + "Descricao = " + p.getDescricao()
                                + "Unidade de Medida = " + p.getUnidadeMedida().getDescricao() +  " | " + 
                                "Categoria = " + p.getCategoria().getDescricao() + " | " + " Codigo de Barras = " 
                                + p.getCodigoDeBarras() + " | " + "Quantidade = " + p.getQuantidade() + " | "
                                + "Quantidade Mínima = " + p.getQuantidadeMinima() + " | " + "Valor Unitário = " + p.getValorUnitario());
        }*/
 /* Produtos p =  new Produtos();
            p = produtoDAO.getProdutoByDesc("Pão Integral");
            if(p != null){
                Produtos produtoUpdate = new Produtos(p.getIDProduto(), p.getCategoria(), p.getUnidadeMedida(),"Cachorro Quente", "555", p.getQuantidade(), p.getQuantidadeMinima(), p.getValorUnitario());
                produtoDAO.updateProduto(produtoUpdate);
            }else{
                System.out.println("Produto não encontado");
            }
                Produtos p =  new Produtos();
            p = produtoDAO.getProdutoByDesc("Pão Integral");
            if(p != null){
                Produtos produtoUpdate = new Produtos(p.getIDProduto(), p.getCategoria(), p.getUnidadeMedida(),"Cachorro Quente", "555", p.getQuantidade(), p.getQuantidadeMinima(), p.getValorUnitario());
                produtoDAO.updateProduto(produtoUpdate);
            }else{
                System.out.println("Produto não encontado");
            }*/
 /* Produtos p =  new Produtos();
          Categoria c = new Categoria(2, "Alimentação");
          UnidadeMedida u =  new UnidadeMedida(1, "Litros");
          
          p.setDescricao("Pizza");
          p.setCategoria(c);
          p.setUnidadeMedida(u);
          p.setCodigoDeBarras("658");
          p.setQuantidadeMinima(8.2);
          p.setQuantidade(8.0);
          p.setValorUnitario(25.0);
          
          produtoDAO.insertProduto(p);
         */
 /*    ComandaDAO comandaDAO = new ComandaDAOImpl();
        Comanda c = new Comanda();
        c = comandaDAO.getComandaByID(1);
        if(c != null){
            Comanda comandaUpdate;
            Date data = new Date();
            comandaUpdate = new Comanda(c.getIDComanda(),data);
            comandaDAO.updateComanda(comandaUpdate);
        }else{
            System.out.println("Não foi possível inserir a comanda");
        }
           
        
    
    
    
        
        
        //System.out.println("IDComanda = " + c.getIDComanda() + " DataComanda = " + c.getDataComanda());

        /*  for(Comanda c : comandaDAO.getAllComandas()){
             System.out.println("IDComanda = "  + c.getIDComanda() + " DataComanda = " + c.getDataComanda());
         }
          
         */
        /*ItemComandaDAO itemComandaDAO = new ItemComandaDAOImpl();
        ItemComanda i =  new ItemComanda();
        i = itemComandaDAO.getItemComandaByIDComanda(2);
        System.out.println("IDItemCoamnda = "  + i.getIDItemComanda() + " | " + " Quantidade = " + i.getQuantidade()
                                + " | " + "Valor Unitáiro = " + " | " + i.getValorUnitario() + " | " + "IDProduto = " + i.getProduto().getIDProduto() + " | " + "Descricao Produto = " + i.getProduto().getDescricao());
        
       /* for(ItemComanda i : itemComandaDAO.getAllItensComanda()){
            
             System.out.println("IDItemCoamnda = "  + i.getIDItemComanda() + " | " + " Quantidade = " + i.getQuantidade()
                                + " | " + "Valor Unitáiro = " + " | " + i.getValorUnitario() + " | " + "IDProduto = " + i.getProduto().getIDProduto() + " | " + "Descricao Produto = " + i.getProduto().getDescricao());
         }
        }
*/  
      /*  ItemComandaDAO itemComandaDAO = new ItemComandaDAOImpl();
        ItemComanda i = new ItemComanda();
        i = itemComandaDAO.getItemComandaByID(1);
        if(i != null){
            ItemComanda comandaUpdate;
           
            comandaUpdate = new ItemComanda();
            comandaUpdate.setIDItemComanda(i.getIDItemComanda());
            comandaUpdate.setProduto(i.getProduto());
            comandaUpdate.setQuantidade(985.0);
            comandaUpdate.setValorUnitario(52.0);
            itemComandaDAO.updateItemComanda(comandaUpdate);
        }else{
            System.out.println("Não foi possível inserir a comanda");
        }*/
      
    /*  ItemComandaDAO itemComandaDAO = new ItemComandaDAOImpl();
      ItemComanda i = new ItemComanda();
      i.setQuantidade(100.0);
      i.setValorUnitario(500.0);
      Categoria c =  new Categoria(1, "Bebidas");
      UnidadeMedida u = new UnidadeMedida(1,"Litros"); 
      Produtos p = new Produtos(1, c, u, "Cachorro Quente", "555", 5.0, 1.0, 5.99);
      i.setProduto(p);
      itemComandaDAO.insertItemComanda(i);*/
    
    
    

  /*    Movimento m = new Movimento();
      MovimentoDAO movimentoDAO = new MovimentoDAOImpl();
      m = movimentoDAO.getMovimentoByID(3);
   
     
        Date date = new Date();
          Movimento mv = new Movimento();
          mv.setIDMovimento(m.getIDMovimento());
          mv.setTipo(m.getTipo());
          mv.setDescricao("TESTE DE LOJA"); 
          
          mv.setDataMovimento(date);
          mv.setUsuario(m.getUsuario());
          mv.setValor(m.getValor());
          movimentoDAO.insertMovimento(mv);
          
    
      
     /* CategoriaDAO categoriaDAO = new CategoriaDAOImpl();
      Categoria c = new Categoria();
       c =  categoriaDAO.getCategoria(1);
      if(c !=  null){
          
 
          Categoria categoriaUpdate = new Categoria();
          categoriaUpdate.setDescricao("Bebidas Quentes");
          categoriaUpdate.setIDCategoria(c.getIDCategoria());
          categoriaDAO.updateCategoria(categoriaUpdate);
          
          
      }else{
          System.out.println("Categoria não encontrada");
      }
      */
    /* ProdutosDAO prodDAO = new ProdutosDAOImpl();
      ItemComanda i =  new ItemComanda();
      i.setProduto(prodDAO.getProdutoByID(1));
      i.setQuantidade(230.0);
      i.setValorUnitario(1500.00);
      Comanda c =  new Comanda();
      Date data =  new Date();
      c.setDataComanda(data);
      c.addListComanda(i);
       ItemComanda ii =  new ItemComanda();
      ii.setProduto(prodDAO.getProdutoByID(1));
      ii.setQuantidade(120.0);
      ii.setValorUnitario(4320.00);
      c.addListComanda(ii);
      */
      ComandaDAO comandaDao = new ComandaDAOImpl();
      comandaDao.deleteComanda(20);
      
      
      
    }
      
        
      
    }

