/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlepercept;

/**
 *
 * @author Germa
 */
public class neuronio {
    
    private int txAprend = 1;
    private Double[][] amostras;
    private Double[] esperados;
    private Double[] pesos = {0.0,0.0};
    private int epocas;
    
    
    
    public neuronio(Double[][] amostras, Double[] esperados){
        this.amostras  = amostras;
        this.esperados = esperados;
        this.epocas = 0 ;
    }
    
    public void treinar(){
        Boolean erro ;
        //Double[] u;
        //System.out.println(amostras.length);
        do{
            erro = Boolean.FALSE;
            
            for(int i=0; i < amostras.length;i++){
                Double u1    = somatorio(i);
                Double saida = funcaoSaida(u1);
                
                if(!saida.equals(esperados[i])){
                    this. recalcularPesos(i,saida);
                    erro = Boolean.TRUE;
                }    
            }
            epocas++;
            
        }while(erro && epocas <500);
    }    
        
    
    
    
    //FUNCAO PARA FAZER O SOMATORIO
    public Double somatorio(int i){
        Double u = 0d ;
        
        for(int j=0; j < pesos.length; j++){
            u += amostras[i][j]*pesos[j];
        }
        return u;
    }
    
    //FUNCAO DE ATIVAÇÃO 
    public double funcaoSaida(double u){
        
       return (u > 1d) ? 1d : 0d;
        
    }
    
    
    //FUNÇÃO PARA RECALCULAR OS PESOS
    public void recalcularPesos(int i,Double saida){
        
        Double aprendizado = txAprend * (esperados[i]-saida);
        for(int j=0 ; j <pesos.length ; j++ ){
            pesos[j] += aprendizado*amostras[i][j];
        }
    }
    
    public double classificar(Double[] entradas){
        Double u = 0d;
        for(int i = 0 ; i<pesos.length ; i++){
            u+= entradas[i]*pesos[i];
        }
        return this.funcaoSaida(u);
    }
    
}    

