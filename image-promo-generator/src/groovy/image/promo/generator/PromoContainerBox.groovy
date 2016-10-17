package image.promo.generator

import image.promo.generator.styling.PromoFont
import image.promo.generator.styling.PromoIcon

import javax.imageio.ImageIO
import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.image.BufferedImage

class PromoContainerBox {

	private String hexColour
	private String promoText
	private PromoIcon icon
	private BufferedImage generatedImage

	private static final MIN_WIDTH = 35
	private static final WIDTH = 130
	private static final HEIGHT = 28

	//TODO: Verify these values and make sure text looks good
	private static final PROMO_TEXT_X_OFFSET = 28
	private static final PROMO_TEXT_Y_OFFSET = 20

	//TODO: Verify these values and make sure text looks good
	private static final ICON_X_OFFSET = 8
	private static final ICON_Y_OFFSET = 20

	//TODO: Make box length dynamic based on text length
	public PromoContainerBox(String hexColour, String promoText, PromoIcon icon) {
		this.hexColour = hexColour
		this.promoText = promoText
		this.icon = icon
		generatePromoBox()
	}

	BufferedImage getImage() {
		generatedImage
	}

	private generatePromoBox() {
		BufferedImage image = createBufferedImage()
		Graphics2D g2d = image.createGraphics()
		drawContainer(g2d)
		drawPromoText(g2d)
		drawIcon(g2d)
		g2d.dispose()
		generatedImage = image
		testSave(generatedImage)
	}

	private drawPromoText(Graphics2D g2d) {
		setupFontOnGraphics(g2d)
		g2d.drawString(promoText, PROMO_TEXT_X_OFFSET, PROMO_TEXT_Y_OFFSET)
	}

	private drawContainer(Graphics2D g2d) {
		g2d.setColor(generateColorBasedOnHex())
		g2d.fillRect(0, 0, WIDTH, HEIGHT)
	}

	private drawIcon(Graphics2D g2d) {
		icon.draw(g2d, ICON_X_OFFSET, ICON_Y_OFFSET)
	}

	private createBufferedImage() {
		new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB)
	}

	private Color generateColorBasedOnHex() {
		Color.decode(hexColour)
	}

	private setupFontOnGraphics(Graphics2D g2d) {
		g2d.setColor(Color.WHITE)
		Font promoFont = new PromoFont().font
		g2d.setFont(promoFont)
	}

	public static testSave(img) {
		File outputfile = new File("rectestx.png");
		ImageIO.write(img, "png", outputfile);
	}
}
