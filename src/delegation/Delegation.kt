package delegation

interface Producer {
    fun produce(): String
}

class ProducerImpl() : Producer {
    override fun produce() = "ProducerImpl"
}

class EnhancedProducer(
    private val delegate: Producer
) : Producer by delegate {
    override fun produce() = "${delegate.produce()} and EnhancedProducer"
}

fun main() {
    // Test Delegation
    val producer = EnhancedProducer(ProducerImpl())
    println(producer.produce() == ("ProducerImpl and EnhancedProducer"))
    // Test finished
}