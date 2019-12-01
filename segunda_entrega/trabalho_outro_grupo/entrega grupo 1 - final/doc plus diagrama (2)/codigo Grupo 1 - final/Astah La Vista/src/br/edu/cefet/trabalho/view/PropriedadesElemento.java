package br.edu.cefet.trabalho.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import br.edu.cefet.trabalho.controller.CriarClasseCommand;
import br.edu.cefet.trabalho.controller.CriarInterfaceCommand;
import br.edu.cefet.trabalho.controller.DiagramCreationController;
import br.edu.cefet.trabalho.model.Atributo;
import br.edu.cefet.trabalho.model.Classe;
import br.edu.cefet.trabalho.model.Interface;
import br.edu.cefet.trabalho.model.Metodo;
import br.edu.cefet.trabalho.model.Parametro;

public class PropriedadesElemento extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 2321911970494000652L;
	private MenuView view;
	
	private Classe classe = new Classe();
	private Interface interface_ = new Interface();
	private static ArrayList<Parametro> parametro = new ArrayList<>();
	
	private JButton confirmar = new JButton("Confirmar");
	private JButton cancelar = new JButton("Cancelar");
	private JButton addAtributo = new JButton("Adicionar Atributo");
	private JButton addMetodo = new JButton("Adicionar M�todo");
	private JButton addParam = new JButton("Adicionar Par�metro");
	
	private JLabel nome = new JLabel("Nome do elemento: ");
	private JLabel atr = new JLabel("Nome do atributo: ");
	private JLabel met = new JLabel("Nome do m�todo: ");
	private JLabel tipo = new JLabel("Retorno: ");
	private JLabel vis = new JLabel("Visibilidade: ");
	private JLabel digaTipo = new JLabel("Retorno: ");
	private JLabel digaVis = new JLabel("Visibilidade: ");
	private JLabel modAtr = new JLabel("Modificadores: ");
	private JLabel modMet = new JLabel("Modificadores: ");
	private JLabel labelVazio = new JLabel("");
	private JLabel nomeParamLabel = new JLabel("                   Nome do atributo de par�metro");
	private JLabel tipoParamLabel = new JLabel("                           Tipo do par�metro");
	
	private JTextField nomeElemento = new JTextField();
	private JTextField nomeAtributo = new JTextField();
	private JTextField nomeMetodo = new JTextField();
	private JTextField nomeParametro = new JTextField();
	
	private JPanel botoes = new JPanel();
	
	private JPanel tab1 = new JPanel();
	private JPanel tab2 = new JPanel();
	private JPanel tab3 = new JPanel();
	
	private JPanel checkAtr = new JPanel(new GridLayout(1, 3));
	private JPanel checkMet = new JPanel(new GridLayout(1, 3));
	
	private JTabbedPane tabs = new JTabbedPane();
	private JComboBox<String> atrVisibilidade = new JComboBox<>();
	private JComboBox<String> atrTipo = new JComboBox<>();
	private JComboBox<String> metVisibilidade = new JComboBox<>();
	private JComboBox<String> metTipo = new JComboBox<>();
	private JComboBox<String> tipoParametro = new JComboBox<>();
	
	private JCheckBox atrFinal = new JCheckBox("final");
	private JCheckBox atrAbstrata = new JCheckBox("abstract");
	private JCheckBox atrEstatica = new JCheckBox("static");
	
	private JCheckBox metFinal = new JCheckBox("final");
	private JCheckBox metAbstrata = new JCheckBox("abstract");
	private JCheckBox metEstatica = new JCheckBox("static");
	
	public PropriedadesElemento(String titulo, MenuView view) {
		
		this.view = view;
		
		setResizable(true);
		setLocationRelativeTo(null);
		setTitle(titulo);
		setVisible(true);
		setSize(600, 240);
		
		if(this.getTitle().equals("Propriedades da Classe")) {
			nome.setText("Nome da Classe: ");
		}
		else if(this.getTitle().equals("Propriedades da Interface")) {
			nome.setText("Nome da Interface: ");
		}
		
		botoes.setLayout(new GridLayout(1, 2, 10, 10));
		botoes.add(confirmar);
		botoes.add(cancelar);
		
		adicionarVisibilidade(atrVisibilidade);
		adicionarTipo(atrTipo);
		if(!DiagramCreationController.getDiagrama().getElementos().isEmpty()) {
			for(int i = 0; i < DiagramCreationController.getDiagrama().getElementos().size(); i++) {
				atrTipo.addItem(DiagramCreationController.getDiagrama().getElementos().get(i).toString());
			}
		}
		adicionarVisibilidade(metVisibilidade);
		adicionarTipo(metTipo);
		if(!DiagramCreationController.getDiagrama().getElementos().isEmpty()) {
			for(int i = 0; i < DiagramCreationController.getDiagrama().getElementos().size(); i++) {
				metTipo.addItem(DiagramCreationController.getDiagrama().getElementos().get(i).toString());
			}
		}
		adicionarTipo(tipoParametro);
		if(!DiagramCreationController.getDiagrama().getElementos().isEmpty()) {
			for(int i = 0; i < DiagramCreationController.getDiagrama().getElementos().size(); i++) {
				tipoParametro.addItem(DiagramCreationController.getDiagrama().getElementos().get(i).toString());
			}
		}
		atrTipo.addItem("void");
		metTipo.addItem("void");
			
		checkAtr.add(atrFinal);
		checkAtr.add(atrAbstrata);
		checkAtr.add(atrEstatica);
			
		checkMet.add(metFinal);
		checkMet.add(metAbstrata);
		checkMet.add(metEstatica);
			
		tab1.setLayout(new GridLayout(3, 2, 10, 10));
		tab1.add(nome);
		tab1.add(nomeElemento);
		tab1.add(botoes);
			
		tab2.setLayout(new GridLayout(5, 2, 7, 7));
		tab2.add(atr);
		tab2.add(nomeAtributo);
		tab2.add(digaTipo);
		tab2.add(atrTipo);
		tab2.add(digaVis);
		tab2.add(atrVisibilidade);
		tab2.add(modAtr);
		tab2.add(checkAtr);
		tab2.add(labelVazio);
		tab2.add(addAtributo);
		
		tab3.setLayout(new GridLayout(7, 2, 5, 5));
		tab3.add(met);
		tab3.add(nomeMetodo);
		tab3.add(tipo);
		tab3.add(metTipo);
		tab3.add(vis);
		tab3.add(metVisibilidade);
		tab3.add(modMet);
		tab3.add(checkMet);
		tab3.add(nomeParamLabel);
		tab3.add(tipoParamLabel);
		tab3.add(nomeParametro);
		tab3.add(tipoParametro);
		tab3.add(addParam);
		tab3.add(addMetodo);
		
		String elemento = null;
		if(this.getTitle().equals("Propriedades da Classe")) {
			elemento = "Classe";
		}
		else if(this.getTitle().equals("Propriedades da Interface")) {
			elemento = "Interface";
		}
		
		tabs.addTab(elemento, tab1);
		tabs.addTab("Atributos", tab2);
		tabs.addTab("M�todos", tab3);
			
		Container c = getContentPane();
		c.add(tabs);
		
		eventoBotoes();
		
	}
	
	public void adicionarVisibilidade(JComboBox<String> comboBox) {
		comboBox.addItem("public");
		comboBox.addItem("private");
		comboBox.addItem("protected");
		comboBox.addItem("default");
	}
	
	public void adicionarTipo(JComboBox<String> comboBox) {
		comboBox.addItem("int");
		comboBox.addItem("float");
		comboBox.addItem("char");
		comboBox.addItem("long");
		comboBox.addItem("double");
		comboBox.addItem("byte");
		comboBox.addItem("boolean");
		comboBox.addItem("short");
		comboBox.addItem("String");
	}
	
	public void eventoBotoes() {
		confirmar.addActionListener(this);
		cancelar.addActionListener(this);
		addAtributo.addActionListener(this);
		addMetodo.addActionListener(this);
		addParam.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent eve) {
		if(eve.getSource() == confirmar) {
			if(nomeElemento.getText().equals("")) {
				if(getTitle().equals("Propriedades da Classe")) {
					exibeMensagem("Digite um nome v�lido para a classe!");
				}
				else if(getTitle().equals("Propriedades da Interface")) {
					exibeMensagem("Digite um nome v�lido para a interface!");
				}
			}
			else {
				criarElemento();
			}
		}
		if(eve.getSource() == cancelar) {
			classe = null;
			interface_ = null;
			cancelaElemento();
		}
		if(eve.getSource() == addAtributo) {
			addAtributo();
		}
		if(eve.getSource() == addMetodo) {
			addMetodo();
		}
		if(eve.getSource() == addParam) {
			addParam();
		}
	}
	
	public void exibeMensagem(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	public void cancelaElemento() {
		dispose();
	}
	
	public void addAtributo(){
		if(nomeAtributo.getText().equals("")) {
			exibeMensagem("Digite um nome de atributo v�lido!");
		}
		else {
			Atributo atr = new Atributo();
			atr.setNome(nomeAtributo.getText());
			atr.setTipo((String)atrTipo.getSelectedItem());
			atr.setVisibilidade((String)atrVisibilidade.getSelectedItem());
			if(atrFinal.isSelected()) {
				atr.getModificadores().add(atrFinal.getText());
			}
			if(atrAbstrata.isSelected()) {
				atr.getModificadores().add(atrAbstrata.getText());
			}
			if(atrEstatica.isSelected()) {
				atr.getModificadores().add(atrEstatica.getText());
			}
			if(getTitle().equals("Propriedades da Classe")) {
				classe.getAtributos().add(atr);
			}
			else if(getTitle().equals("Propriedades da Interface")) {
				interface_.getAtributos().add(atr);
			}
			nomeAtributo.setText("");
		}
	}
	
	public void addMetodo(){
		if(nomeMetodo.getText().equals("")) {
			exibeMensagem("Digite um nome de m�todo v�lido!");
		}
		else {
			Metodo met = new Metodo();
			met.setNome(nomeMetodo.getText());
			met.setTipo((String)metTipo.getSelectedItem());
			met.setVisibilidade((String)metVisibilidade.getSelectedItem());
			if(metFinal.isSelected()) {
				met.getModificadores().add(metFinal.getText());
			}
			if(metAbstrata.isSelected()) {
				met.getModificadores().add(metAbstrata.getText());
			}
			if(metEstatica.isSelected()) {
				met.getModificadores().add(metEstatica.getText());
			}
			for(Parametro param : parametro) {
				met.getParametros().add(param);
			}
			
			if(getTitle().equals("Propriedades da Classe")) {
				classe.getMetodos().add(met);
			}
			else if(getTitle().equals("Propriedades da Interface")) {
				interface_.getMetodos().add(met);
			}
			parametro.clear();
			nomeMetodo.setText("");
			nomeParametro.setText("");
		}
	}
	
	public void addParam(){
		if(nomeParametro.getText().equals("")) {
			exibeMensagem("Digite um nome de par�metro v�lido!");
		}
		else {
			Parametro param = new Parametro();
			param.setNome(nomeParametro.getText());
			param.setTipo((String)tipoParametro.getSelectedItem());
			parametro.add(param);
			nomeParametro.setText("");
		}
	}
	
	public void criarElemento() {
		DiagramCreationController.atualizarDiagramaBackup();
	    if(getTitle().equals("Propriedades da Classe")) {
			classe.setNome(nomeElemento.getText());
			CriarClasseCommand ccc = new CriarClasseCommand(classe);
			ccc.execute();
			view.atualizarStatusView("          Classe criada!");
	    }
	    else if(getTitle().equals("Propriedades da Interface")) {
	    	interface_.setNome(nomeElemento.getText());
	    	CriarInterfaceCommand cic = new CriarInterfaceCommand(interface_);
			cic.execute();
			view.atualizarStatusView("          Interface criada!");
	    }
	    dispose();
	    view.getTexto().setText(DiagramCreationController.getDiagrama().getImagem());
	}
	
}
