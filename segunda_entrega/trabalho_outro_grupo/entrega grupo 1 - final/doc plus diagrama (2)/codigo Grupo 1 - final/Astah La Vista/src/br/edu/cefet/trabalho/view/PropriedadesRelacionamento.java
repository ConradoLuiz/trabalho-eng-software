package br.edu.cefet.trabalho.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import br.edu.cefet.trabalho.controller.CriarRelacionamentoCommand;
import br.edu.cefet.trabalho.controller.DiagramCreationController;
import br.edu.cefet.trabalho.controller.DiagramController;
import br.edu.cefet.trabalho.model.Agregacao;
import br.edu.cefet.trabalho.model.Associacao;
import br.edu.cefet.trabalho.model.Composicao;
import br.edu.cefet.trabalho.model.Elemento;
import br.edu.cefet.trabalho.model.Relacionamento;

public class PropriedadesRelacionamento extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1208950775854240764L;
	private MenuView view;
	
	private JButton confirmar = new JButton("Confirmar");
	private JButton cancelar = new JButton("Cancelar");
	
	private JComboBox<String> multiElement1 = new JComboBox<>();
	private JComboBox<String> multiElement2 = new JComboBox<>();
	private JComboBox<String> modElement1 = new JComboBox<>();
	private JComboBox<String> modElement2 = new JComboBox<>();
	private JComboBox<String> tipoRela = new JComboBox<>();
	private JComboBox<String> sentido = new JComboBox<>();
	private JComboBox<String> navCombo1 = new JComboBox<>();
	private JComboBox<String> navCombo2 = new JComboBox<>();
	
	private JTextField papelElement1 = new JTextField();
	private JTextField papelElement2 = new JTextField();
	private JTextField nomeRela = new JTextField();
	
	private JList<Object> element1;
	private JList<Object> element2;
	
	private JLabel vazio = new JLabel("");
	private JLabel table1Label = new JLabel("Elemento 1");
	private JLabel table2Label = new JLabel("Elemento 2");
	private JLabel nomeRelaLabel = new JLabel("Nome do Relacionamento");
	private JLabel multiLabel = new JLabel("Multiplicidade");
	private JLabel papelLabel = new JLabel("Papel");
	private JLabel modLabel = new JLabel("Modificador");
	private JLabel tipoRelaLabel = new JLabel("Tipo de relacionamento");
	private JLabel sentidoLabel = new JLabel("Sentido");
	private JLabel navegabilidadeLabel = new JLabel("Navegabilidade");
	
	private JPanel norte = new JPanel(new GridLayout(1, 3));
	private JPanel painel = new JPanel(new GridLayout(15, 1));
	private JPanel multiPanel = new JPanel(new GridLayout(1, 2));
	private JPanel papelPanel = new JPanel(new GridLayout(1, 2));
	private JPanel botoes = new JPanel(new GridLayout(1, 2));
	private JPanel aux = new JPanel(new GridLayout(1, 3));
	private JPanel modPanel = new JPanel(new GridLayout(1, 3));
	private JPanel navPanel = new JPanel(new GridLayout(1, 2));
	
	private JScrollPane scroll1;
	private JScrollPane scroll2;
	
	public PropriedadesRelacionamento(MenuView view) {
		
		this.view = view;
		
		setResizable(true);
		setLocationRelativeTo(null);
		setTitle("Criar Relacionamento");
		setVisible(true);
		setSize(650, 350);
		
		tipoRela.addItem("Associa��o");
		tipoRela.addItem("Agrega��o");
		tipoRela.addItem("Composi��o");
		
		multiElement1.addItem("0..1");
		multiElement1.addItem("1");
		multiElement1.addItem("0..*");
		multiElement1.addItem("1..*");
		multiElement2.addItem("0..1");
		multiElement2.addItem("1");
		multiElement2.addItem("0..*");
		multiElement2.addItem("1..*");
		
		modElement1.addItem("public");
		modElement1.addItem("private");
		modElement1.addItem("protected");
		modElement1.addItem("default");
		modElement2.addItem("public");
		modElement2.addItem("private");
		modElement2.addItem("protected");
		modElement2.addItem("default");
		
		navCombo1.addItem("<--");
		navCombo1.addItem("---");
		navCombo2.addItem("-->");
		navCombo2.addItem("---");
		
		sentido.addItem("->");
		sentido.addItem("<-");
		
		Object ele[] = (Object[])DiagramCreationController.getDiagrama().getElementos().toArray();
		element1 = new JList<>(ele);
		element2 = new JList<>(ele);
		
		norte.add(table1Label);
		norte.add(vazio);
		norte.add(table2Label);
		
		botoes.add(confirmar);
		botoes.add(cancelar);
		
		navPanel.add(navCombo1);
		navPanel.add(navCombo2);
		
		multiPanel.add(multiElement1);
		multiPanel.add(multiElement2);
		
		papelPanel.add(papelElement1);
		papelPanel.add(papelElement2);
		
		modPanel.add(modElement1);
		modPanel.add(modElement2);
		
		painel.add(tipoRelaLabel);
		painel.add(tipoRela);
		painel.add(nomeRelaLabel);
		painel.add(nomeRela);
		painel.add(multiLabel);
		painel.add(multiPanel);
		painel.add(navegabilidadeLabel);
		painel.add(navPanel);
		
		painel.add(sentidoLabel);
		painel.add(sentido);
		painel.add(papelLabel);
		painel.add(papelPanel);
		painel.add(modLabel);
		painel.add(modPanel);
		painel.add(botoes);
		
		painel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		scroll1 = new JScrollPane(element1);
		scroll2 = new JScrollPane(element2);
		
		scroll1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		scroll2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		aux.add(scroll1);
		aux.add(painel);
		aux.add(scroll2);
		
		Container c = getContentPane();
		c.add(norte, BorderLayout.NORTH);
		c.add(aux, BorderLayout.CENTER);
		
		confirmar.addActionListener(this);
		cancelar.addActionListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent eve) {
		
		if(eve.getSource() == confirmar){
			if(nomeRela.getText().equals("")) {
				exibeMensagem("Escolha um nome para o relacionamento!");
			}
			else if(element1.isSelectionEmpty() || element2.isSelectionEmpty()) {
				exibeMensagem("Selecione os elementos para comp�r o relacionamento!");
			}
			else {
				DiagramCreationController.atualizarDiagramaBackup();
				if(tipoRela.getSelectedItem().equals("Associa��o")){
			 		Associacao associacao = new Associacao();
			 		criarRelacionamentoCommand(associacao);
			  		
			  		view.atualizarStatusView("          Associa��o criada!");
			  		
			  	}
			  	else if(tipoRela.getSelectedItem().equals("Agrega��o")){
			 		Agregacao agregacao = new Agregacao();	 
			 		criarRelacionamentoCommand(agregacao);
			  		
			  		view.atualizarStatusView("          Agraga��o criada!");
			  	}
			  	else if(tipoRela.getSelectedItem().equals("Composi��o")){
			  		Composicao composicao = new Composicao();
			  		criarRelacionamentoCommand(composicao);
			  		
			  		view.atualizarStatusView("          Composi��o criada!");
			  	}
				dispose();
				view.getTexto().setText(DiagramCreationController.getDiagrama().getImagem());
			}
		  
		}
		if(eve.getSource() == cancelar){
			cancelaRelacionamento();
		}
		
	}
	
	public void criarRelacionamentoCommand(Relacionamento escolha) {
		CriarRelacionamentoCommand crc =  new CriarRelacionamentoCommand(escolha, nomeRela.getText(), (Elemento)element1.getSelectedValue(), 
				(Elemento)element2.getSelectedValue(), (String)sentido.getSelectedItem(), 
				(String)papelElement1.getText(), (String)papelElement2.getText(), 
				(String)multiElement1.getSelectedItem(), (String)multiElement2.getSelectedItem(), 
				(String)modElement1.getSelectedItem(), (String)modElement2.getSelectedItem(), 
				(String)navCombo1.getSelectedItem(), (String)navCombo2.getSelectedItem());
		crc.execute();	
	}
	
	public void exibeMensagem(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	public void cancelaRelacionamento() {
		dispose();
	}
	
}
