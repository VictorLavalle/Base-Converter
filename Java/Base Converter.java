
package convertidordebases;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Interfaz extends javax.swing.JFrame {

    public Interfaz() {
        initComponents();
    }
     //Funcion que sirve para convertir de decimal a cualquier base
    static void convertobase(int  modulo,long numero){
        //Declaracion del ArrayList//
            ArrayList<Integer>residuos= new ArrayList();
            //Auxiliares//
            int divisor=modulo;
            int dividendo=(int) numero;
            //Consideracion del caso donde se ingrese un 0//
            if (dividendo==0){
                residuos.add(dividendo%divisor);
            }else{
               //Descompocision del numero decimal//
               while(dividendo!=0){
              residuos.add(dividendo%divisor);
              dividendo= dividendo/divisor;
            
            } 
            }
            //Auxiliar para almacenar el string de la cadena invertida//
            String cadenares="";
           if (modulo!=16){
            for (int i=residuos.size()-1;i>=0;i--){
                //Pasamos al string y concadenamos los digitos de la forma deseada//
                cadenares=cadenares + Integer.toString(residuos.get(i));
            }
           }else{
               for (int i=residuos.size()-1;i>=0;i--){
                switch(residuos.get(i)){
                    case 0: case 1:case 2:case 3:case 4:case 5:case 6:case 7:case 8:case 9:
                       cadenares=cadenares + Integer.toString(residuos.get(i));
                    break;
                    case 10:
                        cadenares=cadenares + "A";
                    break;
                    case 11:
                        cadenares=cadenares + "B";
                    break;
                    case 12:
                        cadenares=cadenares + "C";
                    break;
                    case 13:
                        cadenares=cadenares + "D";
                    break;
                    case 14:
                        cadenares=cadenares + "E";
                    break;
                    case 15:
                        cadenares=cadenares + "F";
                    break;
                }
            }
           }
           
          JOptionPane.showMessageDialog(null,"Resultado: "+cadenares);
    
    }
    //Metodo para convertir de cualquier base a decimal//
    static long convertirtodecimal(int base,long numero){
        int exp=0;
        long acumulador=0;
        while(numero!=0){
            acumulador+=(numero%10)*(int)Math.pow(base,exp);
            exp++;
            numero/=10;
        }
         return acumulador;
    }
    //Funcion para convertir a base 16//
    static long converto16(int base,String num){
        ArrayList<String>inversonum= new ArrayList();
    //Sacamos el tamaño de la cadena//
        int tamaño=num.length();
    //Declaramos nuestro axuliar para inverir la cadena//
    String numord="";
    //Invertir la cadena//
        for (int i=tamaño-1;i>=0;i--){
		numord= numord+ num.charAt(i);
        }
     //copiamos en la lista//
        for (int i=0;i<tamaño;i++){
		inversonum.add(Character.toString(numord.charAt(i)));
        }
      long acumulador=0;
       for(int i=0;i<tamaño;i++){
           if(!"A".equals(inversonum.get(i))&&!"B".equals(inversonum.get(i))&&!"C".equals(inversonum.get(i))&&!"D".equals(inversonum.get(i))&&!"E".equals(inversonum.get(i))&&!"F".equals(inversonum.get(i))){
               acumulador+=Long.parseLong(inversonum.get(i))*(int)Math.pow(base,i);
           }else{  
               switch(inversonum.get(i)){
                   case "A": 
                       acumulador+=10*(int)Math.pow(base,i);
                    break;
           
                    case "B": 
                       acumulador+=11*(int)Math.pow(base,i);
                    break;
                    case "C": 
                       acumulador+=12*(int)Math.pow(base,i);
                    break;
                    case "D":
                       acumulador+=13*(int)Math.pow(base,i);
                    break;
                    case "E": 
                       acumulador+=14*(int)Math.pow(base,i);
                    break;
                    case "F": 
                       acumulador+=15*(int)Math.pow(base,i);
                    break;
               }   
           }        
       }
      //Imprimir cadena
      return acumulador;
    }
    //Validacion de del numero segun su base//
    static int validacion(int base,String numero,int band){
        switch (base){
            case 2:
              for(int i=0;i<numero.length();i++){
                char c=numero.charAt(i);
                if (c!='0'&& c!='1'){
                    band=0;
                    break;
                }else{band=1;}
                } 
              
                break;
            case 3:
                for(int i=0;i<numero.length();i++){
                char c=numero.charAt(i);
                if (c!='0'&& c!='1'&&c!='2'){
                    band=0;
                    break;
                }else{band=1;}
                } 
            break;
            case 4:
                for(int i=0;i<numero.length();i++){
                char c=numero.charAt(i);
                if (c!='0'&& c!='1'&& c!='2'&&c!='3'){
                    band=0;
                    break;
                }else{band=1;}
                } 
            break;
            case 5:
                for(int i=0;i<numero.length();i++){
                char c=numero.charAt(i);
                if (c!='0'&& c!='1'&&c!='2'&&c!='3'&&c!='4'){
                    band=0;
                    break;
                }else{band=1;}
                } 
            break;
            case 6:
                for(int i=0;i<numero.length();i++){
                char c=numero.charAt(i);
                if (c!='0'&& c!='1'&&c!='2'&& c!='3'&&c!='4'&& c!='5'){
                    band=0;
                    break;
                }else{band=1;}
                } 
            break;
            case 7:
                for(int i=0;i<numero.length();i++){
                char c=numero.charAt(i);
                if (c!='0'&& c!='1'&&c!='2'&& c!='3'&&c!='4'&& c!='5'&& c!='6'){
                    band=0;
                    break;
                }else{band=1;}
                } 
            break;
            case 8:
                for(int i=0;i<numero.length();i++){
                char c=numero.charAt(i);
                if (c!='0'&& c!='1'&&c!='2'&& c!='3'&&c!='4'&& c!='5'&& c!='6'&& c!='7'){
                    band=0;
                    break;
                }else{band=1;}
                } 
            break;
            case 9:
                for(int i=0;i<numero.length();i++){
                char c=numero.charAt(i);
                if (c!='0'&& c!='1'&&c!='2'&& c!='3'&&c!='4'&& c!='5'&& c!='6'&& c!='7'&& c!='8'){
                    band=0;
                    break;
                }else{band=1;}
                } 
            break;
            case 10:
                for(int i=0;i<numero.length();i++){
                char c=numero.charAt(i);
                if (c!='0'&& c!='1'&&c!='2'&& c!='3'&&c!='4'&& c!='5'&& c!='6'&& c!='7'&& c!='8'&& c!='9'){
                    band=0;
                    break;
                }else{band=1;}
                } 
            break;
            case 16:
                for(int i=0;i<numero.length();i++){
                char c=numero.charAt(i);
                if (c!='0'&& c!='1'&&c!='2'&& c!='3'&&c!='4'&& c!='5'&& c!='6'&& c!='7'&& c!='8'&& c!='9'&& c!='A'&&c!='B'&& c!='C'&&c!='D'&& c!='E'&& c!='F'){
                    band=0;
                    break;
                }else{band=1;}
                } 
            break;
   
        }return band;}
      //Conversion de base a base//
    static void convertirBaseXBase(int baseOrigen,String numero,int basesalida){
        long aux;long aux2;
        switch(baseOrigen){
            case 2:
                        switch(basesalida){
                            case 2:
                                JOptionPane.showMessageDialog(null,"Resultado: "+numero);
                             break;
                             case 3:                               
                                 aux=Long.parseLong(numero);                               
                                 aux2=convertirtodecimal(2,aux);
                                 convertobase(3,aux2);
                             break;
                             case 4:                               
                                 aux=Long.parseLong(numero);                                
                                 aux2=convertirtodecimal(2,aux);
                                 convertobase(4,aux2);
                             break;
                             case 5:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(2,aux);
                                 convertobase(5,aux2);
                             break;
                             case 6:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(2,aux);
                                 convertobase(6,aux2);
                             break;
                             case 7:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(2,aux);
                                 convertobase(7,aux2);
                             break;
                             case 8:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(2,aux);
                                 convertobase(8,aux2);
                             break;
                             case 9:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(2,aux);
                                 convertobase(9,aux2);
                             break;
                             case 10:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(2,aux);
                                 convertobase(10,aux2);
                             break;
                             case 16:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(2,aux);
                                 convertobase(16,aux2);
                             break;
                        
                        }
            break;
        
            case 3:
                     switch(basesalida){
                            case 2:
                                aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(3,aux);
                                 convertobase(2,aux2);
                             break;
                             case 3:
                                  JOptionPane.showMessageDialog(null,"Resultado: "+numero);
                             break;
                             case 4:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(3,aux);
                                 convertobase(4,aux2);
                             break;
                             case 5:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(3,aux);
                                 convertobase(5,aux2);
                             break;
                             case 6:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(3,aux);
                                 convertobase(6,aux2);
                             break;
                             case 7:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(3,aux);
                                 convertobase(7,aux2);
                             break;
                             case 8:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(3,aux);
                                 convertobase(8,aux2);
                             break;
                             case 9:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(3,aux);
                                 convertobase(9,aux2);
                             break;
                             case 10:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(3,aux);
                                 convertobase(10,aux2);
                             break;
                             case 16:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(3,aux);
                                 convertobase(16,aux2);
                             break;
                        
                        }
            break;
            case 4:
                     switch(basesalida){
                            case 2:
                                aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(4,aux);
                                 convertobase(2,aux2);
                             break;
                             case 3:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(4,aux);
                                 convertobase(3,aux2);
                             break;
                             case 4:
                                 JOptionPane.showMessageDialog(null,"Resultado: "+numero);
                             break;
                             case 5:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(4,aux);
                                 convertobase(5,aux2);
                             break;
                             case 6:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(4,aux);
                                 convertobase(6,aux2);
                             break;
                             case 7:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(4,aux);
                                 convertobase(7,aux2);
                             break;
                             case 8:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(4,aux);
                                 convertobase(8,aux2);
                             break;
                             case 9:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(4,aux);
                                 convertobase(9,aux2);
                             break;
                             case 10:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(4,aux);
                                 convertobase(10,aux2);
                             break;
                             case 16:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(4,aux);
                                 convertobase(16,aux2);
                             break;
                        
                        }
            break;
            case 5:
                 switch(basesalida){
                            case 2:
                                aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(5,aux);
                                 convertobase(2,aux2);
                             break;
                             case 3:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(5,aux);
                                 convertobase(3,aux2);
                             break;
                             case 4:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(5,aux);
                                 convertobase(4,aux2);
                             break;
                             case 5:
                                 System.out.print(numero);
                             break;
                             case 6:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(5,aux);
                                 convertobase(6,aux2);
                             break;
                             case 7:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(5,aux);
                                 convertobase(7,aux2);
                             break;
                             case 8:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(5,aux);
                                 convertobase(8,aux2);
                             break;
                             case 9:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(5,aux);
                                 convertobase(9,aux2);
                             break;
                             case 10:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(5,aux);
                                 convertobase(10,aux2);
                             break;
                             case 16:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(5,aux);
                                 convertobase(16,aux2);
                             break;
                        
                        }
            break;
            case 6:
                 switch(basesalida){
                            case 2:
                                aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(6,aux);
                                 convertobase(2,aux2);
                             break;
                             case 3:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(6,aux);
                                 convertobase(3,aux2);
                             break;
                             case 4:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(6,aux);
                                 convertobase(4,aux2);
                             break;
                             case 5:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(6,aux);
                                 convertobase(5,aux2);
                             break;
                             case 6:
                                  JOptionPane.showMessageDialog(null,"Resultado: "+numero);
                             break;
                             case 7:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(6,aux);
                                 convertobase(7,aux2);
                                
                             break;
                             case 8:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(6,aux);
                                 convertobase(8,aux2);
                             break;
                             case 9:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(6,aux);
                                 convertobase(9,aux2);
                             break;
                             case 10:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(6,aux);
                                 convertobase(10,aux2);
                             break;
                             case 16:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(6,aux);
                                 convertobase(16,aux2);
                             break;
                        
                        }
            break;
            case 7:
                 switch(basesalida){
                            case 2:
                                aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(7,aux);
                                 convertobase(2,aux2);
                             break;
                             case 3:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(7,aux);
                                 convertobase(3,aux2);
                             break;
                             case 4:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(7,aux);
                                 convertobase(4,aux2);
                             break;
                             case 5:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(7,aux);
                                 convertobase(5,aux2);
                             break;
                             case 6:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(7,aux);
                                 convertobase(6,aux2);
                             break;
                             case 7:
                                  JOptionPane.showMessageDialog(null,"Resultado: "+numero);
                             break;
                             case 8:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(7,aux);
                                 convertobase(8,aux2);
                             break;
                             case 9:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(7,aux);
                                 convertobase(9,aux2);
                             break;
                             case 10:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(7,aux);
                                 convertobase(10,aux2);
                             break;
                             case 16:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(7,aux);
                                 convertobase(16,aux2);
                             break;
                        
                        }
            break;
            case 8:
                 switch(basesalida){
                            case 2:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(8,aux);
                                 convertobase(8,aux2);
                             break;
                             case 3:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(8,aux);
                                 convertobase(3,aux2);
                             break;
                             case 4:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(8,aux);
                                 convertobase(4,aux2);
                             break;
                             case 5:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(8,aux);
                                 convertobase(5,aux2);
                             break;
                             case 6:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(8,aux);
                                 convertobase(6,aux2);
                             break;
                             case 7:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(8,aux);
                                 convertobase(7,aux2);
                             break;
                             case 8:
                                JOptionPane.showMessageDialog(null,"Resultado: "+numero);
                             break;
                             case 9:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(8,aux);
                                 convertobase(9,aux2);
                             break;
                             case 10:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(8,aux);
                                 convertobase(10,aux2);
                             break;
                             case 16:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(8,aux);
                                 convertobase(16,aux2);
                             break;
                        
                        }
            break;
            case 9:
                 switch(basesalida){
                            case 2:
                                aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(9,aux);
                                 convertobase(2,aux2);
                             break;
                             case 3:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(9,aux);
                                 convertobase(3,aux2);
                             break;
                             case 4:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(9,aux);
                                 convertobase(4,aux2);
                             break;
                             case 5:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(9,aux);
                                 convertobase(5,aux2);
                             break;
                             case 6:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(9,aux);
                                 convertobase(6,aux2);
                             break;
                             case 7:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(9,aux);
                                 convertobase(7,aux2);
                             break;
                             case 8:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(9,aux);
                                 convertobase(8,aux2);
                             break;
                             case 9:
                                 JOptionPane.showMessageDialog(null,"Resultado: "+numero);
                             break;
                             case 10:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(9,aux);
                                 convertobase(10,aux2);
                             break;
                             case 16:
                                  aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(9,aux);
                                 convertobase(16,aux2);
                             break;
                        
                        }
            break;
            case 10:
                 switch(basesalida){
                            case 2:
                                 
                                 aux2=converto16(10,numero);
                                 convertobase(2,aux2);
                             break;
                             case 3:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(10,aux);
                                 convertobase(3,aux2);
                             break;
                             case 4:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(10,aux);
                                 convertobase(4,aux2);
                             break;
                             case 5:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(10,aux);
                                 convertobase(5,aux2);
                             break;
                             case 6:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(10,aux);
                                 convertobase(6,aux2);
                             break;
                             case 7:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(10,aux);
                                 convertobase(7,aux2);
                             break;
                             case 8:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(10,aux);
                                 convertobase(8,aux2);
                             break;
                             case 9:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(10,aux);
                                 convertobase(9,aux2);
                             break;
                             case 10:
                                  JOptionPane.showMessageDialog(null,"Resultado: "+numero);
                             break;
                             case 16:
                                 aux=Long.parseLong(numero);
                                 aux2=convertirtodecimal(10,aux);
                                 convertobase(16,aux2);
                             break;
                        
                        }
            break;
            case 16:
                 switch(basesalida){
                            case 2:
                               
                                 aux2=converto16(16,numero);
                                 convertobase(basesalida,aux2);
                             break;
                             case 3:
                                 aux2=converto16(16,numero);
                                 convertobase(basesalida,aux2);
                             break;
                             case 4: 
                                aux2=converto16(16,numero);
                                 convertobase(basesalida,aux2);
                             break;
                             case 5:
                                  aux2=converto16(16,numero);
                                 convertobase(basesalida,aux2);
                             break;
                             case 6:
                                  aux2=converto16(16,numero);
                                 convertobase(basesalida,aux2);
                             break;
                             case 7:
                                  aux2=converto16(16,numero);
                                 convertobase(basesalida,aux2);
                             break;
                             case 8:
                                aux2=converto16(16,numero);
                                 convertobase(basesalida,aux2);
                             break;
                             case 9:
                                 aux2=converto16(16,numero);
                                 convertobase(basesalida,aux2);
                             break;
                             case 10:
                                 aux2=converto16(16,numero);
                                 convertobase(basesalida,aux2);
                             break;
                             case 16:
                                  JOptionPane.showMessageDialog(null,"Resultado: "+numero);
                             break;
                        
                        }
            break;
        
        }
    
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTexto = new javax.swing.JLabel();
        cuadroEntrada = new javax.swing.JTextField();
        txtBase = new javax.swing.JLabel();
        ComboBox1 = new javax.swing.JComboBox<>();
        txtConvertir = new javax.swing.JLabel();
        ComboBox2 = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTexto.setText("Numero");
        getContentPane().add(txtTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));
        getContentPane().add(cuadroEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 34, 150, 30));

        txtBase.setText("en Base:");
        getContentPane().add(txtBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        ComboBox1.setMaximumRowCount(10);
        ComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "16" }));
        ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        txtConvertir.setText("Convertir a: ");
        getContentPane().add(txtConvertir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        ComboBox2.setMaximumRowCount(10);
        ComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "16" }));
        ComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 60, -1));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox1ActionPerformed

    private void ComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox2ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String numero = this.cuadroEntrada.getText();
        System.out.println(numero);
        String base1 = ComboBox1.getSelectedItem().toString();
        System.out.println(base1);
        String base2 = ComboBox2.getSelectedItem().toString();
        System.out.println(base2);
        int bandera=0;
        int ent;
        int sal;
        ent=Integer.parseInt(base1);
        
        bandera=validacion(ent,numero,bandera);
        if (bandera==0){
        JOptionPane.showMessageDialog(null, "OPERACION INVALIDA", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }else{
         sal=Integer.parseInt(base2);
            convertirBaseXBase(ent,numero,sal);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox1;
    private javax.swing.JComboBox<String> ComboBox2;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField cuadroEntrada;
    private javax.swing.JLabel txtBase;
    private javax.swing.JLabel txtConvertir;
    private javax.swing.JLabel txtTexto;
    // End of variables declaration//GEN-END:variables
}
