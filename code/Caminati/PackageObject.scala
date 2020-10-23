implicit def stringPathToPath(path: String): Path = Paths.get(path)

implicit def pathToFile(path: Path): File = path.toFile

def tryAndBoolResult[T](operation: => T)(Logger): Boolean =
  Try(operation).fold(error => {logger.warn(error.getMessage); false }, _ => true)
