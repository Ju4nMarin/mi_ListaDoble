/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import javax.swing.JOptionPane;



/**
 *
 * @author JUAN MARIN
 */
public class nodo {

    String Nombre;
    String ID;
    String Genero;
    String EPS;
    double FechaNac;
    double Peso;
    double Estatura;
    double NivGlucosa;
    double NivHemogl;

    
    nodo sig;
    nodo ant;

    public nodo(String Nombre, String ID, String Genero, String EPS, double FechaNac, double Peso, double Estatura, double NivGlucosa, double NivHemogl) {
        this.Nombre = Nombre;
        this.ID = ID;
        this.Genero = Genero;
        this.EPS = EPS;
        this.FechaNac = FechaNac;
        this.Peso = Peso;
        this.Estatura = Estatura;
        this.NivGlucosa = NivGlucosa;
        this.NivHemogl = NivHemogl;

    }

    public double getIMC() {
        double IMC = Peso / (Estatura * Estatura);
        return IMC;
    }
  

      
    public String getCat() {
        String Cat = "";
        if (getIMC() >= 15 && getIMC() <= 18) {
            Cat = "Peso insuficiente";
        } else if (getIMC() >= 18.5 && getIMC() <= 24.9) {
            Cat = "Peso Normal";
        } else if (getIMC() >= 25 && getIMC() <= 29.9) {
            Cat = "Sobrepeso";
        } else if (getIMC() >= 30 && getIMC() <= 39.9) {
            Cat = "Obesidad Clinica";
        } else if (getIMC() >= 40 && getIMC() <= 49.9) {
            Cat = "Obesidad Morbida";
        } else if (getIMC() >= 50 && getIMC() <= 59.9) {
            Cat = "Super Obesidad Morbida";
        } else if (getIMC() >= 60 && getIMC() <= 64.9) {
            Cat = "Super Super Obesidad";
        } else if (getIMC() >= 65) {
            Cat = "Obesidad Triple";
        }
        return Cat;
    }


    public String getNivHemoglobina() {
        String NivH = "";
        if ("Masculino".equals(Genero)) {
            if (NivHemogl < 13) {
                NivH = "Bajo";
            } else if (NivHemogl >= 13 && NivHemogl <= 17) {
                NivH = "Optimo";
            } else if (NivHemogl > 17) {
                NivH = "Alto";
            }
        }else
         if ("Femenino".equals(Genero)) {
            if (NivHemogl < 12) {
                NivH = "Bajo";
            } else if (NivHemogl >= 12 && NivHemogl <= 15) {
                NivH = "Optimo";
            } else if (NivHemogl > 15) {
                NivH = "Alto";
            }

        }

        return NivH;
    }

    public String getNivGlucosa() {
        String NivG = "";
        if (NivGlucosa >= 70 && NivGlucosa <= 100) {
            NivG = "Optimo";
        } else if (NivGlucosa >= 100 && NivGlucosa <= 125) {
            NivG = "PreDiabetes";
        } else if (NivGlucosa > 125) {
            NivG = "Diabetes";
        }
        return NivG;
    }

    
    
}
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

