package memento

class Memento(val state: String)

class Originator {
    var state: String? = null
    fun createMemento(): Memento {
        return Memento(state!!)
    }

    fun setMemento(memento: Memento) {
        state = memento.state
    }
}

class CareTaker {
    private val statesList = ArrayList<Memento>()

    fun addMemento(memento: Memento) {
        statesList.add(memento)
    }

    fun getMemento(index: Int) = statesList[index]
}

fun main() {
    val originator = Originator()
    originator.state = "Ironman"
    var memento = originator.createMemento()
    val caretaker = CareTaker()
    caretaker.addMemento(memento)

    originator.state = "Captain America"
    originator.state = "Hulk"
    memento = originator.createMemento()
    caretaker.addMemento(memento)
    originator.state = "Thor"
    println("Originator Current State: " + originator.state!!)
    println("Originator restoring to previous state...")
    memento = caretaker.getMemento(1)
    originator.setMemento(memento)
    println("Originator Current State: " + originator.state!!)
    println("Again restoring to previous state...")
    memento = caretaker.getMemento(0)
    originator.setMemento(memento)
    println("Originator Current State: " + originator.state!!)
}