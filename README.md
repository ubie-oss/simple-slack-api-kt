# simple-slack-api-kt

![GitHub Actions](https://github.com/ubie-inc/simple-slack-api-kt/actions/workflows/build.yml/badge.svg)

simple-slack-api-kt is the library that adds Kotlin friendly API for [simple-slack-api](https://github.com/Ullink/simple-slack-api)

## How to use it

### Connect

Previously,

```kotlin
session.connect()
val channel = session.findChannelByName("general")
session.sendMessage(channel, "hi im a bot" )
session.disconnect()
```

Now we can do like this

```kotlin
session.connect {
    val channel = it.findChannelByName("general")
    it.sendMessage(channel, "hi im a bot" )
}
```

## How to Install

Use gradle!

```gradle
dependencies {
    implementation("com.ullink.slack:simpleslackapi:${simpleslackapi.version}")
    implementation("app.ubie:simple-slack-api-kt:1.0.1")
}
```
