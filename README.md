This is an example kotlin project with a few fun technologies tied together including GraalVM / SubstrateVM for native image building, Gradle 5 + Kotlin Gradle DSL, Kotlin 1.3 and kotlinx.serialization. It also shows off how fast native images can be.


Use `./gradlew nativeImage` to build a native image, `./gradlew installDist` to build a JAR and a wrapper script or `./gradlew installShadowDist` to build a fat/shadow JAR and wrapper script.

Time and memory differences between the native image and the JAR-based distribution:

## Native image
Built with `./gradlew nativeImage`
```
$ time build/graal/hello-speedy-world
{"a":42,"b":"30"}
Data(a=10, b=30)
build/graal/hello-speedy-world   0.00s  user 0.00s system 81% cpu 0.007 total
avg shared (code):         0 KB
avg unshared (data/stack): 0 KB
total (sum):               0 KB
max memory:                3304 KB
page faults from disk:     0
other page faults:         1066
```

## Normal JAR distribution
Built with `./gradlew installDist`
```
{"a":42,"b":"30"}
Data(a=10, b=30)
build/install/kotlin-starter/bin/kotlin-starter   0.16s  user 0.12s system 104% cpu 0.271 total
avg shared (code):         0 KB
avg unshared (data/stack): 0 KB
total (sum):               0 KB
max memory:                33164 KB
page faults from disk:     0
other page faults:         26150
```

## Shadow JAR distribution
Built with `./gradlew installShadowDist`
```
$ time build/install/kotlin-starter-shadow/bin/kotlin-starter
{"a":42,"b":"30"}
Data(a=10, b=30)
build/install/kotlin-starter-shadow/bin/kotlin-starter   0.16s  user 0.14s system 104% cpu 0.287 total
avg shared (code):         0 KB
avg unshared (data/stack): 0 KB
total (sum):               0 KB
max memory:                32528 KB
page faults from disk:     0
other page faults:         25983
```

The native image is significantly faster to start up and run than either JAR based approach.
