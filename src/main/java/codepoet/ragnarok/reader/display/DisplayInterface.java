package codepoet.ragnarok.reader.display;

public interface DisplayInterface {

	public void write(String text);

	public void write(RichText text);

	public void prompt();

	public void prompt(String text);

	public void prompt(RichText text);
}
