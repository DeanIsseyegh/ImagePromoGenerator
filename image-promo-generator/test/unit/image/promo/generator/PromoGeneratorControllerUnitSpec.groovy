package image.promo.generator

import grails.test.mixin.TestFor
import image.promo.generator.styling.IconImage
import image.promo.generator.styling.IconUnicode
import image.promo.generator.styling.PromoIcon
import spock.lang.Specification

import java.awt.image.BufferedImage

@TestFor(PromoGeneratorController)
class PromoGeneratorControllerUnitSpec extends Specification {

    def "Generate promo icon based on if its an image"() {
		when:
			PromoIcon icon = controller.generatePromoIcon(testIcon)
		then:
			icon in iconType

		where:
			testIcon 					   | iconType
			"icon" 						   | IconUnicode
			new BufferedImage(500, 500, 1) | IconImage
    }
}
