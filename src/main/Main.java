package src.main;

import java.io.*;

import src.collection.*;
import src.command.CommandManager;
import src.utils.*;


public final class Main {

    public static void main(String... args) throws Exception {
        try {
            CollectionManager cm = new CollectionManager(ParserEnv.envParser("src\\.env").get("COMMAND_1"));
            CommandManager manager = new CommandManager(cm);
            manager.interactiveMod();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m No file path");
        }
        System.out.println();
    }
}
