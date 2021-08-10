# Kotalingrad

Gradle configuration to build a Javalin project using Kotlin

## Gradle

This code is based on that presented in  https://dzone.com/articles/getting-started-with-javalin (author Erik Pragt, dated April 18, 2019)

It worked on Ubuntu 20.04 installed via WSL on Windows 10

The tools to install are:

- Kotlin
- Java VM
- Gradle

The build instructions used in the above article failed in U20.04 when using the gradle version installed
from the Ubuntu repositories (the option "--dsl kotlin" was unrecognised).
Instead I installed an up to date toolchain using SDKMAN as follows:

    $ curl -s "https://get.sdkman.io" | bash # see https://sdkman.io/install
    $ source "$HOME/.sdkman/bin/sdkman-init.sh"
    $ sdk install java
    $ sdk install gradle
    $ sdk install kotlin
    $ sdk current
        Using:
            gradle: 7.1.1
            java: 11.0.11.hs-adpt
            kotlin: 1.5.21

I then changed the contents of build.gradle.kts to reflect the installed version of Kotlin and the latest stable
version of other code (Kotlin: v1.3.21 -> v1.5.21, Javalin: v2.8.0 -> v3.13.10, slf4j-simple: v1.7.26 ->v1.7.32)

Other changes to build.gradle.kts were needed to make it work with v7.1.1 of Gradle

- Substitute mavenCentral for jcenter
- change the "compile" command to something else (e.g. to "api")
- change how to indicate the main class name (as per  https://stackoverflow.com/questions/64749528/setter-for-mainclassname-string-is-deprecated-deprecated-in-java)
 
The project can be built from scratch in an empty directory by typing

    $ gradle init --type java-library --dsl kotlin

and then creating build.gradle.kts in the home directory and a single source file src/main/kotlin/Javalin.kt
(this was named HelloWorld.kt in the original article)

and, if all is well, you can build and run the application using


   $ ./gradlew run

and see its output at  http://localhost:7000/.


This application does nothing of any interest, but if you see the phrase "Javalin app built using Kotlin",
you'll know that your toolchain works.

*Note*: If running gradle on Windows Subsystem for Linux (WSL), do not place your files in /mnt/c/ but rather in /home/wherever/, as otherwise the compiler will run with painful slowness 

