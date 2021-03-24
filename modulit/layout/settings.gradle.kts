rootProject.name = "layout"

include("layout-ui")
project(":layout-ui").projectDir = file("ui")

include("layout-web")
project(":layout-web").projectDir = file("web")
