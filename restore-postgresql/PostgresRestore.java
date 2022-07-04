
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.ArrayList;  
import java.util.List;  
import javax.swing.JOptionPane;

public class PostgresRestore {        
	
	// Caminho da instalação do gerenciador de banco de dados PostgreSQL >> Programa: pg_restore
    //public static String caminhoPostgreSQL = "C://Arquivos de programas//PostgreSQL//9.5//bin\\";
	public static String caminhoPostgreSQL = System.getenv("ProgramFiles")+"//PostgreSQL//9.5//bin\\";
	//public static String caminhoPostgreSQL = System.getenv("ProgramFiles")+" (x86)//PostgreSQL//9.5//bin\\";
	
	public static void realizaRestore(String caminho) throws IOException, InterruptedException{     
		final List<String> comandos = new ArrayList<String>();      
		comandos.add(caminhoPostgreSQL + "pg_restore.exe");
		//comandos.add("-i");      
		comandos.add("-h");      
		comandos.add("localhost");
		comandos.add("-p");      
		comandos.add("5432");      
		comandos.add("-U");      
		comandos.add("postgres");      
		comandos.add("-d"); 
		// Banco de dados
		comandos.add("NOME_DO_BANCO");
		comandos.add("-v");      
		comandos.add("\""+caminho+"\"");
		ProcessBuilder pb = new ProcessBuilder(comandos);      
		pb.environment().put("PGPASSWORD", "SUA_SENHA");     //Coloque sua senha         
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
			process.destroy(); 
			JOptionPane.showMessageDialog(null,"Carregamento realizado com sucesso.");  
		} catch (IOException e) {      
			e.printStackTrace();      
		} catch (InterruptedException ie) {      
			ie.printStackTrace();      
		}         
	}

	// Classe para teste
	public static void main(String[] args) {  
		try {  

			String cam = "CAMINHO_QUE_ESTA_O_BACKUP_PARA_O_RESTORE";

			PostgresRestore.realizaRestore(cam);           
		} catch (IOException e) {  
			e.printStackTrace();  
		} catch (InterruptedException e) {  
			e.printStackTrace();  
		}  
	}  
}
