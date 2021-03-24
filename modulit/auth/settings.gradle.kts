rootProject.name = "auth"

include("auth-api")
project(":auth-api").projectDir = file("api")

include("auth-service")
project(":auth-service").projectDir = file("service")

include("auth-ui")
project(":auth-ui").projectDir = file("ui")

include("auth-web")
project(":auth-web").projectDir = file("web")
