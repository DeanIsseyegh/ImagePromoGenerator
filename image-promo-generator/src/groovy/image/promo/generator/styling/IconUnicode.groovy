package image.promo.generator.styling

import java.awt.Graphics2D

class IconUnicode extends PromoIcon {

	private String icon

	public IconUnicode(String icon) {
		this.icon = icon
	}

	@Override
	void draw(Graphics2D g2d, int xOffset, int yOffset) {
		g2d.drawString(icon, xOffset, yOffset)
	}
}
