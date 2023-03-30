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
		JLabel lblTituloTeoria = new JLabel("Sobre o modo FCSC de escalonamento");
		lblTituloTeoria.setHorizontalAlignment(SwingConstants.CENTER);
		pnlTeoria.add(lblTituloTeoria, BorderLayout.NORTH); 
		//--------------------------------------------------------------------------------------------------------------------------//
		JTextArea txtTeoria = new JTextArea();
		txtTeoria.append(
							"          O escalonamento FIFO (First-In-First-Out) ou FCSC (First-Come, First Served) é a forma mais elementar para escalonar processos e consiste em atender as tarefas na ordem em que estas chegam à fila de tarefas prontas.\n" +
							"          Este  projeto  une  a  fila  de  processos  prontos  e  a  fila  de  processos  bloqueados em uma única fila  de   processos   bloqueados.   O  algoritmo   apresentado   representa   o   modo   de  escalonamento  FCSC cooperativo, no qual o processador executa uma tafera por vez.\n" +
							"          Para  melhorar  o  desempenho, os processos são alocados na memória de acordo sua posição na fila de bloqueados. O processo em execução e os primeiros processos da fila de bloqueados são armazenados na  memória  principal.  Caso  a  memória principal fique lotada, os últimos processos da fila de  bloqueados são   armazenados   na   memória  secundária.  Para  que  esta  realocação  de  memória  (swap)  possa  ser executada, é   necessário   que  haja  na  memória  secundária  um  espaço  igual  ou  superior  ao   tamanho do maior processo."           
						);
		txtTeoria.setEditable(false);
		txtTeoria.setPreferredSize(new Dimension(600, 210));
		txtTeoria.setWrapStyleWord(true);
		txtTeoria.setLineWrap(true);
		JLabel lblTeorialn02 = new JLabel("");
		pnlTeoria.add(txtTeoria, BorderLayout.CENTER); 
		//--------------------------------------------------------------------------------------------------------------------------//
							   						   //CENTRO DA TELA -> CRÉDITOS//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlCreditos = new JPanel();
		pnlCreditos.setLayout(new BorderLayout());
		pnlCreditos.setBorder(BorderFactory.createEtchedBorder(1));
		tela.add(pnlCreditos, BorderLayout.CENTER);
		//--------------------------------------------------------------------------------------------------------------------------//
							   					  //CENTRO DA TELA -> CRÉDITOS -> TITULO//
		//--------------------------------------------------------------------------------------------------------------------------//
		JLabel lblTituloCreditos = new JLabel("Desenvolvedor");
		lblTituloCreditos.setHorizontalAlignment(SwingConstants.CENTER);
		pnlCreditos.add(lblTituloCreditos, BorderLayout.NORTH);
		//--------------------------------------------------------------------------------------------------------------------------//
							   					  //CENTRO DA TELA -> CRÉDITOS -> TEXTO//
		//--------------------------------------------------------------------------------------------------------------------------//
		JTextArea txtCreditos = new JTextArea();
		txtCreditos.setEditable(false);
		txtCreditos.append(
							"Aluno: William Cardoso Simas (RA 200452).\n" +
							"Curso: Engenharia da Computação - 7º termo - Noturno.\n" + 
							"Disciplina: Sistemas Operacionais.\n" +
							"Orientador: Rafael Marcelino de Jesus.\n" + 
							"Universidade: Centro Universitário Católico Salesiano Auxilium - Araçatuba."
						  );
		pnlCreditos.add(txtCreditos, BorderLayout.CENTER);
	    //--------------------------------------------------------------------------------------------------------------------------//
							   									//RODAPÉ DA TELA//
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