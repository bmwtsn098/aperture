val snapshot = true

allprojects {
  var ver = "0.19.0"
  if (snapshot) {
    ver += "-SNAPSHOT"
  }
  version = ver
}
