package image.promo.generator.styling

import java.awt.Font
import java.awt.FontFormatException
import java.awt.GraphicsEnvironment

class PromoFont {

	private Font font
	public static final String FONT_OPEN_SANS = "OpenSans-Semibold.ttf"

	public PromoFont() {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(FONT_OPEN_SANS))
			if (ge.registerFont(customFont)) {
				font = new Font(FONT_OPEN_SANS, Font.BOLD, 12)
			} else {
				throw new Exception("FONT NOT LOADED PROPERLY!")
			}
		} catch (IOException|FontFormatException e) {
			println e
		}
	}

	public Font getFont() {
		font
	}
}

