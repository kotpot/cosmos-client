package org.kotpot.cosmos.desktop.global

import org.kotpot.cosmos.desktop.router.AnimationRouteController
import org.kotpot.cosmos.desktop.router.RouteController


object GlobalRouteManager {


    // TODO lazy init router
    val controller = AnimationRouteController(GlobalRouter.Startup)

    fun animeToSetup() {
        controller.replace(GlobalRouter.Setup)
    }

    fun animeToMain() {
        controller.replace(GlobalRouter.Main)
    }

}