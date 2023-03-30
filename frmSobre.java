import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class frmSobre extends JFrame
{
	//--------------------------------------------------------------------------------------------------------------------------//
  																//CONSTRUTOR//
	//--------------------------------------------------------------------------------------------------------------------------//
    public frmSobre() 
    {
    	//--------------------------------------------------------------------------------------------------------------------------//
																	//TELA//
		//--------------------------------------------------------------------------------------------------------------------------//
    	super("Sobre");
    	Container tela = getContentPane();
    	tela.setLayout(new BorderLayout());
    	//--------------------------------------------------------------------------------------------------------------------------//
							   									//CENTRO DA TELA//
		//--------------------------------------------------------------------------------------------------------------------------//
		//--------------------------------------------------------------------------------------------------------------------------//
							   							//CENTRO DA TELA -> TEORIA//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTeoria = new JPanel();
		pnlTeoria.setBorder(BorderFactory.createEtchedBorder(1));
		pnlTeoria.setLayout(new BorderLayout());
		tela.add(pnlTeoria, BorderLayout.NORTH);
		//--------------------------------------------------------------------------------------------------------------------------//
		JLabel lblTituloTeoria = new JLabel("Sobre o modo FCFS de escalonamento");
		lblTituloTeoria.setHorizontalAlignment(SwingConstants.CENTER);
		pnlTeoria.add(lblTituloTeoria, BorderLayout.NORTH); 
		//--------------------------------------------------------------------------------------------------------------------------//
		JTextArea txtTeoria = new JTextArea();
		txtTeoria.append(
							"          O escalonamento FIFO (First-In-First-Out) ou FCFS (First-Come, First Served) � a forma mais elementar para escalonar processos e consiste em atender as tarefas na ordem em que estas chegam � fila de tarefas prontas.\n" +
							"          Este  projeto  une  a  fila  de  processos  prontos  e  a  fila  de  processos  bloqueados em uma �nica fila  de   processos   bloqueados.   O  algoritmo   apresentado   representa   o   modo   de  escalonamento  FCFS cooperativo, no qual o processador executa uma tafera por vez.\n" +
							"          Para  melhorar  o  desempenho, os processos s�o alocados na mem�ria de acordo sua posi��o na fila de bloqueados. O processo em execu��o e os primeiros processos da fila de bloqueados s�o armazenados na  mem�ria  principal.  Caso  a  mem�ria principal fique lotada, os �ltimos processos da fila de  bloqueados s�o   armazenados   na   mem�ria  secund�ria.  Para  que  esta  realoca��o  de  mem�ria  (swap)  possa  ser executada, �   necess�rio   que  haja  na  mem�ria  secund�ria  um  espa�o  igual  ou  superior  ao   tamanho do maior processo."           
						);
		txtTeoria.setEditable(false);
		txtTeoria.setPreferredSize(new Dimension(600, 210));
		txtTeoria.setWrapStyleWord(true);
		txtTeoria.setLineWrap(true);
		JLabel lblTeorialn02 = new JLabel("");
		pnlTeoria.add(txtTeoria, BorderLayout.CENTER); 
		//--------------------------------------------------------------------------------------------------------------------------//
							   						   //CENTRO DA TELA -> CR�DITOS//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlCreditos = new JPanel();
		pnlCreditos.setLayout(new BorderLayout());
		pnlCreditos.setBorder(BorderFactory.createEtchedBorder(1));
		tela.add(pnlCreditos, BorderLayout.CENTER);
		//--------------------------------------------------------------------------------------------------------------------------//
							   					  //CENTRO DA TELA -> CR�DITOS -> TITULO//
		//--------------------------------------------------------------------------------------------------------------------------//
		JLabel lblTituloCreditos = new JLabel("Desenvolvedor");
		lblTituloCreditos.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCreditos.add(lblTituloCreditos, BorderLayout.NORTH);
		//--------------------------------------------------------------------------------------------------------------------------//
							   					  //CENTRO DA TELA -> CR�DITOS -> TEXTO//
		//--------------------------------------------------------------------------------------------------------------------------//
		JTextArea txtCreditos = new JTextArea();
		txtCreditos.setEditable(false);
		txtCreditos.append(
							"Aluno: William Cardoso Simas (RA 200452).\n" +
							"Curso: Engenharia da Computa��o - 7� termo - Noturno.\n" + 
							"Disciplina: Sistemas Operacionais.\n" +
							"Orientador: Rafael Marcelino de Jesus.\n" + 
							"Universidade: Centro Universit�rio Cat�lico Salesiano Auxilium - Ara�atuba."
						  );
		pnlCreditos.add(txtCreditos, BorderLayout.CENTER);
	    //--------------------------------------------------------------------------------------------------------------------------//
							   									//RODAP� DA TELA//
		//--------------------------------------------------------------------------------------------------------------------------//
    	JPanel pnlBotoes = new JPanel();
    	pnlBotoes.setLayout(new FlowLayout());
    	tela.add(pnlBotoes, BorderLayout.SOUTH);
    	//--------------------------------------------------------------------------------------------------------------------------//
		JButton btnFechar = new JButton("Fechar");
		pnlBotoes.add(btnFechar);
		btnFechar.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					dispose();
				}	
			}		
		);    	
    	//--------------------------------------------------------------------------------------------------------------------------//
																	//TELA//
		//--------------------------------------------------------------------------------------------------------------------------//
    	setResizable(false);
    	pack();
    	setLocationRelativeTo(null);
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}