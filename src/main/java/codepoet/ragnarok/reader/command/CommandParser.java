package codepoet.ragnarok.reader.command;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import java.io.File;
import java.io.IOException;

public class CommandParser {

    private POSTaggerME tagger;

    public CommandParser() throws IOException {
        File modelIn = new File("nlp/en-pos-maxent.bin");
        POSModel model = new POSModel(modelIn);
        this.tagger = new POSTaggerME(model);
    }

    public String[] parse(String command) {
        command = "I " + command;
        return this.tagger.tag(command.split(" "));
    }
}
