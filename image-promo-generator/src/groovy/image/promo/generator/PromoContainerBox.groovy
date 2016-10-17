package image.promo.generator

import org.xhtmlrenderer.css.parser.property.PrimitivePropertyBuilders.Height

import javax.imageio.ImageIO
import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage

class PromoContainerBox {

	String hexColour
	String promoText

	BufferedImage generatedImage

	public static final MIN_WIDTH = 35
	public static final WIDTH = 130
	public static final HEIGHT = 28

	public PromoContainerBox(String hexColour, String promoText) {
		this.hexColour = hexColour
		this.promoText = promoText
		generatePromoBox()
	}

	BufferedImage getImage() {
		generatedImage
	}

	private generatePromoBox() {
		BufferedImage bufferedImage = createBufferedImage()
		drawRectangeOnImage(bufferedImage)
		generatedImage = bufferedImage
	}

	private drawRectangeOnImage(BufferedImage bufferedImage) {
		Graphics2D g2d = bufferedImage.createGraphics()
		g2d.setColor(generateColorBasedOnHex())
		g2d.fillRect(0, 0, WIDTH, HEIGHT)
		g2d.dispose()
	}

	private createBufferedImage() {
		new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB)
	}

	private Color generateColorBasedOnHex() {
		Color.decode(hexColour)
	}

/*	public static testSave(img) {
		File outputfile = new File("rectestx.png");
		ImageIO.write(img, "png", outputfile);
	}*/
}
