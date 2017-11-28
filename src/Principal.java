/**
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal{
		
	public static void main(String args[]){
		AlgoritmoGenetico ag = new AlgoritmoGenetico();
		ag.setQuantidadeGeracoes(12);
		ag.setTamanhoPopulacao(8);
		ag.setTamanhoCromossomo(4);
		ag.setPercentualMutacao(0.05); //5% de mutacao
		ag.executa();
	}	
}

