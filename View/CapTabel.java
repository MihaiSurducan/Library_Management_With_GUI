package View;


public class CapTabel {
    public static void afisCartiAutor_sus() {
        System.out.println();
        System.out.println("======================================");
        System.out.format("| %10s | %-22s |\n", "ID carte", "Titlu");
        System.out.println("=======================================");
    }

    public static void afisCartiAutor_jos() {
        System.out.println("======================================");
        System.out.println();
    }


    public static void afisCartiEditura_sus() {
        System.out.println();
        System.out.println("======================================");
        System.out.format("| %10s | %-22s |\n", "ID carte", "Titlu");
        System.out.println("======================================");
    }

    public static void afisCartiEditura_jos() {
        System.out.println("======================================");
        System.out.println();
    }

    
    public static void afisCarti_total_sus() {
        System.out.println();
        System.out.println("==============================================================================================================================================================================");
        System.out.format("| %10s | %-20s | %-20s | %5s | %-6s | %-20s | %-10s |\n", "ID carte","Titlu","Nume autor","Anul","Pret","Editura","Cota");

        System.out.println("==============================================================================================================================================================================");
    }

    public static void afisCarti_total_jos() {
        System.out.println("==============================================================================================================================================================================");
        System.out.println();
    }

    public static void afisAutori_total_sus() {
        System.out.println();
        System.out.println("======================================");
        System.out.format("| %10s | %-20s |\n", "ID autor", "Nume");


        System.out.println("======================================");
    }

    public static void afisAutori_total_jos() {
        System.out.println("======================================");
        System.out.println();
    }
    
    public static void afisEdituri_total_sus() {
        System.out.println();
        System.out.println("=======================================");
        System.out.format("| %10s | %-20s |\n", "ID editura", "Nume");

        System.out.println("=======================================");
    }

    public static void afisEdituri_total_jos() {
        System.out.println("=======================================");
        System.out.println();
    }
}

