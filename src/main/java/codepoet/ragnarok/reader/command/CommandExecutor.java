package codepoet.ragnarok.reader.command;

public class CommandExecutor {

    public void execute(final Command command) throws Exception {
        String action = CommandActionMapper.getAction(command.getVerb());
        switch (action) {
            case "MOVE":
                executeMove(command.getNoun());
                break;
            default:
                throw new Exception("I don't know how to do that...");
        }
    }

    public void executeMove(final String destination) {
        //TODO: Implement Logic to update game state in the database directly - Allow game loop to just read state each loop
    }
}
