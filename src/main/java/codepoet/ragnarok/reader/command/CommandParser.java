package codepoet.ragnarok.reader.command;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import java.io.File;
import java.io.IOException;
import codepoet.ragnarok.reader.display.DisplayInterface;

public class CommandParser {

    private POSTaggerME tagger;

    public CommandParser() throws IOException {
        File modelIn = new File("nlp/en-pos-maxent.bin");
        POSModel model = new POSModel(modelIn);
        this.tagger = new POSTaggerME(model);
    }

    public String[] parse(String input) {
        input = "I " + input;
        String[] words = input.split(" ");
        String[] tags = this.tagger.tag(words);
        String[] command = null;

        if (tags[1].equals("VBP") && tags[2].equals("TO")) {
            if (tags[3].equals("NN")) {
                command = new String[2];
                command[0] = words[1];
                command[1] = words[3];
            } else if (tags[3].equals("DT") && tags[4].equals("NN")) {
                command = new String[2];
                command[0] = words[1];
                command[1] = words[4];
            }
        }

        return command;
    }
}
