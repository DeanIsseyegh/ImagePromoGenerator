package image.promo.generator.styling

import java.awt.Font
import java.awt.FontFormatException
import java.awt.GraphicsEnvironment

class PromoFont {

	private Font font
	public static final String FONT_AWESOME_TTF = "fontawesome-webfont.ttf"
	public static final String FONT_OPEN_SANS = "OpenSans-Regular.ttf"

	public PromoFont() {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(FONT_OPEN_SANS))
			ge.registerFont(customFont)
			font = new Font(FONT_OPEN_SANS, Font.PLAIN, 13)
		} catch (IOException|FontFormatException e) {
			println e
		}
	}

	public Font getFont() {
		font
	}
}

