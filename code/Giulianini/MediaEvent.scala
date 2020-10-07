private final class ConcreteSoundAgent extends SoundAgendLogic {
	override def run(): Unit = {
		while (true) {
  		Try(this.blockingQueue.take()) match {
    		case Success(ev) => ev.handle(this)
    		case Failure(exception) => logger warn (exception.getMessage)
...

sealed trait MediaEvent {
  def handle(sl: SoundAgentLogic): Unit
}
object MediaEvent {
final case class PlayMusicEvent(media: Music) extends MediaEvent {
  override def handle(sl: SoundAgentLogic): Unit = sl.playMusic(media)
}
final case class StopMusic() extends MediaEvent {
  override def handle(sl: SoundAgentLogic): Unit = sl.stopMusic()
}
...