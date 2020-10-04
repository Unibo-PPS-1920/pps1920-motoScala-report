class ScreenControllerGame(viewFacade, controller) extends AbstractScreenController(viewFacade, controller) with Displayable {
  private val mediator: Mediator = controller.getMediator
  mediator.subscribe(this)
  //Events from mediator to Displayable (GameScreen)
  override def notifyLevelSetup(data: LevelSetupData): Unit = handleSetup(data)
  override def notifyDrawEntities(player: EntityData, entities: Seq[EntityData]): Unit = drawEntities(player, entities)
  override def notifyLevelEnd(data: LevelEndData): Unit = handleTeardown(data)
  //Events from Controller
  override def notify(ev: ViewEvent): Unit = ev match {
    case event: ViewEvent.GameEvent => ...
  }
  def sendCommandEvent(event: Event.CommandEvent): Unit = mediator.publishEvent(event)