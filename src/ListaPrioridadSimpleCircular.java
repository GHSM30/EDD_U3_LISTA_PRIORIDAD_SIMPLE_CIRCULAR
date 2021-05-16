/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MEMO0464
 */
public class ListaPrioridadSimpleCircular {
    private Nodo ini;
    private Nodo fin;
    
    public ListaPrioridadSimpleCircular(){
        ini = fin = null;
    }
    public Nodo getIni(){
        return ini;
    }
    public boolean insertar(char dato, int nivel){
        Nodo nuevo = new Nodo(dato, nivel);
        
        
        if(nuevo == null) return false;
        if(estaVacia()){
            ini = fin = nuevo;
            fin.setSig(ini);//----------------------
            return true;
        }
        if(nuevo.getNivel() <= fin.getNivel()){   // Para enlasar de manera normal
        fin.setSig(nuevo);
        fin = nuevo;
        fin.setSig(ini);//---- 
        return true;
        }
        
        if(nuevo.getNivel() > ini.getNivel()){      // Para enlasar por ini
            nuevo.setSig(ini);
            ini = nuevo;
            fin.setSig(ini);
            return true;
        }
        
        Nodo t2 = ini;
        Nodo t1 = ini.getSig();
        boolean i = false;
        do{                                          // Para enlasar en medio
        if(nuevo.getNivel()> t1.getNivel()){
            t2.setSig(nuevo);
            nuevo.setSig(t1);
            fin.setSig(ini);
           i = false;
        }else{
            t2 = t2.getSig();
            t1 = t1.getSig();
            
            i = true;
        }
        }while(i);
        return true;
    }
    
    public boolean estaVacia(){
        return ini == null && fin == null;
    }
    
    public boolean eliminar(){
        if(estaVacia()) return false;
        if(hayUnSoloNodo()){
            fin.setSig(null);//--------------------------------
            ini = fin = null;
            return true;
        }
        Nodo temp = ini;
        ini = temp.getSig();
        temp.setSig(null);
        fin.setSig(ini);//------------------------------
        temp = null;  
        return true;
    }
    
    public boolean hayUnSoloNodo(){
        return ini == fin;
    }
    
   
}
