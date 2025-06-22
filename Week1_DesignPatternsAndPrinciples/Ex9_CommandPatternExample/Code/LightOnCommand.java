package Week1_DesignPatternsAndPrinciples.Ex9_CommandPatternExample.Code;
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
