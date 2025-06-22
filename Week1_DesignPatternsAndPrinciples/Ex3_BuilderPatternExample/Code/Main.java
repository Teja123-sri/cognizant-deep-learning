package Week1_DesignPatternsAndPrinciples.Ex3_BuilderPatternExample.Code;

// Main.java
public class Main {
    public static void main(String[] args) {
        // Basic computer
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB").build();

        // Gaming computer
        Computer gamingComputer = new Computer.Builder("Intel i7", "16GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4060")
                .setOS("Windows 11")
                .build();

        // Workstation
        Computer workstation = new Computer.Builder("AMD Ryzen 9", "32GB")
                .setStorage("2TB SSD")
                .setGraphicsCard("NVIDIA Quadro RTX")
                .setOS("Linux")
                .build();

        // Print configurations
        basicComputer.showSpecs();
        gamingComputer.showSpecs();
        workstation.showSpecs();
    }
}

