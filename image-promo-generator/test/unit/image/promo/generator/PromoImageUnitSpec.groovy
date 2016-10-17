package image.promo.generator

import spock.lang.Specification

import java.awt.Graphics2D
import java.awt.image.BufferedImage

class PromoImageUnitSpec extends Specification {

	def "Creates promo image with promo container overlayed"() {
		given:
			BufferedImage containerBoxImg = new BufferedImage(10, 10, 1)
		and:
			BufferedImage backgroundImg = Mock(BufferedImage)
			Graphics2D mockedGraphics = Mock(Graphics2D)
			backgroundImg.createGraphics() >> mockedGraphics

		when:
			PromoImage promoImage = new PromoImage(backgroundImg, containerBoxImg)
		then:
			1 * mockedGraphics.drawImage(containerBoxImg,
					PromoImage.CONTAINER_BOX_X_OFFSET,
					PromoImage.CONTAINER_BOX_Y_OFFSET,
					null)
		and:
			promoImage.image in BufferedImage
	}

	def "Overlays promo container box onto image"() {
		given:
			BufferedImage containerBoxImg = new BufferedImage(10, 10, 1)
		and:
			BufferedImage backgroundImg = Mock(BufferedImage)
			Graphics2D mockedGraphics = Mock(Graphics2D)
			backgroundImg.createGraphics() >> mockedGraphics
		and:
			PromoImage promoImage = new PromoImage(backgroundImg, containerBoxImg)

		when:
			promoImage.overlayPromoContainerBoxOnBackground()
		then:
			1 * mockedGraphics.drawImage(containerBoxImg,
					PromoImage.CONTAINER_BOX_X_OFFSET,
					PromoImage.CONTAINER_BOX_Y_OFFSET,
					null)
	}

}
