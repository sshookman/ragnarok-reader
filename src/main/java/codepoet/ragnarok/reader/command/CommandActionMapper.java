package codepoet.ragnarok.reader.command;

import java.util.HashMap;
import java.util.Map;

public class CommandActionMapper {

    private static final Map<String, String> VERB_ACTION_MAP;
    private static final String MOVE = "MOVE";
    private static final String[] MOVE_VERBS = {"walk", "run", "move", "go"};

    static {
        VERB_ACTION_MAP = new HashMap<>();
        for (String verb : MOVE_VERBS) {
            VERB_ACTION_MAP.put(verb, MOVE);
        }
    }

    public static String getAction(final String verb) {
        return VERB_ACTION_MAP.get(verb);
    }
}
