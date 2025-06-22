package Week1_DesignPatternsAndPrinciples.Ex3_BuilderPatternExample.Code;

public class Computer {
    private final String cpu;
    private final String ram;

    private final String storage;
    private final String graphicsCard;
    private final String os;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.os = builder.os;
    }

    public void showSpecs() {
        System.out.println("Computer Configuration:");
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + (storage != null ? storage : "N/A"));
        System.out.println("Graphics Card: " + (graphicsCard != null ? graphicsCard : "N/A"));
        System.out.println("OS: " + (os != null ? os : "N/A"));
        System.out.println();
    }

    // Static nested Builder class
    public static class Builder {
        private final String cpu;
        private final String ram;

        private String storage;
        private String graphicsCard;
        private String os;

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setOS(String os) {
            this.os = os;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

