package image.promo.generator.styling

import java.awt.Graphics2D
import java.awt.image.BufferedImage

class IconImage extends PromoIcon {

	private BufferedImage icon

	public IconImage(BufferedImage icon) {
		this.icon = icon
	}

	@Override
	void draw(Graphics2D g2d, int xOffset, int yOffset) {
		g2d.drawImage(icon, xOffset, yOffset, null)
	}
}
