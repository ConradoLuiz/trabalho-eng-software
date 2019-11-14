package br.edu.cefet.trabalho.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.LineBorder;

import br.edu.cefet.trabalho.controller.DiagramCreationController;
import br.edu.cefet.trabalho.controller.Save_Load;

public class MenuView extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 7526472295622776147L;
	
	private JTextArea texto = new JTextArea();
	private JPanel botoes = new JPanel();
	private JPanel painel = new JPanel();
	private JButton b1 = new JButton("Criar diagrama");
	private JButton b2 = new JButton("Salvar diagrama");
	private JButton b3 = new JButton("Abrir diagrama");
	private JButton b4 = new JButton("Criar elemento");
	private JButton b5 = new JButton("Criar relacionamento");
	private JButton b6 = new JButton("Desfazer");
	private JButton b7 = new JButton("Fechar");
	private JLabel status = new JLabel();
	private JScrollPane scroll = new JScrollPane(texto);
	private JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	public MenuView() {
		
		setResizable(true);
		setLocationRelativeTo(null);
		setTitle("Astah La Vista");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		texto.setEditable(false);
		
		texto.setBorder(new LineBorder(Color.BLACK));
		b1.setBorder(new LineBorder(Color.BLACK));
		b2.setBorder(new LineBorder(Color.BLACK));
		b3.setBorder(new LineBorder(Color.BLACK));
		b4.setBorder(new LineBorder(Color.BLACK));
		b5.setBorder(new LineBorder(Color.BLACK));
		b6.setBorder(new LineBorder(Color.BLACK));
		b7.setBorder(new LineBorder(Color.BLACK));
		
		status.setBorder(BorderFactory.createLoweredBevelBorder());
		b7.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		botoes.setBorder(BorderFactory.createLoweredBevelBorder());
		painel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		botoes.setLayout(new GridLayout(7, 1, 0, 4));
		botoes.add(b1);
		botoes.add(b2);
		botoes.add(b3);
		botoes.add(b4);
		botoes.add(b5);
		botoes.add(b6);
		botoes.add(b7);
		b2.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		
		splitPane.setDividerSize(5);
		splitPane.setDividerLocation(300);
		splitPane.setTopComponent(scroll);
		splitPane.setBottomComponent(status);
			
		painel.setLayout(new BorderLayout());
		painel.add(splitPane);
		
		Container c = getContentPane();
		c.add(botoes, BorderLayout.WEST);
		c.add(painel, BorderLayout.CENTER);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent eve) {
		
		if(eve.getSource() == b1) {
			new DiagramCreation(this);
		}
		if(eve.getSource() == b2) {
			salvarDiagrama();
		}
		if(eve.getSource() == b3) {
			try {
				Save_Load.carregar();
				texto.setText(DiagramCreationController.getDiagrama().getImagem());
				atualizarStatusView("          Diagrama carregado!");
				ativarBotoes();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if(eve.getSource() == b4) {
			new EscolhaElemento(this);
		}
		if(eve.getSource() == b5) {
			new PropriedadesRelacionamento(this);
		}
		if(eve.getSource() == b6) {
			DiagramCreationController.atualizarDiagrama();
			texto.setText(DiagramCreationController.getDiagrama().getImagem());
		}
		if(eve.getSource() == b7) {
			System.exit(0);	
		}
	}
	
	public void ativarBotoes() {
		b2.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
	}
	
	public void salvarDiagrama() {
		try {
			Save_Load.salvar();
			atualizarStatusView("          Diagrama salvo!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarStatusView(String status) {
		this.status.setText(status);
	}

	public JTextArea getTexto() {
		return texto;
	}

	public JButton getB1() {
		return b1;
	}

	public JButton getB2() {
		return b2;
	}

	public JButton getB5() {
		return b5;
	}

	public JButton getB3() {
		return b3;
	}

	public JButton getB4() {
		return b4;
	}

	public JButton getB6() {
		return b6;
	}
	
	public JButton getB7() {
		return b7;
	}

	public JLabel getStatus() {
		return status;
	}
	
}
