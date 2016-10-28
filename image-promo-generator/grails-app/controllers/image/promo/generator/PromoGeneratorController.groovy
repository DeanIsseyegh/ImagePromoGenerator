package image.promo.generator

import image.promo.generator.styling.IconImage
import image.promo.generator.styling.IconUnicode
import image.promo.generator.styling.PromoIcon

import javax.imageio.ImageIO
import javax.xml.bind.DatatypeConverter
import java.awt.image.BufferedImage

class PromoGeneratorController {

	def index() {}

    def create() {
		Boolean isIconAnImage = params.isIconAnImage
		def icon = params.icon
		String hexColor = params.hexColor
		String promoText = params.text
		String saleImageUrl = params.saleImageUrl
		log.info "Params: ${params}"

		PromoIcon promoIcon = generatePromoIcon(icon)
		PromoContainerBox promoContainerBox = new PromoContainerBox(hexColor, promoText, promoIcon)
		BufferedImage saleImage = downloadImg(saleImageUrl)
		PromoImage promoImage = new PromoImage(saleImage, promoContainerBox.image, )
		render(view: "index", model: [promoImage:convertToBase64(promoImage.image)])
	}

	private convertToBase64(BufferedImage image) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
		ImageIO.write(image, "png", outputStream)
		DatatypeConverter.printBase64Binary(outputStream.toByteArray());
	}

	def test() {
		Boolean isIconAnImage = false
		String icon = "testest"
		String hexColor = "#ff8c00"
		String promoText = "BUY THIS"
		String saleImageUrl = "https://d1x3cbuht6sy0f.cloudfront.net/sales/37539/3285fcc2_e669_4301_8e1f_6da832002386.jpg"

		PromoIcon promoIcon = generatePromoIcon(icon)
		PromoContainerBox promoContainerBox = new PromoContainerBox(hexColor, promoText, promoIcon)
		BufferedImage saleImage = downloadImg(saleImageUrl)
		PromoImage promoImage = new PromoImage(saleImage, promoContainerBox.image)
		ImageIO.write(promoImage.image, "png", new File('THE_COMPLETE.png'))
		return promoImage.image
	}

	private PromoIcon generatePromoIcon(String icon) {
		new IconUnicode(icon)
	}

	private PromoIcon generatePromoIcon(BufferedImage icon) {
		new IconImage(icon)
	}

	private BufferedImage downloadImg(url) {
		//def url = 'https://d1x3cbuht6sy0f.cloudfront.net/sales/37539/3285fcc2_e669_4301_8e1f_6da832002386.jpg'
		File file = new File('saleImage.jpg')
		BufferedOutputStream outputStream = file.newOutputStream()
		outputStream << new URL(url).openStream()
		outputStream.close()
		ImageIO.read(file)
	}
}
