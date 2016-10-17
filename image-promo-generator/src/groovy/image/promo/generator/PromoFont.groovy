package image.promo.generator

import java.awt.Font
import java.awt.FontFormatException
import java.awt.GraphicsEnvironment

class PromoFont {

	private Font font
	public static final String FONT_AWESOME_TTF = "fontawesome-webfont.ttf"

	public PromoFont() {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(FONT_AWESOME_TTF))
			ge.registerFont(customFont)
			font = new Font(FONT_AWESOME_TTF, Font.PLAIN, 13)
		} catch (IOException|FontFormatException e) {
			println e
		}
	}

	public Font getFont() {
		font
	}
}

