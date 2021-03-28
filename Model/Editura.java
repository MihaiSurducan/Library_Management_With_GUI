package Model;

public class Editura {
	private int id;
	private String nume;
	
		public Editura() {
		   this.id = 0;
		   this.nume = "";
	   }
		
	   public Editura(int id, String nume) {
		   this.id = id;
		   this.nume = nume;
	   }
	   
	   public int getId() {
		   return id;
	   }
	   public void setId(int id) {
		   this.id = id;
	   }
	   
	   public String getNume() {
		   return nume;
	   }
	   public void setNume(String nume) {
		   this.nume = nume;
	   }
	   
	   public String toStringForWriteToFile() {
	        return String.valueOf(id) + ',' + nume;	 
	   }
}