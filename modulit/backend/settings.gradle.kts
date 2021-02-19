rootProject.name = "backend"

include("backend-api")
project(":backend-api").projectDir = file("api")

include("backend-service")
project(":backend-service").projectDir = file("service")

include("backend-web")
project(":backend-web").projectDir = file("web")
