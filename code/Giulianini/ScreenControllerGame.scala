class ScreenControllerGame(viewFacade, controller) extends AbstractScreenController(viewFacade, controller) with Displayable {
  private val mediator: Mediator = controller.getMediator
  mediator.subscribe(this)
  //Events from mediator to Displayable (GameScreen)
  override def notifyDrawEntities(player: EntityData, entities: Seq[EntityData]): Unit = handleDrawEntities(players, entities))
  override def notifyEntityLife(data: LifeData): Unit = Platform.runLater(() => handleEntityLife(data))
  override def notifyRedirectSound(event: SoundEvent): Unit = controller.redirectSoundEvent(event)
  override def notifyLevelEnd(data: LevelEndData): Unit = handleLevelEnd(data)
  //######################## From Controller
  override def notify(ev: ViewEvent): Unit = ev match {
    case LevelSetupEvent(data) => Platform.runLater(() => handleLevelSetup(data))
  }
  def sendCommandEvent(event: Event.CommandEvent): Unit = mediator.publishEvent(event)