private[view] trait ScreenLoader {
  def getScreenController(screen: FXMLScreens): ScreenController
  def applyScreen(screen: FXMLScreens, root: Pane): Unit
  def loadFXMLNode(screen: FXMLScreens, controller: ScreenController): Unit
}
private[view] object ScreenLoader {
  class ScreenLoaderImpl extends ScreenLoader {
    private var cache: Map[FXMLScreens, (Node, ScreenController)] = Map()
    ....
}