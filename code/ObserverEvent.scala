trait ObserverUI {
  def notify(ev: ViewEvent): Unit
}
trait View extends ObserverUI
override def notify(ev: ViewEvent): Unit = ev match {
  case event: ViewEvent.HomeEvent => screenLoader.getScreenController(FXMLScreens.HOME).notify(event)
  case event: ViewEvent.GameEvent => screenLoader.getScreenController(FXMLScreens.GAME).notify(event)
  case event: ViewEvent.LobbyEvent => screenLoader.getScreenController(FXMLScreens.LOBBY).notify(event)
  ...
}
