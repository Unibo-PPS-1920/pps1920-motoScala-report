override def sendToLobbyStrategy[T](strategy: MultiPlayerSetup => T): T = strategy.apply(matchSetupMp.get)

override def sendToViewStrategy(strategy: ObserverUI => Unit): Unit =
  observers.foreach(obs => Platform.runLater(() => strategy(obs)))
