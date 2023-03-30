import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.event.*;
public class clsEscalonador 
{
	//--------------------------------------------------------------------------------------------------------------------------//
  																//ATRIBUTOS//
	//--------------------------------------------------------------------------------------------------------------------------//  
	Timer timer;
	int tempo;
	JPanel pnlClock;
	boolean bloqueou = false;
	clsTabelaProcesso objTabelaProcessos;
	clsTabelaProcessosBloqueados objTabelaProcessosBloqueados;
	clsTabelaMemoria objMemoriaPrincipal;
	clsTabelaMemoria objMemoriaSecundaria;
	clsTabelaTempoTotal objTempoTotal;
	clsTabelaProcessoEmExecucao objProcessoEmExecucao;
	//--------------------------------------------------------------------------------------------------------------------------//
  																//CONSTRUTOR//
	//--------------------------------------------------------------------------------------------------------------------------//
    public clsEscalonador(JPanel pPanel, int pTempo, clsTabelaProcesso pProcesso, clsTabelaProcessosBloqueados pProcessosBloqueados, clsTabelaMemoria pMemoriaPrincipal, clsTabelaMemoria pMemoriaSecundaria, clsTabelaTempoTotal pTempoTotal, clsTabelaProcessoEmExecucao pProcessoEmExecucao) 
    {
    	pnlClock = pPanel;
    	tempo = pTempo;
    	objTabelaProcessos = pProcesso;
    	objTabelaProcessosBloqueados = pProcessosBloqueados;
    	objMemoriaPrincipal = pMemoriaPrincipal;
    	objMemoriaSecundaria = pMemoriaSecundaria;
    	objTempoTotal = pTempoTotal;
    	objProcessoEmExecucao = pProcessoEmExecucao;
		carregarClock();
    	iniciar();
    }
	//--------------------------------------------------------------------------------------------------------------------------//
  															  //FUN��ES P�BLICAS//
	//--------------------------------------------------------------------------------------------------------------------------// 
	
	//--------------------------------------------------------------------------------------------------------------------------//
  												  //FUN��ES P�BLICAS -> GETTERS AND SETTERS//
	//--------------------------------------------------------------------------------------------------------------------------// 
	//--------------------------------------------------------------------------------------------------------------------------//
  											 //FUN��ES P�BLICAS -> GETTERS AND SETTERS -> PULSOU//
	//--------------------------------------------------------------------------------------------------------------------------//
	
	//--------------------------------------------------------------------------------------------------------------------------//
  											              //FUN��ES P�BLICAS -> WORK//
	//--------------------------------------------------------------------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------//
  											        //FUN��ES P�BLICAS -> WORK -> INICIAR//
	//--------------------------------------------------------------------------------------------------------------------------//
    public void iniciar()
    {
    	timer.start();
    }
	//--------------------------------------------------------------------------------------------------------------------------//
  											         //FUN��ES P�BLICAS -> WORK -> PARAR//
	//--------------------------------------------------------------------------------------------------------------------------//
    public void parar()
    {
    	timer.stop();
    }
	//--------------------------------------------------------------------------------------------------------------------------//
  															 //FUN��ES PRIVADAS//
	//--------------------------------------------------------------------------------------------------------------------------//
	//--------------------------------------------------------------------------------------------------------------------------//
  												    //FUN��ES PRIVADAS -> CARREGAR CLOCK//
	//--------------------------------------------------------------------------------------------------------------------------//
    private void carregarClock()
    {
	    timer = new javax.swing.Timer(tempo, 
			    							new ActionListener() 
			    							{  
										        public void actionPerformed(ActionEvent e) 
										        {  
										            if (pnlClock.getBackground() == Color.RED) 
										            {  
										                pnlClock.setBackground(Color.WHITE);
										            }
										            else
										            {  
														pnlClock.setBackground(Color.RED);
														objTabelaProcessos.incrementarTempoDeCriacao();
														objTempoTotal.incrementarValor();
														if (bloqueou)
														{
															objProcessoEmExecucao.executarProcesso(objMemoriaPrincipal, objMemoriaSecundaria);
														}
														bloqueou = objProcessoEmExecucao.incrementarTempo();
														if (bloqueou)
														{
															objProcessoEmExecucao.bloquearProcesso(objMemoriaPrincipal, objMemoriaSecundaria);
														}
														objMemoriaPrincipal.desfragmentar();
										            }     
										        }  
			    							}
			    						 );
    }		
}