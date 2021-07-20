package calculabytes;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\CalculaBytes\\src\\calculabytes\\Teste");
        CalculoPara calc = new CalculoPara(file);
        long tamanho = calc.compute();
        System.out.println("Tamanho do arquivo ou folder: " + tamanho + " bytes.");
    }
    
}
