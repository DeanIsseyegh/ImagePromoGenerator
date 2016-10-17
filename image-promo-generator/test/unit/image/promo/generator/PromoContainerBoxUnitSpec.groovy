package image.promo.generator

import image.promo.generator.styling.PromoFont
import image.promo.generator.styling.PromoIcon
import spock.lang.Specification

import java.awt.Color
import java.awt.Font
import java.awt.Graphics2D
import java.awt.image.BufferedImage

class PromoContainerBoxUnitSpec extends Specification {

	final String orangeHexColour = "#ff8c00"
	PromoIcon icon

	PromoContainerBox promoContainerBox

	def setup() {
		icon = Mock(PromoIcon)
		promoContainerBox = new PromoContainerBox(orangeHexColour, "testpromo", icon)
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

	def "Generates color based on hex"() {
		when:
			Color color = promoContainerBox.generateColorBasedOnHex()
		then:
			getHexColor(color) == orangeHexColour
	}

	def "Draws container based on hex colour"() {
		given:
			Graphics2D mockedGraphics = Mock(Graphics2D)

		when:
			promoContainerBox.drawContainer(mockedGraphics)
		then:
			1 * mockedGraphics.setColor(Color.decode(orangeHexColour))
	}

	def "Draws contained based on width and height"() {
		given:
			Graphics2D mockedGraphics = Mock(Graphics2D)

		when:
			promoContainerBox.drawContainer(mockedGraphics)
		then:
			1 * mockedGraphics.fillRect(0, 0, PromoContainerBox.WIDTH, PromoContainerBox.HEIGHT)
	}

	def "Generates promo box based on fixed width"() {
		when:
			BufferedImage generatedPromoBox = promoContainerBox.getImage()
		then:
			generatedPromoBox.getWidth() == PromoContainerBox.WIDTH
	}

	def "Draws promo text"() {
		given:
			Graphics2D mockedGraphics = Mock(Graphics2D)

		when:
			promoContainerBox.drawPromoText(mockedGraphics)
		then:
			1 * mockedGraphics.drawString("testpromo", _, _)
	}

	def "Draws promo text in correct position"() {
		given:
			Graphics2D mockedGraphics = Mock(Graphics2D)

		when:
			promoContainerBox.drawPromoText(mockedGraphics)
		then:
			1 * mockedGraphics.drawString(_, PromoContainerBox.PROMO_TEXT_X_OFFSET, PromoContainerBox.PROMO_TEXT_Y_OFFSET)
	}

	def "Draws promo text with promo font"() {
		given:
			Graphics2D mockedGraphics = Mock(Graphics2D)
			Font promoFont = new PromoFont().font

		when:
			promoContainerBox.drawPromoText(mockedGraphics)
		then:
			1 * mockedGraphics.setFont(promoFont)
	}

	def "Draws promo text in white"() {
		given:
			Graphics2D mockedGraphics = Mock(Graphics2D)

		when:
			promoContainerBox.drawPromoText(mockedGraphics)
		then:
			1 * mockedGraphics.setColor(Color.WHITE)
	}

	def "Draws icon in correct position"() {
		given:
			Graphics2D mockedGraphics = Mock(Graphics2D)

		when:
			promoContainerBox.drawIcon(mockedGraphics)
		then:
			1 * icon.draw(mockedGraphics, PromoContainerBox.ICON_X_OFFSET, PromoContainerBox.ICON_Y_OFFSET)
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
