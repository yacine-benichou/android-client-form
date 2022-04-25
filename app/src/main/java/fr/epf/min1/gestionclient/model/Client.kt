package fr.epf.min1.gestionclient.model

enum class Gender {
    MAN, WOMAN
}

enum class State {
    INACTIVE, ACTIVE
}

data class Client(
    val lastName: String,
    val firstName: String,
    val email: String?,
    val level: String,
    val age: Int,
    val gender: Gender,
    val state: State
) {
    companion object {
        fun bdd(nb: Int = 30) = (1..nb).map {
                val gender = if (it % 2 == 0) Gender.MAN else Gender.WOMAN
                Client("nom$it", "prenom$it", "mail$it@epf.fr", "Débutant",20 + it, gender, State.ACTIVE)
        }
    }
}