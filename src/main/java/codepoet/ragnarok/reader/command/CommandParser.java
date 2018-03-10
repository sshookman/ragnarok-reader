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
        String[] tags = this.tagger.tag(command.split(" "));

        String[] vbnn = new String[2];
        if (tags[1] == "VBP" && tags[2] == "TO") {
            if (tags[3] == "NN") {
                vbnn[0] = tags[1];
                vbnn[1] = tags[3];
            } else if (tags[3] == "DT" && tags[4] == "NN") {
                vbnn[0] = tags[1];
                vbnn[1] = tags[4];
            }
        }

        return vbnn;
    }
}
