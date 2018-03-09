package codepoet.ragnarok.reader.command;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import java.io.File;
import java.io.IOException;
import codepoet.ragnarok.reader.display.DisplayInterface;

public class CommandParser {

    private POSTaggerME tagger;

    public CommandParser(DisplayInterface display) {
        tagger = null;
        try {
            File modelIn = new File("nlp/en-pos-maxent.bin");
            POSModel model = new POSModel(modelIn);
            tagger = new POSTaggerME(model);
        } catch (IOException exception) {
            //TODO: Handle this error properly
            display.write(exception.getMessage());
        }
    }

    public String[] parse(String command) {
        String[] comArray = command.split(" ");
        return tagger.tag(comArray);
    }
}
