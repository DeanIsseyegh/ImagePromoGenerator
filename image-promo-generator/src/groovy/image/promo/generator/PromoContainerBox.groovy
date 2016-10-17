package overlay.app

import java.awt.image.BufferedImage

class PromoContainerBox {

	String hexColour
	String promoText
	BufferedImage image

	public PromoContainerBox(String hexColour, String promoText) {
		this.hexColour = hexColour
		this.promoText = promoText
		generatePromoBox()
	}

	BufferedImage generatePromoBox() {

	}

}
