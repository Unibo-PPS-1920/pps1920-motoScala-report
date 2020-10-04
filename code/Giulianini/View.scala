private class ViewImpl(controller: UpdatableUI) extends View with ViewFacade {
  private val stateMachine = ViewStateMachine.buildStateMachine()
  private val root = new StackPane()
  override def changeScreen(event: ScreenEvent): Unit = screenLoader.applyScreen(stateMachine.consume(event), root)
  ....
}

private[view] object ViewStateMachine {
  def buildStateMachine(): StateMachine[FXMLScreens, ScreenEvent] = StateMachine
    .WithFunctionTransitions[FXMLScreens, ScreenEvent]()
    .initialState(FXMLScreens.HOME)
    .transition({
      case (HOME, GotoLevels) => LEVELS
      case (HOME, GotoLobby) => LOBBY
      ...
    }).build()
}