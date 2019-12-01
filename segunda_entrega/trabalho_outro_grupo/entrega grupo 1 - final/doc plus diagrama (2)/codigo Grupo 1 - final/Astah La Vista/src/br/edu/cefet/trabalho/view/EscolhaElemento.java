package br.edu.cefet.trabalho.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EscolhaElemento extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 446320061287283260L;
	private JButton b1 = new JButton("Classe");
	private JButton b2 = new JButton("Interface");
	private JLabel pergunta = new JLabel("Escolha o tipo de elemento que quer adicionar ao diagrama: ");
	private JPanel painel = new JPanel();
	MenuView view;
	
	public EscolhaElemento(MenuView view) {
		
		this.view = view;
		
		setResizable(true);
		setLocationRelativeTo(null);
		setTitle("Escolher elemento");
		setVisible(true);
		setSize(400, 100);
		
		painel.setLayout(new GridLayout(1, 2));
		painel.add(b1);
		painel.add(b2);
		
		Container c = getContentPane();
		c.add(pergunta, BorderLayout.NORTH);
		c.add(painel, BorderLayout.SOUTH);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent eve) {
		if(eve.getSource() == b1) {
			new PropriedadesElemento("Propriedades da Classe", view);
			dispose();
		}
		
		if(eve.getSource() == b2) {
			new PropriedadesElemento("Propriedades da Interface", view);
			dispose();
		}
	}

	public JButton getB1() {
		return b1;
	}

	public JButton getB2() {
		return b2;
	}
	
}
