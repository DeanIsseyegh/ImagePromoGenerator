package image.promo.generator.styling

import image.promo.generator.styling.PromoFont
import spock.lang.Specification

import java.awt.Font

class PromoFontUnitSpec extends Specification {

	def "Creates custom promo font"() {
		given:
			PromoFont promoFont = new PromoFont()
			Font expectedCustomFont = new Font(PromoFont.FONT_OPEN_SANS, Font.PLAIN, 13)

		expect:
			promoFont.font == expectedCustomFont
	}

}
