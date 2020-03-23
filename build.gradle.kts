plugins {
  id("com.avast.gradle.docker-compose") version "0.10.9"
}

dockerCompose {
    removeVolumes = false
}
