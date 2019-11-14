package br.edu.cefet.trabalho.view;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.cefet.trabalho.controller.CriarDiagramaCommand;
import br.edu.cefet.trabalho.controller.DiagramCreationController;

public class DiagramCreation extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4839612739048956743L;

	private JButton ok = new JButton("OK");
	private JButton cancel = new JButton("Cancelar");
	private JTextField campo = new JTextField();
	private JLabel nome = new JLabel("                         Nome do diagrama: ");
	private JPanel botoes = new JPanel();
	private JPanel dados = new JPanel();
	MenuView view;

	public DiagramCreation(MenuView view) {

		this.view = view;

		setResizable(true);
		setLocationRelativeTo(null);
		setTitle("Criar diagrama");
		setVisible(true);
		setSize(500, 100);

		botoes.setLayout(new GridLayout(1, 2, 5, 5));
		dados.setLayout(new GridLayout(1, 2, 5, 5));

		botoes.add(ok);
		botoes.add(cancel);
		dados.add(nome);
		dados.add(campo);
		Container c = getContentPane();
		c.add(dados, BorderLayout.NORTH);
		c.add(botoes, BorderLayout.SOUTH);

		ok.addActionListener(this);
		cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent eve) {
		if (eve.getSource() == ok) {
			if (campo.getText().equals("")) {
				exibeMensagem("Digite um nome válido para o diagrama!");
			} else {
				criarDiagrama();
			}
		} else if (eve.getSource() == cancel) {
			cancelaDiagrama();
		}
	}

	public void cancelaDiagrama() {
		dispose();
	}

	public void exibeMensagem(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public void criarDiagrama() {
		CriarDiagramaCommand cdc = new CriarDiagramaCommand(view, this);
		cdc.execute();
		view.atualizarStatusView("          Criando diagrama...");
		view.getTexto()
				.setText("	########## " + DiagramCreationController.getDiagrama().getNome() + " ##########\n");
		DiagramCreationController.getDiagrama().setImagem(view.getTexto().getText());
		DiagramCreationController.atualizarDiagramaBackup();
		dispose();
		view.ativarBotoes();
	}
	public JTextField getCampo() {
		return campo;
	}

}
