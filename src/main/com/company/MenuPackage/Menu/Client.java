package main.com.company.MenuPackage.Menu;

import main.com.company.MenuPackage.CommandsPackage.Command;

public class Client {

    private Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void commandExecute() {
        slot.execute();
    }
}
