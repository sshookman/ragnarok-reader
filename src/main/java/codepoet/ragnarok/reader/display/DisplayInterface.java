package codepoet.ragnarok.reader.display;

import java.io.IOException;

public interface DisplayInterface {

	public void write(String text);

	public void write(RichText text);

	public String prompt() throws IOException;

	public String prompt(String text) throws IOException;

	public String prompt(RichText text) throws IOException;
}
