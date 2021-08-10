// src/main/kotlin/HelloWorld.kt
import io.javalin.Javalin

fun main() {
    val app = Javalin.create().start(7000)
    app.get("/") { ctx -> ctx.result("Javalin app built using Kotlin") }
}
