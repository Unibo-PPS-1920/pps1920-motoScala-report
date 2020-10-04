trait EventSubject {
  def subscribe[T: ClassTag](obs: EventObserver[T]*): Unit
  def unsubscribe[T](obs: EventObserver[T]*): Unit
  def publishEvent[T: ClassTag](ev: T): Unit
}
trait EventObserver[T] {
  def notify(event: T): Unit
}
trait Mediator extends EventSubject {
    private var observers: Map[Observer, EventType] = Map()
    ....
}