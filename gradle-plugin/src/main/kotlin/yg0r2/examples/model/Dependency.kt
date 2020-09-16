package yg0r2.examples.model

import kotlinx.serialization.Serializable

@Serializable
data class Dependency(val group: String, val module: String, val version: String? = null) {

}
