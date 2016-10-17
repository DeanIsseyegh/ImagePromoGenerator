package image.promo.generator

import javax.imageio.ImageIO
import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.image.BufferedImage

class PromoContainerBox {

	private String hexColour
	private String promoText
	private BufferedImage generatedImage

	private static final MIN_WIDTH = 35
	private static final WIDTH = 130
	private static final HEIGHT = 28

	//TODO: Verify these values and make sure text looks good
	private static final TEXT_X_OFFSET = 28
	private static final TEXT_Y_OFFSET = 20

	//TODO: Make box length dynamic based on text length
	public PromoContainerBox(String hexColour, String promoText) {
		this.hexColour = hexColour
		this.promoText = promoText
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
		g2d.dispose()
		generatedImage = image
		testSave(generatedImage)
	}

	private drawPromoText(Graphics2D g2d) {
		g2d.setColor(Color.WHITE)
		Font promoFont = new PromoFont().font
		g2d.setFont(promoFont)
		g2d.drawString(promoText, TEXT_X_OFFSET, TEXT_Y_OFFSET)
	}

	private drawContainer(Graphics2D g2d) {
		g2d.setColor(generateColorBasedOnHex())
		g2d.fillRect(0, 0, WIDTH, HEIGHT)
	}

	private createBufferedImage() {
		new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB)
	}

	private Color generateColorBasedOnHex() {
		Color.decode(hexColour)
	}

	public static testSave(img) {
		File outputfile = new File("rectestx.png");
		ImageIO.write(img, "png", outputfile);
	}
}
