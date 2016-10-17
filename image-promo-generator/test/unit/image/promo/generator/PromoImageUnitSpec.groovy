package image.promo.generator

import spock.lang.Specification

import java.awt.Graphics2D
import java.awt.image.BufferedImage

class PromoImageUnitSpec extends Specification {

	def "Overlays promo container box onto image"() {
		given:
			BufferedImage iconImage = new BufferedImage(10, 10, 1)
			BufferedImage containerBoxImg = new BufferedImage(10, 10, 1)
		and:
			BufferedImage backgroundImage = Mock(BufferedImage)
			Graphics2D mockedGraphics = Mock(Graphics2D)
			backgroundImage.createGraphics() >> mockedGraphics
		and:
			PromoImage promoImage = new PromoImage(iconImage, backgroundImage, containerBoxImg)

		when:
			promoImage.overlayPromoContainerBox()
		then:
			1 * mockedGraphics.drawImage(containerBoxImg,
					PromoImage.CONTAINER_BOX_X_OFFSET,
					PromoImage.CONTAINER_BOX_Y_OFFSET,
					null)
	}

}
