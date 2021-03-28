package Model;

public class Carte {
	   private int id;
	   private String titlu;  
	   private String nume_autor;	 
	   private int an;	 
	   private double pret;
	   private String editura;	
	   private String cota; 
	   
	   public Carte() {
		   this.id = 0;
		   this.titlu = "";
		   this.nume_autor = "";
		   this.an = 0;
		   this.pret = 0;
		   this.editura = "";
		   this.cota = "";
	   }
	   
	   public Carte(int id,String titlu, String nume_autor, int an, double pret, String editura, String cota) {
		   this.id = id;
		   this.titlu = titlu;
		   this.nume_autor = nume_autor;
		   this.an = an;
		   this.pret = pret;
		   this.editura = editura;
		   this.cota = cota;
	   }
	   
	   public int getId() {
		   return id;
	   }
	   public void setId(int id) {
		   this.id = id;
	   }
	   
	   public String getTitlu() {
		   return titlu;
	   }
	   public void setTitlu(String titlu) {
		   this.titlu = titlu;
	   }
	   
	   public String getNumeAutor() {
		   return nume_autor;
	   }
	   public void setNumeAutor(String nume) {
		   this.nume_autor = nume;
	   }
	   
	   public String getEditura() {
		   return editura;
	   }
	   public void setEditura(String editura) {
		   this.editura = editura;
	   }
	   
	   public int getAn() {
		   return an;
	   }
	   public void setAn(int an) {
		   this.an = an;
	   }
	   
	   public double getPret() {
		   return pret;
	   }
	   
	   public void setPret(double pret) {
		   this.pret = pret;
	   }
	   
	   public String getCota() {
		   return cota;
	   }
	   public void setCota(String cota) {
		   this.cota = cota;
	   }
	   
	   public String toStringForWriteToFile() {
	        return String.valueOf(id) + ',' + titlu + ',' + nume_autor + ',' + String.valueOf(an) + ',' + String.valueOf(pret)+',' + editura +  ',' + cota;
	    }
	   
}