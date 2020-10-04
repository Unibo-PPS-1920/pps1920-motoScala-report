sealed trait Event
object Event {
  sealed trait DisplayableEvent extends Event
  final case class DrawEntityEvent(entity: Seq[Entity]) extends DisplayableEvent
  final case class LevelSetupEvent(data: LevelSetupData) extends DisplayableEvent
  final case class LevelEndEvent(data: LevelEndData) extends DisplayableEvent
  sealed trait CommandableEvent extends Event
  final case class CommandEvent(cmd: CommandData) extends CommandableEvent
}