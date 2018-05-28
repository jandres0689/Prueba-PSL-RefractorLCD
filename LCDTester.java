import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import javax.swing.JOptionPane;

/*
 * GNU-GPL.
 */

/**
 *Programa para imprimir valores numericos entre 0 y 9 con estilo al de una pantalla lcd.
 * 
 */

public class LCDTester {

    static final String CADENA_FINAL = "0,0";
    
    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        String comando;
        int espacioDig;
        
        try {
            
            try  {
                
                comando=JOptionPane.showInputDialog("Espacio entre Digitos (0 a 5): ");
            
                // Valida si es un numero
                if (ImpresorLCD.isNumeric(comando)) 
                {
                    espacioDig = Integer.parseInt(comando);
                    
                    // se valida que el espaciado este entre 0 y 5
                    if(espacioDig <0 || espacioDig >5)
                    {
                        //Se imprime mensaje de advertencia al usuario en caso de que el espaciado este por fuera del rango establecido
                        throw new IllegalArgumentException("El espacio entre "
                                + "digitos debe estar entre 0 y 5");
                    }
                    
                } 
                else 
                {  //Se imprime mensaje de advertencia al usuario en caso de que el numero ingresado no sea un entero,sea menor de 0(cero) y/o contenga caracteres no permitidos.
                     JOptionPane.showMessageDialog(null,"Se cancelo la actividad","Mensaje de Advertencia",JOptionPane.WARNING_MESSAGE); 
                  
                    throw new IllegalArgumentException("Cadena " + comando
                            + " no es un entero"+"\r\n"+"Los valores ingresados deben ser enteros mayores de cero y no contener caracteres que no esta ralacionados a estos nùmeros.");
                }
                
                do
                {
                   
                    comando=JOptionPane.showInputDialog("Ingrese en tamaño y los numeros a imprimir de la siguiente manera \"tamaño,numeros\" :","0,0");
                    
                    if(comando==null)
                    {
                        //Se instacia comando a 0,0 para cancelar la actividad.
                        comando="0,0";
                        JOptionPane.showMessageDialog(null,"Se cancelo la actividad","Mensaje de Advertencia",JOptionPane.WARNING_MESSAGE); 
                    }
                    else
                    {
                       
           ImpresorLCD impresorLCD = new ImpresorLCD();
            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext()) 
            {
                try 
                {
                    impresorLCD.procesar(iterator.next(), espacioDig);
                    
                } catch (Exception ex) 
                {
                    System.out.println("Error: "+ex.getMessage());
                }
            }
        } 
                    
   
                    if(comando.equalsIgnoreCase(CADENA_FINAL))
                    {
                    } else {
                        listaComando.add(comando);
                    }
                }while (!comando.equalsIgnoreCase(CADENA_FINAL)); 
                
                
            }catch(HeadlessException | IllegalArgumentException e){}

            
        } catch (IllegalArgumentException ex) 
        {
            System.out.println("Error: "+ex.getMessage());
        }

    }

}

    
