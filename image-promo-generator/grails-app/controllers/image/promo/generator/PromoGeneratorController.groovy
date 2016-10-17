package image.promo.generator

import image.promo.generator.styling.IconImage
import image.promo.generator.styling.IconUnicode
import image.promo.generator.styling.PromoIcon

import javax.imageio.ImageIO
import java.awt.image.BufferedImage

class PromoGeneratorController {

    def create() {
		Boolean isIconAnImage = params.isIconAnImage
		def icon = params.icon
		String hexColor = params.hexColor
		String promoText = params.text
		String saleImageUrl = params.saleImageUrl

		PromoIcon promoIcon = generatePromoIcon(isIconAnImage, icon)
		PromoContainerBox promoContainerBox = new PromoContainerBox(hexColor, promoText, promoIcon)
		BufferedImage saleImage = downloadSaleImage(saleImageUrl)
		PromoImage promoImage = new PromoImage(promoContainerBox.image, saleImage)
		return promoImage.image
	}

	private PromoIcon generatePromoIcon(Boolean isIconAnImage, icon) {
		if (isIconAnImage) {
			new IconImage(icon)
		} else {
			new IconUnicode(icon)
		}
	}

	private BufferedImage downloadSaleImage(String url) {
		new BufferedImage(500, 500, 1)
	}

	def downloadImg() {
		def url = 'http://www.google.com/images/logo.gif'
		File file = new File('google_logo.gif').newOutputStream()
		file << new URL(url).openStream()
		println file
		BufferedImage bufferedImage = ImageIO.read(file);
		File outputfile = new File("downloadimagetest.png");
		ImageIO.write(bufferedImage, "png", outputfile);
		file.inp
		file.close()
	}
}
