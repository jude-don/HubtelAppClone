package com.example.hubtelappclone.navigation

import com.example.hubtelappclone.R


// Interface for the various Bottom Bar Destinations
sealed interface Route{
    val route:String
    val title:String
    val icon:Int
}

// Objects of the Interface
object Home: Route {
    override val route = "Home"
    override val title = "Home"
    override val icon = R.drawable.home_icon
}
object Send: Route {
    override val route = "Send"
    override val title = "Send"
    override val icon = R.drawable.send_icon
}
object History: Route {
    override val route = "History"
    override val title = "History"
    override val icon = R.drawable.history_icon
}
object Scheduled: Route {
    override val route = "Scheduled"
    override val title = "Scheduled"
    override val icon = R.drawable.schedule_icon
}