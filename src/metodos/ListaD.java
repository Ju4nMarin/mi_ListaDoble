/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;


import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author JUAN MARIN
 */
public class ListaD {
   
    nodo cab;
    int c = 0;
    

    public ListaD(){
        cab=null;
    }
    
    public nodo getBuscarCod(String id){
        if(cab==null)
            return null;
        else{
            nodo p = cab;
            while(p!=null){
                if((p.ID).equals(id))
                    return p;
                else
                    p=p.sig;  
            }
            return null;
        }
    }
    

    public boolean getEsVacia(){
        return cab==null?true:false;

    }

    public int getLongLista(){
        int cont=0;
        nodo p=null;
        if(cab==null)
            return 0;
        else{
            p=cab;
            while(p!=null){
                cont++;
                p=p.sig;
            }
            return cont;
        }
    }
    
    public nodo getCrearNodo(
        JTextField JtfID,
        JTextField Jtfnoms,
        String Genero,
        JTextField jtfEPS,
        double FechaNac,
        JTextField jtfPeso,                      
        JTextField jtfEstatura,
        JTextField jtfGlucosa,
        JTextField jtfHemoglobina   ){
        nodo buscar = null;        
        try {                        
            buscar = getBuscarCod(JtfID.getText());
            if (buscar != null) {
                JOptionPane.showMessageDialog(null,
                    "Error: Este código ya se encuentra "
                    + "registrado.  Reemplazar código!"); 
                JtfID.setText("");
                JtfID.requestFocus();                
                return null;
            }
            
            nodo info = new nodo(
                Jtfnoms.getText(),
                JtfID.getText(),    
                Genero, 
                jtfEPS.getText(), 
                FechaNac,
                Double.parseDouble(jtfPeso.getText()),
                Double.parseDouble(jtfEstatura.getText()), 
                Double.parseDouble(jtfGlucosa.getText()),
                Double.parseDouble(jtfHemoglobina.getText())
                        );
            return info;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
            return null;
        }
    }
    
    public void setAddInicio(
            JTextField JtfID,
            JTextField Jtfnoms,
            String Genero,
            JTextField jtfEPS,
            double FechaNac,
            JTextField jtfPeso,
            JTextField jtfEstatura,
            JTextField jtfGlucosa,
            JTextField jtfHemoglobina) {
        nodo info = getCrearNodo(
                JtfID,
                Jtfnoms,
                Genero,
                jtfEPS,
                FechaNac,
                jtfPeso,
                jtfEstatura,
                jtfGlucosa,
                jtfHemoglobina
        );

        if (info != null) {
            if (cab == null) {
                
                cab = info;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento "
                        + "a la lista.  La lista estaba vacía."+c+" xD");
            } else {
                info.sig = cab;
                cab.ant = info;
                cab = info;
                
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento al "
                        + "inicio de la lista."+c+" xD");
            }
        } else {
        }
    }
    
 
    public nodo getUltimo(){
        if(cab==null)
            return null;
        else{
            nodo p = cab;
            while (p.sig != null) {
                p = p.sig;
            }
            return p;
        }
    }
    
 
    public void setAddFinal(
            JTextField JtfID,
            JTextField Jtfnoms,
            String Genero,
            JTextField jtfEPS,
            double FechaNac,
            JTextField jtfPeso,
            JTextField jtfEstatura,
            JTextField jtfGlucosa,
            JTextField jtfHemoglobina){
   
        nodo info = getCrearNodo(
       JtfID,
                Jtfnoms,
                Genero,
                jtfEPS,
                FechaNac,
                jtfPeso,
                jtfEstatura,
                jtfGlucosa,
                jtfHemoglobina
        );
        nodo p;
        if (info != null) {
            if (cab == null) {
                cab = info;
                c = c+1;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento "
                        + "a la lista.  La lista estaba vacía.");
            } else {
                c = c+1;
                nodo ultimo=getUltimo();
                ultimo.sig = info;
                info.ant = ultimo;
                JOptionPane.showMessageDialog(null,
                        "Se ha registrado un nuevo elemento al "
                        + "final de la lista.");
            }
        }else{            
        }
    }
    
    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
        int Fila, nodo info){
        
        miModelo.setValueAt(info.ID, Fila, 0);
        miModelo.setValueAt(info.Nombre, Fila, 1);
        miModelo.setValueAt(info.Genero, Fila, 2);
        miModelo.setValueAt(info.FechaNac, Fila, 3);
        miModelo.setValueAt(info.EPS, Fila, 4);
        miModelo.setValueAt(info.FechaNac, Fila, 5);
        miModelo.setValueAt(info.Peso, Fila, 6);
        miModelo.setValueAt(info.Estatura, Fila, 7);
        miModelo.setValueAt(info.NivGlucosa, Fila, 8);
        miModelo.setValueAt(info.NivHemogl, Fila, 9);
        miModelo.setValueAt(info.getIMC(), Fila, 10);
        miModelo.setValueAt(info.getCat(), Fila, 11);
        miModelo.setValueAt(info.getNivGlucosa(), Fila, 12);
        miModelo.setValueAt(info.getNivHemoglobina(), Fila, 13);
    }
    
    public void setLlenarJTable(JTable tab){
        nodo p=cab;
        int i=0;
        DefaultTableModel miModelo=new DefaultTableModel();
        miModelo.addColumn("ID");
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Genero");
        miModelo.addColumn("Edad");
        miModelo.addColumn("EPS");
        miModelo.addColumn("F.Nacimiento");
        miModelo.addColumn("Peso");
        miModelo.addColumn("Estatura");
        miModelo.addColumn("Glucosa");
        miModelo.addColumn("Hemoglobina");
        miModelo.addColumn("IMC");
        miModelo.addColumn("Categoria");
        miModelo.addColumn("NivGlu");
        miModelo.addColumn("NivHem");
        while(p!=null){                        
            miModelo.addRow(new Object[]{"", "", "", "", "","", "", "", "", "","", "", "", ""});              
            setRegistrarFilaJTable(miModelo,i,p);
            p=p.sig;
            i++;
        }
        tab.setModel(miModelo);
    }

    public void setElimCodigo(String cod){
        if(getEsVacia()){
            JOptionPane.showMessageDialog(null, 
                "La lista no tiene elementos!");
        }else{
            nodo p, q;            
            p=getBuscarCod(cod);
            if(p==null)
               JOptionPane.showMessageDialog(null, 
                "El código buscado para eliminar NO"
                + " se encuentra registrado!");
            else{
                if((p==cab)&&(cab.sig==null)){
                    cab=null;
                    c = c-1;
                    JOptionPane.showMessageDialog(null, 
                    "Elemento eliminado, la lista esta vacía!");
                }
                else if((p==cab)&&(cab.sig!=null)){
                    cab=cab.sig;
                    cab.ant=null;
                    p.sig=null;
                    p=null;
                    c = c-1;
                    JOptionPane.showMessageDialog(null, 
                    "Elemento eliminado, en el inicio de la"
                    + " lista!");
                }
                else if(p.sig==null){
                    q=cab;
                    while(q.sig!=p)
                        q=q.sig;
                    q.sig=null;
                    p.ant=null;
                    p=null;
                    c = c-1;
                    JOptionPane.showMessageDialog(null, 
                    "Elemento eliminado, al final de la"
                    + " lista!");
                }else{                    
                    p.ant.sig=p.sig;
                    p.sig.ant=p.ant;
                    p.sig=p.ant=null;
                    p=null;
                    c = c-1;
                    JOptionPane.showMessageDialog(null, 
                    "Elemento eliminado!");
                }
            }
        }
    }
    
    
     public void getCalcularPago(String ID) {
        if (getEsVacia()) {
            JOptionPane.showMessageDialog(null,
                    "La lista se encuentra vacía!");
        } else {
            nodo buscar = getBuscarCod(ID);
            if (buscar == null) {
                JOptionPane.showMessageDialog(null,
                        "El código de empleado no esta registrado!");
            } else {
                String info = "La información de pago del "
                        + "empleado es: \n";
                String NivH = "";
                if ("Masculino".equals(buscar.Genero)) {
                    if (buscar.NivHemogl < 13) {
                        NivH = "Bajo";
                    } else if (buscar.NivHemogl >= 13 && buscar.NivHemogl <= 17) {
                        NivH = "Optimo";
                    } else if (buscar.NivHemogl > 17) {
                        NivH = "Alto";
                    }
                }
                if ("Femenino".equals(buscar.Genero)) {
                    if (buscar.NivHemogl < 12) {
                        NivH = "Bajo";
                    } else if (buscar.NivHemogl >= 12 || buscar.NivHemogl <= 15) {
                        NivH = "Optimo";
                    } else if (buscar.NivHemogl > 15) {
                        NivH = "Alto";
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Por favor Digitar un Sexo Biologico Valido!");
                    }
                }

                info += NivH;
                JOptionPane.showMessageDialog(null, info);
            }
        }
    }
    
    public void getCalcularPago2(String ID) {
        if (getEsVacia()) {
            JOptionPane.showMessageDialog(null,
                    "La lista se encuentra vacía!");
        } else {
            nodo buscar = getBuscarCod(ID);
            if (buscar == null) {
                JOptionPane.showMessageDialog(null,
                        "El código de empleado no esta registrado!");
            } else {
                String info = "La información de pago del "
                        + "empleado es: \n";
                String NivG = "";
                if (buscar.NivHemogl >= 70 && buscar.NivHemogl <= 100) {
                    NivG = "Optimo";
                } else if (buscar.NivHemogl >= 100 && buscar.NivHemogl <= 125) {
                    NivG = "PreDiabetes";
                } else if (buscar.NivHemogl > 125) {
                    NivG = "Diabetes";
                }

                info += NivG;
                JOptionPane.showMessageDialog(null, info);
            }
        }
    }

    

 
    public double getoProm() {
        double s = 0;
        nodo p = null;
        int temp = 0;
        if (cab == null) {
            JOptionPane.showMessageDialog(null,
                    "La lista se encuentra vacía!");
        } else {
            p = cab;
        }
        while (p !=null){
            if ( temp < c ){
            temp = temp +1;
            double a = p.Peso;
            double b = p.Estatura;
            s += a / (b*b);
            p = p.sig;   
            }   
        }
        return s/c;
    }
    
       public double getoProm2() {
        double s = 0;
        nodo p = null;
        int temp = 0;
        if (cab == null) {
            JOptionPane.showMessageDialog(null,
                    "La lista se encuentra vacía!");
        } else {
            p = cab;
        }
        while (p !=null){
            if ( temp < c ){
            temp = temp +1;
            s += p.NivHemogl;
            p = p.sig;   
            }   
        }
        return s/c;
    }
  
       public double getoProm3() {
        double s = 0;
        nodo p = null;
        int temp = 0;
        if (cab == null) {
            JOptionPane.showMessageDialog(null,
                    "La lista se encuentra vacía!");
        } else {
            p = cab;
        }
        while (p !=null){
            if ( temp < c ){
            temp = temp +1;
            s += p.NivGlucosa;
            p = p.sig;   
            }   
        }
        return s/c;
    }
    
    
    
  
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
    
    
}   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


 
    
