import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.event.*;
public class clsTabelaCor 
{
	//--------------------------------------------------------------------------------------------------------------------------//
  																//ATRIBUTOS//
	//--------------------------------------------------------------------------------------------------------------------------//    
    JTable tblTabela;
    Color cor;
	//--------------------------------------------------------------------------------------------------------------------------//
  																//CONSTRUTOR//
	//--------------------------------------------------------------------------------------------------------------------------//
    public clsTabelaCor(int pLargula, int pAltura) 
    {
    	tblTabela = new JTable();
    	cor = Color.YELLOW;
    	tblTabela.setPreferredScrollableViewportSize(new Dimension(pLargula,pAltura));
    	tblTabela.setTableHeader(null);
    	tblTabela.setRowHeight(pAltura);
    	atribuirModelo();
    	atribuirRenderer();
    	atribuirListeners();
    }
	//--------------------------------------------------------------------------------------------------------------------------//
  															  //FUN��ES P�BLICAS//
	//--------------------------------------------------------------------------------------------------------------------------// 
	//--------------------------------------------------------------------------------------------------------------------------//
  												  //FUN��ES P�BLICAS -> GETTERS AND SETTERS//
	//--------------------------------------------------------------------------------------------------------------------------// 
	//--------------------------------------------------------------------------------------------------------------------------//
  											 //FUN��ES P�BLICAS -> GETTERS AND SETTERS -> TABLE//
	//--------------------------------------------------------------------------------------------------------------------------// 
	public JTable getTable()
	{
		return tblTabela;
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  											  //FUN��ES P�BLICAS -> GETTERS AND SETTERS -> COR//
	//--------------------------------------------------------------------------------------------------------------------------//  
    public void setCor()
    {
    	cor = new JColorChooser().showDialog(null, "Selecione uma cor", cor);
    	atualizarTabela();
    }
    public Color getCor()
    {
    	return cor;
    }
	//--------------------------------------------------------------------------------------------------------------------------//
  											              //FUN��ES P�BLICAS -> WORK//
	//--------------------------------------------------------------------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------//
  											    //FUN��ES P�BLICAS -> WORK -> ATUALIZAR TABELA//
	//--------------------------------------------------------------------------------------------------------------------------//
	public void atualizarTabela()
	{
		tblTabela.updateUI();
	}
	//--------------------------------------------------------------------------------------------------------------------------//
  															 //FUN��ES PRIVADAS//
	//--------------------------------------------------------------------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------//
  												  //FUN��ES PRIVADAS -> ATRIBUIR RENDERER//
	//--------------------------------------------------------------------------------------------------------------------------//
    private void atribuirRenderer()
    {
		tblTabela.setDefaultRenderer(Object.class, 
										new DefaultTableCellRenderer()
										{
									   		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col)
									   		{
									   			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
									   			setBackground(cor);
									   			return this;
									   		}		
										}
									);
    }
	//--------------------------------------------------------------------------------------------------------------------------//
  												 //FUN��ES PRIVADAS -> ATRIBUIR MODELO//
	//--------------------------------------------------------------------------------------------------------------------------//
    private void atribuirModelo()
    {
    	tblTabela.setModel(
							new AbstractTableModel()
							{
								public int getColumnCount()
								{
									return 1;
								}
								public int getRowCount()
								{
									return 1;
								}
								public Object getValueAt(int row, int col)
								{
									return new String("");
								}
							}
						   );
    }	
	//--------------------------------------------------------------------------------------------------------------------------//
  												 //FUN��ES PRIVADAS -> ATRIBUIR LISTENERS//
	//--------------------------------------------------------------------------------------------------------------------------//
    private void atribuirListeners()
    {
		tblTabela.addMouseListener(
									new MouseAdapter()
									{
									    public void mouseClicked(MouseEvent me) 
									    {  
									    	setCor();  
									    }  		
									}
								  );
    }	     
}