import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class frmPrincipal extends JFrame
{
	//--------------------------------------------------------------------------------------------------------------------------//
  																//ATRIBUTOS//
	//--------------------------------------------------------------------------------------------------------------------------// 
	clsTabelaProcesso objTabelaProcessos;
	clsTabelaProcessosBloqueados objProcessosBloqueados;
	clsTabelaMemoria objMemoriaPrincipal;
	clsTabelaMemoria objMemoriaSecundaria;
	clsTabelaTempoTotal objTabelaTempoTotal;
	clsTabelaProcessoEmExecucao objProcessoEmExecucao;
	clsEscalonador objProcessador;
	JTable tblProcessos;
	//--------------------------------------------------------------------------------------------------------------------------//
  																//CONSTRUTOR//
	//--------------------------------------------------------------------------------------------------------------------------//
	public frmPrincipal()
	{
		//--------------------------------------------------------------------------------------------------------------------------//
																	//TELA//
		//--------------------------------------------------------------------------------------------------------------------------//
		super("Simulador de escalonamento de processos FCFS");
		Container tela = getContentPane();
		tela.setLayout(new BorderLayout());
		//--------------------------------------------------------------------------------------------------------------------------//
							   									//CENTRO DA TELA//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlCentro = new JPanel();
		pnlCentro.setLayout(new BorderLayout());
		//--------------------------------------------------------------------------------------------------------------------------//
													//CENTRO DA TELA -> TELA DE PROCESSOS//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlProcessos = new JPanel();
		pnlProcessos.setLayout(new BorderLayout());
		pnlProcessos.setBorder(BorderFactory.createEtchedBorder(1));
		pnlCentro.add(pnlProcessos, BorderLayout.NORTH);
		//--------------------------------------------------------------------------------------------------------------------------//
		  								//CENTRO DA TELA -> TELA DE PROCESSOS -> TABELA DE PROCESSOS//
		//--------------------------------------------------------------------------------------------------------------------------//	
		JPanel pnlPrcTabela = new JPanel();
		pnlPrcTabela.setLayout(new FlowLayout(FlowLayout.LEFT));
		//--------------------------------------------------------------------------------------------------------------------------//
		objTabelaProcessos = new clsTabelaProcesso(256, 930, 160);
		JScrollPane scrProcessos = new JScrollPane(objTabelaProcessos.getTable());
		pnlPrcTabela.add(scrProcessos);
		pnlProcessos.add(pnlPrcTabela, BorderLayout.WEST);
		//--------------------------------------------------------------------------------------------------------------------------//
		  									//CENTRO DA TELA -> TELA DE PROCESSOS -> BOT�ES//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlPrcBotoes = new JPanel();
		pnlPrcBotoes.setLayout(new GridLayout(2,1));
		pnlProcessos.add(pnlPrcBotoes, BorderLayout.EAST);
		//--------------------------------------------------------------------------------------------------------------------------//
		JButton btnCriarProcesso = new JButton("Criar processo...");
		pnlPrcBotoes.add(btnCriarProcesso);
		btnCriarProcesso.addActionListener
											(
												new ActionListener()
												{
													public void actionPerformed(ActionEvent e)
													{
														frmAdicionarProcesso adicionarProcesso = new frmAdicionarProcesso(objTabelaProcessos, objMemoriaPrincipal, objMemoriaSecundaria, objProcessosBloqueados);
													}	
												}		
											);
		//--------------------------------------------------------------------------------------------------------------------------//
		JButton btnEliminarProcesso = new JButton("Eliminar processo");
		pnlPrcBotoes.add(btnEliminarProcesso);
		btnEliminarProcesso.addActionListener(
												new ActionListener()
												{
													public void actionPerformed(ActionEvent e)
													{
														objTabelaProcessos.eliminarProcesso(objMemoriaPrincipal, objMemoriaSecundaria, objProcessosBloqueados, objProcessoEmExecucao);	
													}
												}	
											  );
		//--------------------------------------------------------------------------------------------------------------------------//
		  										  //CENTRO DA TELA -> TELA DE MEM�RIA//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlMemoria = new JPanel();
		pnlMemoria.setLayout(new BorderLayout());
		pnlCentro.add(pnlMemoria, BorderLayout.WEST);
		pnlMemoria.setBorder(BorderFactory.createEtchedBorder(1));
		//--------------------------------------------------------------------------------------------------------------------------//
		  									//CENTRO DA TELA -> TELA DE MEM�RIA -> T�TULO//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTituloMemoria = new JPanel();
		pnlTituloMemoria.setLayout(new FlowLayout());
		pnlMemoria.add(pnlTituloMemoria, BorderLayout.NORTH);
		//--------------------------------------------------------------------------------------------------------------------------//
		JLabel lblTituloMemoria = new JLabel("Mem�ria");
		pnlTituloMemoria.add(lblTituloMemoria);
		//--------------------------------------------------------------------------------------------------------------------------//
		   							  //CENTRO DA TELA -> TELA DE MEM�RIA -> MEM�RIA PRINCIPAL//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlMemoriaPrincipal = new JPanel();
		pnlMemoriaPrincipal.setLayout(new BorderLayout());
		pnlMemoria.add(pnlMemoriaPrincipal, BorderLayout.WEST);
		pnlMemoriaPrincipal.setBorder(BorderFactory.createEtchedBorder(1));
		//--------------------------------------------------------------------------------------------------------------------------//
	  							//CENTRO DA TELA -> TELA DE MEM�RIA -> MEM�RIA PRINCIPAL -> TITULO//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTituloMemoriaPrincipal = new JPanel();
		pnlTituloMemoriaPrincipal.setLayout(new FlowLayout());
		pnlMemoriaPrincipal.add(pnlTituloMemoriaPrincipal, BorderLayout.NORTH);
		//--------------------------------------------------------------------------------------------------------------------------//
		JLabel lblTituloMemoriaPrincipal = new JLabel("Mem�ria principal");
		pnlTituloMemoriaPrincipal.add(lblTituloMemoriaPrincipal);
		//--------------------------------------------------------------------------------------------------------------------------//
	  							//CENTRO DA TELA -> TELA DE MEM�RIA -> MEM�RIA PRINCIPAL -> TABELA//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTabelaMemoriaPrincipal = new JPanel();
		pnlTabelaMemoriaPrincipal.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlMemoriaPrincipal.add(pnlTabelaMemoriaPrincipal, BorderLayout.CENTER);
		//--------------------------------------------------------------------------------------------------------------------------//
		objMemoriaPrincipal = new clsTabelaMemoria(16, 8, 200, 256);
		JScrollPane scrMemoriaPrincipal = new JScrollPane(objMemoriaPrincipal.getTable());
		pnlTabelaMemoriaPrincipal.add(scrMemoriaPrincipal);
		//--------------------------------------------------------------------------------------------------------------------------//
		   								//CENTRO DA TELA -> TELA DE MEM�RIA -> MEM�RIA SECUND�RIA//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlMemoriaSecundaria = new JPanel();
		pnlMemoriaSecundaria.setLayout(new BorderLayout());
		pnlMemoria.add(pnlMemoriaSecundaria, BorderLayout.EAST);
		pnlMemoriaSecundaria.setBorder(BorderFactory.createEtchedBorder(1));
		//--------------------------------------------------------------------------------------------------------------------------//
	  							//CENTRO DA TELA -> TELA DE MEM�RIA -> MEM�RIA SECUND�RIA -> TITULO//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTituloMemoriaSecundaria = new JPanel();
		pnlTituloMemoriaSecundaria.setLayout(new FlowLayout());
		pnlMemoriaSecundaria.add(pnlTituloMemoriaSecundaria, BorderLayout.NORTH);
		//--------------------------------------------------------------------------------------------------------------------------//
		JLabel lblTituloMemoriaSecundaria = new JLabel("Mem�ria secund�ria");
		pnlTituloMemoriaSecundaria.add(lblTituloMemoriaSecundaria);
		//--------------------------------------------------------------------------------------------------------------------------//
	  							//CENTRO DA TELA -> TELA DE MEM�RIA -> MEM�RIA SECUND�RIA -> TABELA//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTabelaMemoriaSecundaria = new JPanel();
		pnlTabelaMemoriaSecundaria.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnlMemoriaSecundaria.add(pnlTabelaMemoriaSecundaria, BorderLayout.CENTER);
		//--------------------------------------------------------------------------------------------------------------------------//
		objMemoriaSecundaria = new clsTabelaMemoria(16, 16, 400, 256);
		JScrollPane scrMemoriaSecundaria = new JScrollPane(objMemoriaSecundaria.getTable());
		pnlTabelaMemoriaSecundaria.add(scrMemoriaSecundaria);
		//--------------------------------------------------------------------------------------------------------------------------//
		  								 		  //CENTRO DA TELA -> PROCESSADOR//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlProcessador = new JPanel();
		pnlProcessador.setLayout(new BorderLayout());
		pnlProcessador.setBorder(BorderFactory.createEtchedBorder(1));
		pnlCentro.add(pnlProcessador, BorderLayout.CENTER);
		//--------------------------------------------------------------------------------------------------------------------------//
		  								 	 //CENTRO DA TELA -> PROCESSADOR -> T�TULO//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTituloProcessador = new JPanel();
		pnlTituloProcessador.setLayout(new FlowLayout());
		pnlProcessador.add(pnlTituloProcessador, BorderLayout.NORTH);
		//--------------------------------------------------------------------------------------------------------------------------//
		JLabel lblTituloProcessador = new JLabel("Processador");
		pnlTituloProcessador.add(lblTituloProcessador);	
		//--------------------------------------------------------------------------------------------------------------------------//
		  									  //CENTRO DA TELA -> PROCESSADOR -> FILA DE BLOQUEADOS//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlFilaDeBloqueados = new JPanel();
		pnlFilaDeBloqueados.setLayout(new BorderLayout());
		pnlFilaDeBloqueados.setBorder(BorderFactory.createEtchedBorder(1));
		pnlProcessador.add(pnlFilaDeBloqueados, BorderLayout.WEST);
		//--------------------------------------------------------------------------------------------------------------------------//
		  								 //CENTRO DA TELA -> PROCESSADOR -> FILA DE BLOQUEADOS -> T�TULO//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTituloFilaDeBloqueados = new JPanel();
		pnlTituloFilaDeBloqueados.setLayout(new FlowLayout());
		pnlFilaDeBloqueados.add(pnlTituloFilaDeBloqueados, BorderLayout.NORTH);
		//--------------------------------------------------------------------------------------------------------------------------//
		JLabel lblTituloFilaDeBloqueados = new JLabel("Processos bloqueados");
		pnlTituloFilaDeBloqueados.add(lblTituloFilaDeBloqueados);
		//--------------------------------------------------------------------------------------------------------------------------//
		  								 //CENTRO DA TELA -> PROCESSADOR -> FILA DE BLOQUEADOS -> TABELA//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTabelaProcessosBloqueados = new JPanel();
		pnlTabelaProcessosBloqueados.setLayout(new FlowLayout());
		pnlFilaDeBloqueados.add(pnlTabelaProcessosBloqueados, BorderLayout.CENTER);
		//--------------------------------------------------------------------------------------------------------------------------//
		objProcessosBloqueados = new clsTabelaProcessosBloqueados(256, 150, 240);
		JScrollPane scrProcessosBloqueados = new JScrollPane(objProcessosBloqueados.getTable());
		pnlTabelaProcessosBloqueados.add(scrProcessosBloqueados);
		//--------------------------------------------------------------------------------------------------------------------------//
		  								 	 //CENTRO DA TELA -> PROCESSADOR -> DETALHES//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlDetalhesProcessador = new JPanel();
		pnlDetalhesProcessador.setLayout(new GridLayout(3,1));
		pnlProcessador.add(pnlDetalhesProcessador, BorderLayout.CENTER);
		//--------------------------------------------------------------------------------------------------------------------------//
		  							//CENTRO DA TELA -> PROCESSADOR -> DETALHES -> TEMPO DE EXECU��O//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTempoDeExecucao = new JPanel();
		pnlTempoDeExecucao.setLayout(new BorderLayout());
		pnlTempoDeExecucao.setBorder(BorderFactory.createEtchedBorder(1));
		pnlDetalhesProcessador.add(pnlTempoDeExecucao);
		//--------------------------------------------------------------------------------------------------------------------------//
		  						//CENTRO DA TELA -> PROCESSADOR -> DETALHES -> TEMPO DE EXECU��O -> T�TULO//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTituloTempoDeExecucao = new JPanel();
		pnlTituloTempoDeExecucao.setLayout(new FlowLayout());
		pnlTempoDeExecucao.add(pnlTituloTempoDeExecucao, BorderLayout.NORTH);
		//--------------------------------------------------------------------------------------------------------------------------//
		JLabel lblTituloTempoDeExecucao = new JLabel("Tempo de Execu��o");
		pnlTituloTempoDeExecucao.add(lblTituloTempoDeExecucao);
		//--------------------------------------------------------------------------------------------------------------------------//
		  						//CENTRO DA TELA -> PROCESSADOR -> DETALHES -> TEMPO DE EXECU��O -> TABELA//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTabelaTempoDeExecucao = new JPanel();
		pnlTabelaTempoDeExecucao.setLayout(new FlowLayout());
		pnlTempoDeExecucao.add(pnlTabelaTempoDeExecucao, BorderLayout.CENTER);
		//--------------------------------------------------------------------------------------------------------------------------//
		objTabelaTempoTotal = new clsTabelaTempoTotal(100, 16);
		JScrollPane scrTempoDeExecucao = new JScrollPane(objTabelaTempoTotal.getTable());
		pnlTabelaTempoDeExecucao.add(scrTempoDeExecucao);
		//--------------------------------------------------------------------------------------------------------------------------//
		  							//CENTRO DA TELA -> PROCESSADOR -> DETALHES -> EM EXECU��O//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlEmExecucao = new JPanel();
		pnlEmExecucao.setLayout(new BorderLayout());
		pnlEmExecucao.setBorder(BorderFactory.createEtchedBorder(1));
		pnlDetalhesProcessador.add(pnlEmExecucao);
		//--------------------------------------------------------------------------------------------------------------------------//
		  						//CENTRO DA TELA -> PROCESSADOR -> DETALHES -> EM EXECU��O -> T�TULO//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTituloEmExecucao = new JPanel();
		pnlTituloEmExecucao.setLayout(new FlowLayout());
		pnlEmExecucao.add(pnlTituloEmExecucao, BorderLayout.NORTH);
		//--------------------------------------------------------------------------------------------------------------------------//
		JLabel lblTituloEmExecucao = new JLabel("Em Execu��o");
		pnlTituloEmExecucao.add(lblTituloEmExecucao);
		//--------------------------------------------------------------------------------------------------------------------------//
		  						//CENTRO DA TELA -> PROCESSADOR -> DETALHES -> EM EXECU��O -> TABELA//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlTabelaEmExecucao = new JPanel();
		pnlTabelaEmExecucao.setLayout(new FlowLayout());
		pnlEmExecucao.add(pnlTabelaEmExecucao, BorderLayout.CENTER);
		//--------------------------------------------------------------------------------------------------------------------------//
		objProcessoEmExecucao = new clsTabelaProcessoEmExecucao(250, 16, objProcessosBloqueados, objTabelaProcessos);
		JScrollPane scrEmExecucao = new JScrollPane(objProcessoEmExecucao.getTable());
		pnlTabelaEmExecucao.add(scrEmExecucao);
		//--------------------------------------------------------------------------------------------------------------------------//
		  							     //CENTRO DA TELA -> PROCESSADOR -> DETALHES -> CLOCK//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlClock = new JPanel();
		pnlClock.setLayout(new BorderLayout());
		pnlClock.setBorder(BorderFactory.createEtchedBorder(1));
		pnlDetalhesProcessador.add(pnlClock);
		//--------------------------------------------------------------------------------------------------------------------------//
		  							 //CENTRO DA TELA -> PROCESSADOR -> DETALHES -> CLOCK -> COR//
		//--------------------------------------------------------------------------------------------------------------------------//
		objProcessador = new clsEscalonador(pnlClock, 1000, objTabelaProcessos, objProcessosBloqueados, objMemoriaPrincipal, objMemoriaSecundaria, objTabelaTempoTotal, objProcessoEmExecucao);
		//--------------------------------------------------------------------------------------------------------------------------//
		  													      //RODAP� DA TELA//
		//--------------------------------------------------------------------------------------------------------------------------//
		JPanel pnlInferior = new JPanel();
		pnlInferior.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//--------------------------------------------------------------------------------------------------------------------------//
		  				   									//RODAP� DA TELA -> BOT�ES//
		//--------------------------------------------------------------------------------------------------------------------------//
		JButton btnSobre = new JButton("Sobre...");
		pnlInferior.add(btnSobre);
		btnSobre.addActionListener
										(
											new ActionListener()
											{
												public void actionPerformed(ActionEvent e)
												{
													frmSobre sobre = new frmSobre();
												}
											}		
										);
		//--------------------------------------------------------------------------------------------------------------------------//
		JButton btnFechar = new JButton("Fechar");
		pnlInferior.add(btnFechar);
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
		tela.add(pnlCentro, BorderLayout.CENTER);
		tela.add(pnlInferior, BorderLayout.SOUTH);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	} 
	//--------------------------------------------------------------------------------------------------------------------------//
	  				   												//MAIN//
	//--------------------------------------------------------------------------------------------------------------------------//
	public static void main(String args[])
	{
		frmPrincipal Janela = new frmPrincipal();
		Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
}
