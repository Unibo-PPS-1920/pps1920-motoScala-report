case class GameEventHandler(val pane: Pane, val handleCommand: CommandEvent => Unit, val entity: Entity) {
	private val activeKeys = mutable.HashSet()
	pane.addEventHandler(KeyEvent.KEY_PRESSED, keyPressedHandler)
	object ImplicitConversions {
    implicit def keyToDir(key: KeyCode): Direction = key match {
      case W => North
      case S => South
      ...
		}		
	}
  private def createKeyPressHandler(): EventHandler = e => {
    val dir = e.getCode
    if (!activeKeys.contains(dir)) {
      activeKeys add dir
      update()
    }
  }
  private def createKeyReleasedHandler(): EventHandler ....
  private def update(): Unit = {
    val dir = activeKeys.foldLeft[Direction](Center)(_ + _)
    handleCommand(CommandEvent(CommandData(entity, dir)))
  } 
}