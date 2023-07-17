package imd.prova2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import imd.prova2.model.ContaPalavras;
import imd.prova2.util.FraseVaziaException;

public class TelaContador extends JFrame{
	private JTextArea textoArea;
    private JTextArea resultadoArea;
    private ContaPalavras contador;
    
    public TelaContador() {
    	super("Contador de Palavras");

        contador = new ContaPalavras();

        setLayout(new BorderLayout());
        
        JLabel instrucaoLabel = new JLabel("Digite um texto aqui:");
        add(instrucaoLabel, BorderLayout.NORTH);
        
        textoArea = new JTextArea();
        add(new JScrollPane(textoArea), BorderLayout.CENTER);
        
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        add(new JScrollPane(resultadoArea), BorderLayout.SOUTH);
        
        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new FlowLayout());
        
        JButton submeterBotao = new JButton("Submeter");
        botoesPanel.add(submeterBotao);
        
        submeterBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submeterTexto();
            }
        });
        
        JButton limparBotao = new JButton("Limpar");
        limparBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparTexto();
            }
        });
        
        botoesPanel.add(limparBotao);
        
        add(botoesPanel, BorderLayout.EAST);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //sub
    private void submeterTexto() {
        try {
            String texto = textoArea.getText();
            contador.checarTexto(texto);
            Map<String, Integer> contagem = contador.contarPalavrasTexto(texto);
            resultadoArea.setText(contagem.toString().replaceAll("=", "\n"));
        } catch (FraseVaziaException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparTexto() {
        textoArea.setText("");
        resultadoArea.setText("");
    }

    public static void main(String[] args) {
        new TelaContador();
    }
}