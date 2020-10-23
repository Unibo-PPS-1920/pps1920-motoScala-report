private final class ConcreteSoundAgent extends SoundAgendLogic {
	override def run(): Unit = {
		while (true) {
  		Try(this.blockingQueue.take()) match {
    		case Success(ev) => processEvent(ev)
    		case Failure(exception) => logger warn (exception.getMessage)
    	}
def processEvent(ev: MediaEvent): Unit = ev.handle(this)
...

sealed trait MediaEvent {
  def handle(sl: SoundAgentLogic): Unit
}
object MediaEvent {
final case class PlayMusicEvent(media: Music) extends MediaEvent {
  def handle(sl: SoundAgentLogic): Unit = sl.playMusic(media)
} ...