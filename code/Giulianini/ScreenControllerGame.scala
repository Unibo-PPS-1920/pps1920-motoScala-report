class ScreenControllerGame(viewFacade, controller) extends AbstractScreenController(viewFacade, controller) with Displayable {
  private val mediator: Mediator = controller.getMediator
  mediator.subscribe(this)
  //Events from mediator to Displayable (GameScreen)
  override def notifyDrawEntities(player: EntityData, entities: Seq[EntityData]): Unit = handleDrawEntities(players, entities))
  override def notifyEntityLife(data: LifeData): Unit = handleEntityLife(data)
  override def notifyLevelEnd(data: LevelEndData): Unit = handleLevelEnd(data)
  //Mvc events from Controller
  override def notify(ev: ViewEvent): Unit = ev match {
    case LevelSetupEvent(data) => handleLevelSetup(data)
  }
  def sendCommandEvent(event: Event.CommandEvent): Unit = mediator.publishEvent(event)