/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Ver_carro;
import Entity.Ver_pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import verificacao.Conexao;

/**
 *
 * @author Cyber
 */
public class Ver_PessoaDAO {
    private static final Logger LOG = Logger.getLogger(Ver_PessoaDAO.class.getName());
    
  public List<Ver_pessoa> SelecionaTodosPessao()
  {
      Connection conn = Conexao.getconexao();
           
        String sql = "SELECT * FROM pessoa p";
        
        try 
        {   
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            List<Ver_pessoa> pessoas = new ArrayList<>();
            
            while (rs.next()) 
            {    
                Ver_pessoa p = new Ver_pessoa();
                p.setCPF(rs.getInt("CPF"));
                p.setNome(rs.getString("Nome"));
                p.setData_Nascimento(rs.getString("Data_Nascimento"));
                p.setSexo(rs.getString("Sexo"));
                System.out.println("certo :"+p.toString());
                pessoas.add(p);
            }
//            conn.close();
            stmt.close();
            return pessoas;
            
        } catch (SQLException e) {
            System.out.println(LOG+" "+e.getMessage());
            return null;
        }
      }
  
  
     public boolean cadastrarPessoa(Ver_pessoa p) throws SQLException {

   
            String sql = "INSERT INTO pessoa (nome,cpf,data_nascimento,sexo) VALUES (?, ? ,? ,? ) ";
            
            PreparedStatement pstmt =  Conexao.getconexao().prepareStatement(sql);
            
            pstmt.setString(1, p.getNome());
            pstmt.setInt(2, p.getCPF());
            pstmt.setString(3, p.getData_Nascimento());
            pstmt.setString(4, p.getSexo());
           
            System.out.println("estou aqui");
            if (pstmt.executeUpdate() == 1) {
                return true;
            }
            return false;
        }
     
     public boolean Alterapessoa(Ver_pessoa obj) throws SQLException
    {
//      nome,cpf,data_nascimento,sexo
             try 
        {
            String sql = " UPDATE pessoa "
                       + "    SET nome = ?, "
                       + "         data_nascimento = ?, "
                       + "        sexo = ? "
                       + "  WHERE cpf = ? ";

            PreparedStatement pstmt = Conexao.getconexao().prepareStatement(sql);
            
            pstmt.setString(1, obj.getNome());
            pstmt.setString(2, obj.getData_Nascimento());
            pstmt.setString(3, obj.getSexo());
            pstmt.setInt(4, obj.getCPF());
            
            System.out.println("Altera : "+obj.getCPF());

            if (pstmt.executeUpdate() == 1) {
                return true;
            }
            return false;
            
        } catch(SQLException e) {
            System.out.println(LOG+" "+e.getMessage());
            return false;
        }
    }
     
//     public List<Ver_pessoa> novaListagem() {
//     
//         try {
//         
//            Connection conn = Conexao.getconexao();
//
//            String sql = "SELECT * FROM pessoa ";
//
//            Statement stmt = conn.createStatement();
//
//            ResultSet rs = stmt.executeQuery(sql);
//
//            List<Ver_pessoa> pessoas = new ArrayList<>();
//            
//            int cont =0;
//                while(rs.next()) {
//		cont++;
//                }
//                    
//            while(rs.next()){
//                Ver_pessoa pes = new Ver_pessoa();
//                for(int i =0; i < rs.getMetaData().getColumnCount()-1;i++ ){
//                    System.out.println(rs.getString(i));
//                }
//                            
//   //             System.out.println("pessoa : "+rs.getString("nome"));
//              }
//         
//            System.out.println(pessoas.toString());
//         
//         return pessoas;
//         
//         } catch (SQLException e) {
//         
//             System.out.println("erro: "+e.getMessage());
//         }
//         return null;
//         
//     }
//      
       public List<Ver_pessoa> Listar() {
          Connection conn = Conexao.getConnection();
           
            String sql = "SELECT * FROM pessoa";
        try 
        {         
            Statement stmt  = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs    = stmt.executeQuery(sql);
            List<Ver_pessoa> pessoas = new ArrayList<>();
            
//            System.out.println(rs.first());
            
            while(rs.next())
                   {
                       Ver_pessoa pessoa = new Ver_pessoa();
                       pessoa.setNome(rs.getString("nome"));
                       pessoa.setCPF(rs.getInt("cpf"));
                       System.out.println("verificacao :"+pessoa);
                       
                       pessoas.add(pessoa);
                       pessoa = null; 
                      
                   }
//            conn.close();

            stmt.close();
            
            System.out.println("vamos ver o retorno: " +pessoas);
            return pessoas;
            
        } catch (SQLException e) {
            System.out.println(LOG+" "+e.getMessage());
            return null;
        }
    }
       
       public static void main (String[] args){
       
           List<Ver_pessoa> pessoas = new ArrayList<>();
           
           Ver_PessoaDAO pdao = new Ver_PessoaDAO();
          pessoas = pdao.Listar();
           
//           for (Pessoa  pe : pessoas) {
//       
//               System.out.println("pessoa: "+pe.getNome());
//               
//            }
           
       } 
     
     
  }
    
    

