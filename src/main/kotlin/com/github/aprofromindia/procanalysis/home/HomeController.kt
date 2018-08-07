package com.github.aprofromindia.procanalysis.home

import com.github.aprofromindia.procanalysis.activities.ActivityController
import org.slf4j.LoggerFactory
import org.springframework.hateoas.Resource
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
internal class HomeController {
    val log = LoggerFactory.getLogger(HomeController::class.java)

    @GetMapping("/", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun index(): Resource<String> = Resource("Welcome to Process Analytics!",
            linkTo(methodOn(ActivityController::class.java)
                    .getTopVariants()).withRel("top_10")).also {
        log.info("/ route served")
    }
}