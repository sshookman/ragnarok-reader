package codepoet.ragnarok.reader;

import codepoet.ragnarok.reader.display.DisplayColor;
import codepoet.ragnarok.reader.display.DisplayInterface;
import codepoet.ragnarok.reader.display.DisplaySpeed;
import codepoet.ragnarok.reader.display.RichText;

public class Reader {

	private DisplayInterface display;

	public Reader(final DisplayInterface display) {
		this.display = display;
	}

	public void read() {

		RichText message = new RichText("Welcome to the Ragnarok Reader", DisplayColor.PURPLE, DisplaySpeed.SLOW);
		display.write(message);
		display.write("Welcome to the Ragnarok Reader!");
		display.write(message);
	}
}
