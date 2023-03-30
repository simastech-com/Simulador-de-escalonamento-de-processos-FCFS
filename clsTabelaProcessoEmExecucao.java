import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.event.*;
public class clsTabelaProcessoEmExecucao 
{
	//--------------------------------------------------------------------------------------------------------------------------//
  																//ATRIBUTOS//
	//--------------------------------------------------------------------------------------------------------------------------//
	JTable tblTabela;
	clsProcesso objProcesso;
	clsTabelaProcessosBloqueados objTabelaProcessosBloqueados;
	clsTabelaProcesso objListaProcessos;
	int tempo;
	//--------------------------------------------------------------------------------------------------------------------------//
  																//CONSTRUTOR//
	//--------------------------------------------------------------------------------------------------------------------------//
    public clsTabelaProcessoEmExecucao(int pLargura, int pAltura, clsTabelaProcessosBloqueados pProcessosBloqueados, clsTabelaProcesso pProcessos) 
    {
    	tempo = 0;
    	objProcesso = new clsProcesso();
    	objTabelaProcessosBloqueados = pProcessosBloqueados;
    	objListaProcessos = pProcessos;
    	tblTabela = new JTable();
    	tblTabela.setPreferredScrollableViewportSize(new Dimension(pLargura, pAltura));
    	atribuirRenderer();
    	atribuirModelo();
    }
	//--------------------------------------------------------------------------------------------------------------------------//
  															  //FUNÇÕES PÚBLICAS//
	//--------------------------------------------------------------------------------------------------------------------------// 
	//--------------------------------------------------------------------------------------------------------------------------//
  												  //FUNÇÕES PÚBLICAS -> GETTERS AND SETTERS//
	//--------------------------------------------------------------------------------------------------------------------------// 
	//--------------------------------------------------------------------------------------------------------------------------//
  											  //FUNÇÕES PÚBLICAS -> GETTERS AND SETTERS -> TEMPO//
	//--------------------------------------------------------------------------------------------------------------------------//
	public String getTempo()
	{
		if (tempo == 0 || objProcesso.getIntPid() == -1)
		{
			return "";
		}
		return Integer.toString(tempo);
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											  //FUNÇÕES PÚBLICAS -> GETTERS AND SETTERS -> TABLE//
	//--------------------------------------------------------------------------------------------------------------------------//
    public JTable getTable()
    {
    	return tblTabela;
    }
	//--------------------------------------------------------------------------------------------------------------------------//
  											              //FUNÇÕES PÚBLICAS -> WORK//
	//--------------------------------------------------------------------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------//
  											    //FUNÇÕES PÚBLICAS -> WORK -> ATUALIZAR TABELA//
	//--------------------------------------------------------------------------------------------------------------------------//
	public void atualizarTabela()
	{
		tblTabela.updateUI();
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											    //FUNÇÕES PÚBLICAS -> WORK -> REMOVER PROCESSO//
	//--------------------------------------------------------------------------------------------------------------------------//
	public void removerProceso(clsProcesso pProcesso)
	{
		if (pProcesso.getIntPid() == objProcesso.getIntPid())
		{
			objProcesso.restaurar();
			tempo = 0;
		}
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											    //FUNÇÕES PÚBLICAS -> WORK -> INCREMENTAR TEMPO//
	//--------------------------------------------------------------------------------------------------------------------------//
	public boolean incrementarTempo()
	{
		boolean retorno = false;
		if (objProcesso.getIntPid() != -1)
		{
			tempo++;
			if (tempo > objProcesso.getIntTempo())
			{
				tempo = 0;
				retorno = true;
			}
			else
			{
				objListaProcessos.incrementarTempoDeCpu(objProcesso);	
			}
			atualizarTabela();
		}
		else
		{
			retorno = true;
		}
		return retorno;
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											    //FUNÇÕES PÚBLICAS -> WORK -> EXECUTAR PROCESSO//
	//--------------------------------------------------------------------------------------------------------------------------//
	public void executarProcesso(clsTabelaMemoria pMemoriaPrincipal, clsTabelaMemoria pMemoriaSecundaria)
	{
		clsProcesso auxiliar;
		auxiliar = objTabelaProcessosBloqueados.obterProcessoAExecutar();
		if (auxiliar.getIntPid() != -1)
		{
			objProcesso.setCor(auxiliar.getCor());
			objProcesso.setEstado(auxiliar.getEstado());
			objProcesso.setFrames(auxiliar.getIntFrames());
			objProcesso.setPid(auxiliar.getIntPid());
			objProcesso.setSelecionado(auxiliar.getSelecionado());
			objProcesso.setTempo(auxiliar.getIntTempo());
			objProcesso.setTempoCriacao(auxiliar.getIntTempoCriacao());
			objProcesso.setTempoUcp(auxiliar.getIntTempoUcp());
			objProcesso.setTipo(auxiliar.getTipo());
			objProcesso.setEliminado(auxiliar.getEliminado());
			objListaProcessos.atualizarEstados(auxiliar);
		}
		atualizarTabela();
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											    //FUNÇÕES PÚBLICAS -> WORK -> EXECUTAR PROCESSO//
	//--------------------------------------------------------------------------------------------------------------------------//
	public void bloquearProcesso(clsTabelaMemoria pMemoriaPrincipal, clsTabelaMemoria pMemoriaSecundaria)
	{
		if (objProcesso.getIntPid() != -1)
		{
			objTabelaProcessosBloqueados.adicionarProcesso(objProcesso, pMemoriaPrincipal, pMemoriaSecundaria);
			objProcesso.restaurar();
			objTabelaProcessosBloqueados.atualizarTabela();
		}
		atualizarTabela();
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  															 //FUNÇÕES PRIVADAS//
	//--------------------------------------------------------------------------------------------------------------------------//
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
									            setBackground(objProcesso.getCor());
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
								String colunas[] = {"Processo", "Tempo"};
								public int getColumnCount()
								{
									return 2;
								}
								public int getRowCount()
								{
									return 1;
								}	
								public Object getValueAt(int row, int col)
								{
									if (col == 0)
									{
										return new String(objProcesso.getPid());
									}
									return new String(getTempo());
								}
								public String getColumnName(int num)
								{
									return colunas[num];
								}
    						}
    					  );		
    }
}