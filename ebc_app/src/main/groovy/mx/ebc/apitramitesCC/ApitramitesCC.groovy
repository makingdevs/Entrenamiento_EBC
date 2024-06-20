package mx.ebc.apitramitesCC

import wslite.rest.*
import groovy.util.logging.Slf4j

@Slf4j
@Singleton 
class ApitramitesCC {
    String url = "https://api-tramites.ebc.edu.mx/api-tramites-escolares"
    RESTClient client = new RESTClient(url)

    List<AcademiclevelCC> allAcademicLevels (Boolean bannerLevel) {
        def response = client.get (
            path: "/v1/api/academic_level",
            query: [bannerLevel: bannerLevel])
            log.debug "Response from url:${response}"
            response.json.collect { params -> new AcademiclevelCC (params) }
    }
}
