package snanalizer.util;

public class XmlTagBuilder {

	private StringBuilder builder;

	public XmlTagBuilder(String name) {
		this.builder = new StringBuilder();
		builder.append("<" + name + " ");
	}

	public void addAttribute(String name, Object value) {
		builder.append(name + "=\"" + value + "\" ");
	}
	
	public void addAttribute(String name, int value) {
		builder.append(name + "=\"" + value + "\" ");
	}
	
	public void addAttribute(String name, boolean value) {
		builder.append(name + "=\"" + value + "\" ");
	}

	public String toString() {
		return builder.toString() + "/>";
	}
}
