protected def changeBehaviourWhitLogging(behaviour: Actor.Receive)
                                        (implicit context: akka.actor.ActorContext): Unit = {
  context.become(behaviour orElse addCustomBehaviour().fold(unexpectedBehaviour)(_ orElse unexpectedBehaviour))
}
private def unexpectedBehaviour: Actor.Receive = {case msg => unexpectedMessageHandler(msg)}

private def unexpectedMessageHandler(msg: Any): Unit = logger warn s"Received unexpected message $msg"

protected def addCustomBehaviour(): Option[Actor.Receive] = None
