package image.promo.generator.styling

import spock.lang.Specification

import java.awt.Graphics2D
import java.awt.image.BufferedImage

class IconImageUnitSpec extends Specification {

	def "Draws unicode image"() {
		given:
			Graphics2D graphics = Mock(Graphics2D)
			BufferedImage iconImage = new BufferedImage(10, 10, 1)
			IconImage icon = new IconImage(iconImage)

		when:
			icon.draw(graphics, 1, 1)
		then:
			1 * graphics.drawImage(iconImage, 1, 1, null)
	}

}
