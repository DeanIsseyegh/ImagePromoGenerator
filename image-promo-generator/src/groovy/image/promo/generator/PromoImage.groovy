package image.promo.generator

import javax.imageio.ImageIO
import java.awt.Graphics2D
import java.awt.image.BufferedImage

class PromoImage {

	private BufferedImage promoContainerBox

	private BufferedImage promoImage

	private static final int CONTAINER_BOX_X_OFFSET = 10
	private static final int CONTAINER_BOX_Y_OFFSET = 10

	PromoImage(BufferedImage backgroundImage, BufferedImage promoContainerBox) {
		promoImage = backgroundImage
		this.promoContainerBox = promoContainerBox
		overlayPromoContainerBoxOnBackground()
		//promoImage = backgroundImage
	}

	private overlayPromoContainerBoxOnBackground() {
		Graphics2D graphics = promoImage.createGraphics()
		graphics.drawImage(promoContainerBox, CONTAINER_BOX_X_OFFSET, CONTAINER_BOX_Y_OFFSET, null)
		graphics.dispose()
	}

	public getImage() {
		promoImage
	}

	public static testSave(img) {
		File outputfile = new File("promotest.png");
		ImageIO.write(img, "png", outputfile);
	}
}
