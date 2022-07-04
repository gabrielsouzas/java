import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


// Crie um textfield passando essa classe como parâmetro para que ele transforme tudo que for digitado em MAIUSCULO
public class UpperCaseField extends PlainDocument { 
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if (str == null) {
			return;
		}
		super.insertString(offs, str.toUpperCase(), a);
	}
}
/*
	Deixar maiuscula
	public static String removeAccents(String texto) {
   	texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
   	texto = texto.replaceAll("[^\\p{ASCII}]", "");   
   	return texto;  
   	}
   
   	Tirar acento
   	String texto2 = removeAccents(texto);
   
   	texto = Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")
   
 */