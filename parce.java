package parcelas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class parce extends JPanel{
	private JButton btcalculo,btcancelar;
	private JTextField tfpre, tfDesco,tfjuros,tfparcelas;
	private JScrollPane spLista;
	private JList liparce; 
	private JLabel lbpre,lbjuros,lbparcelas;
	
	public parce(){
		inicializarComponentes();
		definirEventos();
}private void inicializarComponentes() {
	setLayout(null); 
	String[] lijurosItens= {"À vista","12x","24x","36x","48x"};
	btcalculo = new JButton("Consultar");
	btcancelar = new JButton("Cancelar");
	lbpre = new JLabel("Valor");
	lbjuros = new JLabel("Valor Final");
	lbparcelas = new JLabel("Parcelas");
	tfpre = new JTextField(5);
	tfparcelas = new JTextField(5);
	tfjuros = new JTextField(5);
	liparce = new JList(lijurosItens);
	spLista = new JScrollPane(liparce);
	lbpre.setBounds(35,90,100,25);
	tfpre.setBounds(35,110,100,25);
	spLista.setBounds(35,30,100,55);
	btcalculo.setBounds(35,150,90,25);
	btcancelar.setBounds(35,200,90,25);
	lbjuros.setBounds(375,5,90,25);
	tfjuros.setBounds(375,30,100,25);
	tfparcelas.setBounds(200,30,100,25);
	lbparcelas.setBounds(200,5,100,25);
	add(btcalculo);
	add(btcancelar);
	add(lbjuros);
	add(lbparcelas);
	add(tfparcelas);
	add(lbpre);
	add(tfpre);
	add(spLista);
	add(tfjuros);
	}

	 private void definirEventos() {
		 
		 btcalculo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					if(tfpre.getText().equals("")){
						tfpre.requestFocus();
						return;
					}
					float valor = Float.parseFloat(tfpre.getText());
					if(liparce.getSelectedIndex()==-1){
						JOptionPane.showMessageDialog(null,"Selecione um item da lista: ");
						return;
					}
					float desconto = 0f;
					if(liparce.getSelectedIndex()==0){
					
					
					tfjuros.setText(""+ (valor - valor*0.05));
					tfjuros.setEditable(false); 
					}
					float juros= 0f ;
					
					if(liparce.getSelectedIndex()==1){
						juros = 0.03f;
						tfjuros.setEditable(false);
						tfjuros.setText(""+(valor + valor*juros*12));
						tfparcelas.setEditable(false);
						tfparcelas.setText(""+(valor + valor*juros));
					}
					if(liparce.getSelectedIndex()==2){
						juros = 0.05f;
						tfjuros.setEditable(false);
						tfjuros.setText(""+(valor+ valor*juros*24));
					}
					if(liparce.getSelectedIndex()==3){
						juros = 0.10f;
						tfjuros.setEditable(false);
						tfjuros.setText(""+(valor + valor*juros*36));
					}
					if(liparce.getSelectedIndex()==4){
						juros = 0.15f;
						tfjuros.setEditable(false);
						tfjuros.setText(""+(valor + valor*juros*48));
					}
				
					}
				
			});
		 btcancelar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					System.exit(0);
					}
				});
		 
}
		 public static void main(String args[]){
		 		JFrame frame = new JFrame("Consultar");
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(new parce());
				 frame.setBounds(300,300,500,300);
				 frame.setVisible(true);
		 }
}


