package Model;

public class Autor {
	private int id;
	private String nume_autor;
	
	   public Autor() {
		   this.id = 0;
		   this.nume_autor = "";
	   }
	   
	   public Autor(int id, String nume_autor) {
		   this.id = id;
		   this.nume_autor = nume_autor;

	   }
	 
	   public int getId() {
		   return id;
	   }
	   public void setId(int id) {
		   this.id = id;
	   }
	   
	   public String getNumeAutor() {
		   return nume_autor;
	   }
	   public void setNumeAutor(String nume) {
		   this.nume_autor = nume;
	   }
	   
	   public String toStringForWriteToFile() {
	        return String.valueOf(id) + ',' + nume_autor;
	   }
}