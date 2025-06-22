package Week1_DesignPatternsAndPrinciples.Ex9_CommandPatternExample.Code;
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set!");
        }
    }
}

