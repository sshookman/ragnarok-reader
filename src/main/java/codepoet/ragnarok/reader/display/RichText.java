package codepoet.ragnarok.reader.display;

public class RichText {

	private final String text;
	private final String color;
	private final Integer speed;

	public RichText(String text, String color, Integer speed) {
		this.text = text;
		this.color = color;
		this.speed = speed;
	}

	public String getText() {
		return text;
	}

	public String getColor() {
		return color;
	}

	public Integer getSpeed() {
		return speed;
	}
}
