package image.promo.generator

import java.awt.Font
import java.awt.FontFormatException
import java.awt.GraphicsEnvironment

class PromoFont {

	Font font

	public PromoFont() {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fontawesome-webfont.ttf")));
			font = new Font("fontawesome-webfont", Font.PLAIN, 13)
		} catch (IOException|FontFormatException e) {
			println e
		}
	}

}
