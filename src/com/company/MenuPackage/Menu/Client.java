package com.company.MenuPackage.Menu;

import com.company.MenuPackage.CommandsPackage.Command;

public class Client {
    //створює команду і встановлює її одержувача за допомогою методу SetCommand ().
    // Потім переходить до виконання цієї команди за допомогою commandExecute()
    private Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void commandExecute() {
        slot.execute();
    }
}
