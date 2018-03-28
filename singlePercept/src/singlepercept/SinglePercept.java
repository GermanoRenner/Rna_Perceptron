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
public class SinglePercept {
    
    private static final Double[][] amostras = new Double[][] {{1d,1d},
                                                              {0d,1d},
                                                              {1d,0d},
                                                              {0d,1d}
                                                        };
    
    private static final Double[] esperados = new Double[]{1d,0d,1d,0d}; //1 = DENTISTA && 0 = PROFESSOR 
    private Double[] pesos = new Double[]{0d,0d};
    
        
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        neuronio rede = new neuronio(amostras,esperados);
        rede.treinar();
        
        Double resposta = rede.classificar(new Double[] {1d,0d});
        
        
        System.out.println((resposta == 0d) ? "Professor" : "Dentista");
    }
    
}
