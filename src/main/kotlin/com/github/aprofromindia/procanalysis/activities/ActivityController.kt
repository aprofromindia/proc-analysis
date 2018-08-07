package com.github.aprofromindia.procanalysis.activities

import com.github.aprofromindia.procanalysis.home.HomeController
import org.slf4j.LoggerFactory
import org.springframework.hateoas.Resources
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture

@RestController
@RequestMapping("/activities/")
internal class ActivityController(private val readService: ActivityReadService) {

    private val log = LoggerFactory.getLogger(ActivityController::class.java)

    @GetMapping("/top10", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTopVariants(): CompletableFuture<Resources<ActivityEvent>> = CompletableFuture.supplyAsync {
        Resources(readService.getTopVariants(),
                linkTo(methodOn(HomeController::class.java).index()).withRel("home"))
                .also { log.info("Top 10 variants served") }
    }
}