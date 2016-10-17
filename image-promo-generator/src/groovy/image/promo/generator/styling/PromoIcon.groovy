package image.promo.generator.styling

import java.awt.Graphics2D

abstract class PromoIcon {

	abstract void draw(Graphics2D g2d, int xOffset, int yOffset)
}