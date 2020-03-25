plugins {
  id("com.avast.gradle.docker-compose") version "0.10.9"
  id("net.saliman.properties") version "1.5.1"
}

val mongoHost: String by project
val mongoUser: String by project
val mongoPassword: String by project
val mongoDatabase: String by project
val mongoPort: String by project
val npmRegistry: String? by project

val envMap = hashMapOf<String, String>(
        "MONGO_HOST" to mongoHost,
        "MONGO_USER" to mongoUser,
        "MONGO_PASSWORD" to mongoPassword,
        "MONGO_DATABASE" to mongoDatabase
)

npmRegistry?.let {
    envMap["npm_config_registry"] = it
}

dockerCompose {
    removeVolumes = false
    environment.putAll(envMap)
}
