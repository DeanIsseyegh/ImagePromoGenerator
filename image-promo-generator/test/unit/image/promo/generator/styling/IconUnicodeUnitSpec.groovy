package image.promo.generator.styling

import spock.lang.Specification

import java.awt.Graphics2D

class IconUnicodeUnitSpec extends Specification {

	def "Draws unicode icon"() {
		given:
			Graphics2D graphics = Mock(Graphics2D)
			String unicodeIcon = '\u20AC'
			IconUnicode iconUnicode = new IconUnicode(unicodeIcon)

		when:
			iconUnicode.draw(graphics, 1, 1)
		then:
			1 * graphics.drawString(unicodeIcon, 1, 1)
	}

}
