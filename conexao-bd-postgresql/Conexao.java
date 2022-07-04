package SEU_PACOTE;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class Conexao {
 
   //Nome do usu�rio do postgreSQL
   private static final String USERNAME = "postgres";
 
   //Senha do postgreSQL
   private static final String PASSWORD = "coloque_a_senha_aqui";
 
   //Dados de caminho, porta e nome da base de dados que ir� ser feita a conex�o
   private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/coloque_o_nome_do_banco_aqui";
   
   // Pela Rede
   //private static final String DATABASE_URL = "jdbc:postgresql://IP_DA_MAQUINA:5432/coloque_o_nome_do_banco_aqui";
   
   public static Connection createConnectionToPostgreSQL() throws Exception{
      Class.forName("org.postgresql.Driver"); //Faz com que a classe seja carregada pela JVM
 
      //Cria a conex�o com o banco de dados
      Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
 
      //Retorna a conex�o para uso
      return connection;
   }
   
   //Execute as linhas abaixo apenas para teste de conex�o, e comente as em seguida
   public static void main(String[] args) throws Exception{
 
      //Recupera uma conex�o com o banco de dados
      Connection con = createConnectionToPostgreSQL();
 
      //Testa se a conex�o � nula
      if(con != null){
         System.out.println("Conex�o obtida com sucesso!" + con);
         con.close();
      }
 
   }
}