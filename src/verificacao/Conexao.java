/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificacao;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Cyber
 */
public class Conexao {
  private static final Logger LOG = Logger.getLogger(Conexao.class.getName());
  
  private static String  Host = "localhost";
  private static String  Basse = "teste";
  private static String  Name  = "postgres";
  private static String  Password = "postgres";
  private static Connection conexao = null;

    public static Connection getConecxao() {
        return conexao;
    }

    public static void setConexao(Connection conexao) {
        Conexao.conexao = conexao;
    }


    public static Connection getconexao()
    {
        if (Conexao.conexao == null)
        {
            return getConnection();
        }
        else 
            {
                return Conexao.conexao;
            }
    }
    
  public static Connection getConnection() 
  {
      Connection start = null;
      try
      {
            Class.forName("org.postgresql.Driver");
      }
      catch (ClassNotFoundException e)
              {
                  System.out.println(LOG+" "+e.getMessage());
              }
       try {
           
            start = DriverManager.getConnection("jdbc:postgresql://"+Host+":5432/"+Basse+"",Name, Password);
            Conexao.setConexao(start);
            return start;

        } catch (SQLException e) {
           System.out.println(LOG+" "+e.getMessage());
        }
        return null;
      
  }
   public static void main (String[] args) {
        
        Connection conn = Conexao.getconexao();
        System.out.println("Primeira Conexao : "+conn.toString());
       
    }
   
}
