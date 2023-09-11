import java.awt.AWTEventMulticaster.add
import java.util.ArrayList

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

data class User(var age: String, var formation: Formation?, val id: Int, var name: String) {
    override fun equals(other: Any?) =
        other is User && other.id == this.id
}





data class Formation(var contents: List<EducationalContent>, val name: String) {

    //val inscribed: MutableList<User> = mutableListOf<User>(
    //User("23", null, 1 , "Thomas"),
    //User("30", null, 2 , "Damian"),
    //User("17", null, 3 , "Larissa")
    //)

    val inscribed = mutableListOf<User>()


    fun register(user: User) {
        //TODO Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).
        inscribed.add(user)
    }

    fun fixRegister(firstRegister: User, secondRegister: User) {
        if (firstRegister == secondRegister) {
            inscribed.remove(secondRegister)
        }
    }
}

enum class Level { ADVANCED, BASIC, INTERMEDIARY }

data class EducationalContent(val id: Int, var duration: Int, val level: Level, var name: String)

fun main() {

    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val educationalList = mutableListOf<EducationalContent>(
        EducationalContent(100, 30, Level.BASIC, "Introdução a linguagem Kotlin I"),
        EducationalContent(200, 60, Level.INTERMEDIARY, "Introdução a linguagem Kotlin II"),
        EducationalContent(300, 120, Level.ADVANCED, "Introdução a linguagem Kotlin III"),
    )

    val formation = Formation(educationalList, "Linguagem Kotlin")

    val anaUser = User("21", null, 4, "Ana")
    val cristianUser = User("54", formation, 5, "Cristian")
    val sameUser = User("21", null, 4, "Ana")

    //add users in mutablelist
    formation.register(anaUser)

    formation.register(cristianUser)

    formation.register(sameUser)

    //show a list with duplicate user
    println(formation.inscribed)
    //verify a duplicate
    println("anaUser == sameUser: ${anaUser == sameUser}")
    //remove
    formation.fixRegister(anaUser, sameUser)

    println(formation.inscribed)
    //filter a user with formation not is null
    println(formation.inscribed.filter {it.formation != null})

}