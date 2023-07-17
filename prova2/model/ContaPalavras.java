package imd.prova2.model;

import java.util.HashMap;
import java.util.Map;

import imd.prova2.util.FraseVaziaException;

public class ContaPalavras {
	public void checarTexto(String txt) throws FraseVaziaException {
        if (txt == null || txt.trim().isEmpty()) {
            throw new FraseVaziaException("O texto não pode ser vazio!");
        }
    }
	
	public Map<String, Integer> contarPalavrasTexto(String txt) {
        Map<String, Integer> contagem = new HashMap<String, Integer>();
        
        String[] palavras = txt.split("\\W+");
        for (String palavra : palavras) {
            palavra = palavra.toLowerCase();
            int total = contagem.getOrDefault(palavra, 0);
            contagem.put(palavra, total + 1);
        }
        
        return contagem;
    }
}
