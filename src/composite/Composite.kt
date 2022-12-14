package composite

interface Graphic {
    fun print()
}

class CompositeGraphic(
    val graphics: ArrayList<Graphic> = ArrayList()
) : Graphic {

    override fun print() = graphics.forEach(Graphic::print)

    fun add(graphic: Graphic) {
        graphics.add(graphic)
    }

    fun remove(graphic: Graphic) {
        graphics.remove(graphic)
    }
}

class Ellipse : Graphic {
    override fun print() = println("Ellipse")
}

class Square : Graphic {
    override fun print() = println("Square")
}

fun main() {
    val ellipse1 = Ellipse()
    val ellipse2 = Ellipse()
    val ellipse3 = Ellipse()
    val ellipse4 = Ellipse()

    val square1 = Square()
    val square2 = Square()
    val square3 = Square()
    val square4 = Square()

    val graphic = CompositeGraphic()
    val graphic1 = CompositeGraphic()
    val graphic2 = CompositeGraphic()

    graphic1.add(ellipse1)
    graphic1.add(ellipse2)
    graphic1.add(square1)
    graphic1.add(ellipse3)
    graphic2.add(ellipse4)
    graphic2.add(square2)
    graphic2.add(square3)
    graphic2.add(square4)
    graphic.add(graphic1)
    graphic.add(graphic2)
    graphic.print()
}