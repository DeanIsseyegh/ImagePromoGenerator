package image.promo.generator

import spock.lang.Specification

import java.awt.Color
import java.awt.image.BufferedImage

class PromoContainerBoxUnitSpec extends Specification {

	final String orangeHexColour = "#ff8c00"

	PromoContainerBox promoContainerBox

	def setup() {
		promoContainerBox = new PromoContainerBox(orangeHexColour, "testpromo")
	}

	def "Generates color based on hex"() {
		when:
			Color color = promoContainerBox.generateColorBasedOnHex()
		then:
			getHexColor(color) == orangeHexColour
	}

	def "Generates promo box based on hex colour"() {
		when:
			BufferedImage generatedPromoBox = promoContainerBox.getImage()
		then:
			getHexColor(generatedPromoBox, 1, 1) == orangeHexColour
	}

	def "Generates promo box based on fixed height"() {
		when:
			BufferedImage generatedPromoBox = promoContainerBox.getImage()
		then:
			generatedPromoBox.getHeight() == PromoContainerBox.HEIGHT
	}

	def "Generates promo box based on fixed width"() {
		when:
			BufferedImage generatedPromoBox = promoContainerBox.getImage()
		then:
			generatedPromoBox.getWidth() == PromoContainerBox.WIDTH
	}

	private getHexColor(BufferedImage bufferedImage, int x, int y) {
		int rgbBit = bufferedImage.getRGB(x, y)
		Color color = new Color(rgbBit)
		getHexColor(color)
	}

	private String getHexColor(Color color) {
		String hexColor = Integer.toHexString(color.getRGB() & 0xffffff);
		if (hexColor.length() < 6) {
			hexColor = "000000".substring(0, 6 - hexColor.length()) + hexColor
		}
		"#" + hexColor
	}

}
