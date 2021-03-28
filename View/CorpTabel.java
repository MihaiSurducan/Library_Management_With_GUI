package View;

import Model.*;

import java.util.List;

public class CorpTabel {
	
    public static void afisCartiAutor(List<Carte> cartiList, String numeAutor) {
  
        for (int i = 0; i < cartiList.size(); i++) {
                if (numeAutor.equals(cartiList.get(i).getNumeAutor())) {
                    System.out.format("| %10s | %-22s|\n", cartiList.get(i).getId(),cartiList.get(i).getTitlu());
                }
            
        }
    }
    
    public static void afisCartiEditura(List<Carte> cartiList, String editura) {
    	  
        for (int i = 0; i < cartiList.size(); i++) {
            
                if (editura.equals(cartiList.get(i).getEditura())) {
                	System.out.format("| %10s | %-22s |\n", cartiList.get(i).getId(),cartiList.get(i).getTitlu());
                }    
        }
    }
    
    public static void afisCarti_total(List<Carte> cartiList){
        for (int i = 0; i < cartiList.size(); i++)
            System.out.format("| %10s | %-20s | %-20s | %5s | %-6s | %-20s | %10s |\n",cartiList.get(i).getId(),cartiList.get(i).getTitlu(),cartiList.get(i).getNumeAutor(),cartiList.get(i).getAn(),cartiList.get(i).getPret(),cartiList.get(i).getEditura(),cartiList.get(i).getCota());

    }

    public static void afisAutori_total(List<Autor> autoriList){
        for (int i = 0; i < autoriList.size(); i++)
            System.out.format("| %10s | %-20s |\n",autoriList.get(i).getId(),autoriList.get(i).getNumeAutor());
    }
    
    public static void afisEdituri_total(List<Editura> edituriList){
        for (int i = 0; i < edituriList.size(); i++)
            System.out.format("| %10s | %-20s|\n", edituriList.get(i).getId(),edituriList.get(i).getNume());

    }
}

