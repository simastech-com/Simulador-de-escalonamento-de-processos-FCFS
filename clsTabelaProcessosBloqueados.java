import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.event.*;
public class clsTabelaProcessosBloqueados 
{
	//--------------------------------------------------------------------------------------------------------------------------//
  																//ATRIBUTOS//
	//--------------------------------------------------------------------------------------------------------------------------//
	clsProcesso vetProcessos[];
    JTable tblTabela;
    int linhas;
	//--------------------------------------------------------------------------------------------------------------------------//
  																//CONSTRUTOR//
	//--------------------------------------------------------------------------------------------------------------------------//
    public clsTabelaProcessosBloqueados(int pLinhas, int pLargura, int pAltura) 
    {
    	linhas = pLinhas;
    	vetProcessos = new clsProcesso[linhas];
    	tblTabela = new JTable();
    	inicializarVetor(linhas);
    	atribuirModelo();
    	atribuirRenderer();
    	tblTabela.setPreferredScrollableViewportSize(new Dimension(pLargura, pAltura));
    }
	//--------------------------------------------------------------------------------------------------------------------------//
  															  //FUNÇÕES PÚBLICAS//
	//--------------------------------------------------------------------------------------------------------------------------// 
	//--------------------------------------------------------------------------------------------------------------------------//
  												  //FUNÇÕES PÚBLICAS -> GETTERS AND SETTERS//
	//--------------------------------------------------------------------------------------------------------------------------// 
	//--------------------------------------------------------------------------------------------------------------------------//
  											  //FUNÇÕES PÚBLICAS -> GETTERS AND SETTERS -> TABLE//
	//--------------------------------------------------------------------------------------------------------------------------//
    public JTable getTable()
    {
    	return tblTabela;
    }
	//--------------------------------------------------------------------------------------------------------------------------//
  								           //FUNÇÕES PÚBLICAS -> WORK -> OBTER PROCESSO A EXECUTAR//
	//--------------------------------------------------------------------------------------------------------------------------//
	public clsProcesso obterProcessoAExecutar()
	{
		clsProcesso retorno = new clsProcesso();
		if (vetProcessos[0].getIntPid() != -1)
		{
			retorno.setCor(vetProcessos[0].getCor());
			retorno.setEstado(vetProcessos[0].getEstado());
			retorno.setFrames(vetProcessos[0].getIntFrames());
			retorno.setPid(vetProcessos[0].getIntPid());
			retorno.setSelecionado(vetProcessos[0].getSelecionado());
			retorno.setTempo(vetProcessos[0].getIntTempo());
			retorno.setTempoCriacao(vetProcessos[0].getIntTempoCriacao());
			retorno.setTempoUcp(vetProcessos[0].getIntTempoUcp());
			retorno.setTipo(vetProcessos[0].getTipo());
			retorno.setEliminado(vetProcessos[0].getEliminado());
			eliminarProcesso(vetProcessos[0].getIntPid());
		}
		atualizarTabela();
		return retorno;
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											              //FUNÇÕES PÚBLICAS -> WORK//
	//--------------------------------------------------------------------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------//
  											  //FUNÇÕES PÚBLICAS -> WORK -> ADICIONAR PROCESSO//
	//--------------------------------------------------------------------------------------------------------------------------//
	public void adicionarProcesso(clsProcesso pProcesso, clsTabelaMemoria pMemoriaPrincipal, clsTabelaMemoria pMemoriaSecundaria)
	{
		int linha;
		linha = getPosicaoVazia();
		vetProcessos[linha].setPid(pProcesso.getIntPid());
		vetProcessos[linha].setCor(pProcesso.getCor());
		vetProcessos[linha].setFrames(pProcesso.getIntFrames());
		vetProcessos[linha].setEstado(pProcesso.getEstado());
		vetProcessos[linha].setSelecionado(pProcesso.getSelecionado());
		vetProcessos[linha].setTempo(pProcesso.getIntTempo());
		vetProcessos[linha].setTempoCriacao(pProcesso.getIntTempoCriacao());
		vetProcessos[linha].setTempoUcp(pProcesso.getIntTempoUcp());
		vetProcessos[linha].setTipo(pProcesso.getTipo());
		vetProcessos[linha].setEliminado(pProcesso.getEliminado());
		escalonarMemoria(pMemoriaPrincipal, pMemoriaSecundaria);
		atualizarTabela();
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											  //FUNÇÕES PÚBLICAS -> WORK -> ELIMINAR PROCESSO//
	//--------------------------------------------------------------------------------------------------------------------------//
	public void eliminarProcesso(int Pid)
	{
		int x = getPosicaoPid(Pid);
		if (x!=-1)
		{
			do
			{
				vetProcessos[x].setCor(vetProcessos[x+1].getCor());
				vetProcessos[x].setEstado(vetProcessos[x+1].getEstado());
				vetProcessos[x].setFrames(vetProcessos[x+1].getIntFrames());
				vetProcessos[x].setPid(vetProcessos[x+1].getIntPid());
				vetProcessos[x].setSelecionado(vetProcessos[x+1].getSelecionado());
				vetProcessos[x].setTempoCriacao(vetProcessos[x+1].getIntTempoCriacao());
				vetProcessos[x].setTempoUcp(vetProcessos[x+1].getIntTempoUcp());
				vetProcessos[x].setTipo(vetProcessos[x+1].getTipo());
				vetProcessos[x].setEliminado(vetProcessos[x+1].getEliminado());
				x++;
			}while(x < linhas && vetProcessos[x].getIntPid() != -1);
			atualizarTabela();
		}
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											    //FUNÇÕES PÚBLICAS -> WORK -> ATUALIZAR TABELA//
	//--------------------------------------------------------------------------------------------------------------------------//
	public void atualizarTabela()
	{
		tblTabela.updateUI();
	}	
	//--------------------------------------------------------------------------------------------------------------------------//
  															 //FUNÇÕES PRIVADAS//
	//--------------------------------------------------------------------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------//
  												   //FUNÇÕES PRIVADAS -> INICIALIZAR VETOR//
	//--------------------------------------------------------------------------------------------------------------------------//
    private void inicializarVetor(int linhas)
    {
		for(int y=0; y<linhas; y++)
		{
			vetProcessos[y] = new clsProcesso();
		}
    }
	//--------------------------------------------------------------------------------------------------------------------------//
  												  //FUNÇÕES PRIVADAS -> ATRIBUIR RENDERER//
	//--------------------------------------------------------------------------------------------------------------------------//
    private void atribuirRenderer()
    {
		tblTabela.setDefaultRenderer(Object.class, 
										new DefaultTableCellRenderer()
										{
											public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) 
									        {  
									            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);   
									            setHorizontalAlignment(CENTER);
									            setBackground(vetProcessos[row].getCor());
									            return this; 
									        }	
										}	
									 );
    } 
	//--------------------------------------------------------------------------------------------------------------------------//
  												 //FUNÇÕES PRIVADAS -> ATRIBUIR MODELO//
	//--------------------------------------------------------------------------------------------------------------------------//
    private void atribuirModelo()
    {
    	tblTabela.setModel(
    						new AbstractTableModel()
    						{
								String colunas[] = {"Processo"};
								public int getColumnCount()
								{
									return 1;
								}
								public int getRowCount()
								{
									return linhas;
								}	
								public Object getValueAt(int row, int col)
								{
									return new String(vetProcessos[row].getPid());
								}
								public String getColumnName(int num)
								{
									return colunas[num];
								}
    						}
    					  );		
    }
	//--------------------------------------------------------------------------------------------------------------------------//
  												//FUNÇÕES PRIVADAS -> OBTER POSIÇÃO VAZIA//
	//--------------------------------------------------------------------------------------------------------------------------//
    private int getPosicaoVazia()
   	{
   		int x = 0; 
   		int pos = 0;
   		do
   		{
   			if (vetProcessos[x].getIntPid() == -1)
   			{
   				pos = x;
   			}
   			x++;
   		}while(x < linhas && vetProcessos[x-1].getIntPid() != -1);
		return pos;
   	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											  //FUNÇÕES PRIVADAS -> OBTER POSIÇÃO DO PID//
	//--------------------------------------------------------------------------------------------------------------------------//
	private int getPosicaoPid(int pPid)
	{
		int posicao = -1;
		int y=0;
		do
		{
			if(vetProcessos[y].getIntPid()== pPid)
			{
				posicao = y;	
			}
			y++;
		}while(posicao == -1 && y < linhas);
		return posicao;	
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											    //FUNÇÕES PRIVADAS -> ESCALONAR MEMÓRIA//
	//--------------------------------------------------------------------------------------------------------------------------//
	void escalonarMemoria(clsTabelaMemoria pMemoriaPrincipal, clsTabelaMemoria pMemoriaSecundaria)
	{
		int vInicio = 0;
		int vFim = linhas-1;
		while(vFim > vInicio && vetProcessos[vInicio].getIntPid()!= -1)
		{
			if(vetProcessos[vFim].getIntPid() != -1)
			{
				if (moverParaAMemoriaSecundaria(vetProcessos[vFim], pMemoriaPrincipal, pMemoriaSecundaria))
				{
					while(vInicio <= vFim && vetProcessos[vInicio].getIntPid()!= -1)
					{
						if(moverParaAMemoriaPrincipal(vetProcessos[vInicio], pMemoriaPrincipal, pMemoriaSecundaria))
						{
							break;
						}
						vInicio++;
					}
				}
			}
			vFim--;
		}	
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											//FUNÇÕES PRIVADAS -> MOVER PARA A MEMÓRIA PRINCIPAL//
	//--------------------------------------------------------------------------------------------------------------------------//
	private boolean moverParaAMemoriaPrincipal(clsProcesso pProcesso, clsTabelaMemoria pMemoriaPrincipal, clsTabelaMemoria pMemoriaSecundaria)
	{
		boolean moveu = false;
		if(pMemoriaSecundaria.verificarSeEstaNaMemoria(pProcesso))
		{
			if(pMemoriaPrincipal.adicionarProcesso(pProcesso, 0))
			{
				pMemoriaSecundaria.removerProcesso(pProcesso.getIntPid());
				moveu = true;
			}
		}
		return moveu;
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											//FUNÇÕES PRIVADAS -> MOVER PARA A MEMÓRIA SECUNDARIA//
	//--------------------------------------------------------------------------------------------------------------------------//
	private boolean moverParaAMemoriaSecundaria(clsProcesso pProcesso, clsTabelaMemoria pMemoriaPrincipal, clsTabelaMemoria pMemoriaSecundaria)
	{
		boolean moveu = false;
		if(pMemoriaPrincipal.verificarSeEstaNaMemoria(pProcesso))
		{
			if(pMemoriaSecundaria.adicionarProcesso(pProcesso, 0))
			{
				pMemoriaPrincipal.removerProcesso(pProcesso.getIntPid());
				moveu = true;
			}
		}
		return moveu;
	}

}