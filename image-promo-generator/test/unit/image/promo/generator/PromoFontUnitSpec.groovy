package image.promo.generator

import spock.lang.Specification

import java.awt.Font

class PromoFontUnitSpec extends Specification {

	def "Creates custom promo font"() {
		given:
			PromoFont promoFont = new PromoFont()
			Font expectedCustomFont = new Font(PromoFont.FONT_AWESOME_TTF, Font.PLAIN, 13)

		expect:
			promoFont.font == expectedCustomFont
	}

}
