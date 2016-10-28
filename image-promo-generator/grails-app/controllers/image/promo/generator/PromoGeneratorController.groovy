package image.promo.generator

import image.promo.generator.styling.IconImage
import image.promo.generator.styling.IconUnicode
import image.promo.generator.styling.PromoIcon
import org.codehaus.groovy.grails.core.io.ResourceLocator

import javax.imageio.ImageIO
import javax.xml.bind.DatatypeConverter
import java.awt.image.BufferedImage

class PromoGeneratorController {

	ResourceLocator grailsResourceLocator

	def index() {}

    def create() {
		println "Create request received"
		Boolean isIconAnImage = params.isIconAnImage
		def icon = isIconAnImage ? getIconAsImage(params.icon) : (String) params.icon
		String hexColor = params.hexColor
		String promoText = params.text
		String saleImageUrl = params.saleImageUrl
		println "Params: ${params}"

		PromoIcon promoIcon = generatePromoIcon(icon)
		println "Generated promo icon"

		PromoContainerBox promoContainerBox = new PromoContainerBox(hexColor, promoText, promoIcon)
		println "Generated promo container box"

		BufferedImage saleImage = downloadImg(saleImageUrl)
		println "Downloaded sale image"

		PromoImage promoImage = new PromoImage(saleImage, promoContainerBox.image)
		println "Generated promo image"

		def imageAsBase64 = convertToBase64(promoImage.image)
		render(view: "index", model: [promoImage: imageAsBase64])
	}

	private BufferedImage getIconAsImage(String icon) {
		int preIndex = icon.indexOf("images/icons/")
		int postIndex = icon.indexOf(".png\"") + ".png".size()
		String imageFileName = icon.substring(preIndex, postIndex)
		def resource = grailsResourceLocator.findResourceForURI(imageFileName)
		def path = resource.file.path
		File imageFile = new File(path)
		ImageIO.read(imageFile)
	}

	private convertToBase64(BufferedImage image) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
		ImageIO.write(image, "png", outputStream)
		DatatypeConverter.printBase64Binary(outputStream.toByteArray());
	}

	private PromoIcon generatePromoIcon(String icon) {
		new IconUnicode(icon)
	}

	private PromoIcon generatePromoIcon(BufferedImage icon) {
		new IconImage(icon)
	}

	private BufferedImage downloadImg(url) {
		File file = new File('saleImage.jpg')
		BufferedOutputStream outputStream = file.newOutputStream()
		outputStream << new URL(url).openStream()
		outputStream.close()
		ImageIO.read(file)
	}
}
