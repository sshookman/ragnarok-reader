package codepoet.ragnarok.reader.command;

public class Command {

    private String verb;
    private String noun;

    public Command(String verb, String noun) {
        this.verb = verb;
        this.noun = noun;
    }

    public String getVerb() {
        return this.verb;
    }

    public String getNoun() {
        return this.noun;
    }
}
