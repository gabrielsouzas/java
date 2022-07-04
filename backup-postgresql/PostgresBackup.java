import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PostgresBackup {
	
	// Caminho da instalação do gerenciador de banco de dados PostgreSQL >> Programa: pg_dump
	//public static String caminhoPostgreSQL = "C://Arquivos de programas//PostgreSQL//9.5//bin\\";
	public static String caminhoPostgreSQL = System.getenv("ProgramFiles")+"//PostgreSQL//9.5//bin\\";
	//public static String caminhoPostgreSQL = System.getenv("ProgramFiles")+" (x86)//PostgreSQL//9.5//bin\\";
	
	public static void realizaBackup(String caminho) throws IOException, InterruptedException{    
       final List<String> comandos = new ArrayList<String>();    
      
      comandos.add(caminhoPostgreSQL + "pg_dump.exe");  
       //comandos.add("-i");    
       comandos.add("-h");    
       comandos.add("localhost");    
       comandos.add("-p");    
       comandos.add("5432");    
       comandos.add("-U");    
       comandos.add("postgres");    
       comandos.add("-F");    
       comandos.add("c");    
       comandos.add("-b");    
       comandos.add("-v");    
       comandos.add("-f");
       comandos.add(caminho);
       // Se quiser fazer backup apenas de uma tabela descomente essas duas linhas a seguir
       // comandos.add("-t");
       // comandos.add("NOME_TABELA");
       // Banco de Dados
       comandos.add("NOME_BANCO_DE_DADOS");
              
       ProcessBuilder pb = new ProcessBuilder(comandos);    
       pb.environment().put("PGPASSWORD", "COLOQUE_A_SENHA");            
       try {    
           final Process process = pb.start();    
           final BufferedReader r = new BufferedReader(    
               new InputStreamReader(process.getErrorStream()));    
           String line = r.readLine();    
           while (line != null) {    
           System.err.println(line);    
           line = r.readLine();    
           }    
           r.close();    
           process.waitFor();
           // Mensagem para verificar se deu certo
           System.out.println("Backup realizado com sucesso.");
       } catch (IOException e) {    
           e.printStackTrace();    
       } catch (InterruptedException ie) {    
           ie.printStackTrace();    
       }       
   }  	
	// Classe para testes
	public static void main(String[] args) {
		try {
			String cam = "CAMINHO_DO_BACKUP";
			PostgresBackup.realizaBackup(cam);			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
