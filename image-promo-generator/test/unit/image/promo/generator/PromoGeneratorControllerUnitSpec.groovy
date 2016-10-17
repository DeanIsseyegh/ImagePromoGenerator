package image.promo.generator

import grails.test.mixin.TestFor
import image.promo.generator.styling.IconImage
import image.promo.generator.styling.PromoIcon
import spock.lang.Specification

@TestFor(PromoGeneratorController)
class PromoGeneratorControllerUnitSpec extends Specification {

    def "Generate promo icon based on if its an image"() {
		when:
			PromoIcon icon = controller.generatePromoIcon(true)
		then:
			icon in IconImage

    }
}
