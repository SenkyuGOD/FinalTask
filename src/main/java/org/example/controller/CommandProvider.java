package org.example.controller;

import org.example.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

import static org.example.controller.CommandName.ADD_PRODUCT_TO_BUCKET;
import static org.example.controller.CommandName.TOTAL_AMOUNT_OF_BUCKET;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider(){
        repository.put(CommandName.FIND, new FindProductCommand());
        repository.put(CommandName.SHOW_ALL_PRODUCTS, new DisplayAllProductsCommand());
        repository.put(CommandName.ADD_PRODUCT_TO_DB, new AddProductToDBCommand());
        repository.put(CommandName.DELETE_FROM_DB, new DeleteProductFromDBCommand());
        repository.put(CommandName.TOTAL_AMOUNT_OF_BUCKET, new TotalAmountCommand());
        repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
    }

    Command getCommand(String name){
        CommandName commandName =null;
        Command command = null;

        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }catch(IllegalArgumentException | NullPointerException e){
            //write log
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
