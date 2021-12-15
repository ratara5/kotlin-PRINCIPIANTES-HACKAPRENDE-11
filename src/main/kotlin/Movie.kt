//y36
class Movie(name: String, duration: Int, isAvailable: Boolean, trailer:Trailer?=null):Media(name, duration, isAvailable, trailer) {

    var wonOscar:Boolean=false
    private var v=false

    override fun play() { //clase padre Media es abstracta, así que sus métodos se sobreescriben enesta que es la hija
        if(isAvailable){
            if(duration>0){
                for (i in 0 until duration step duration / 10) {
                    println("Playing movie $name")
                }
                v=true
            }else {
                println("Playing movie duration is zero or less than zero")

            }
        }else{
            println("Movie $name is not available")
        }
    }

    override fun pause() {
        println("Movie paused")
    }

    override fun played(): Boolean {
        return if(v){
            println("${name} had played: true")
            this.pause()
            true
        }else{
            println("${name} had played: false")
            false
        }
    }

    override fun playTrailer() {
        trailer?.play(name) ?: println("No movie trailer available")
    }


    override fun toString(): String {
        return "Nombre: $name -  Duración: $duration min"
    }

    override fun equals(other: Any?): Boolean {
        return other!=null && other is Movie && other.name==this.name && other.duration==this.duration
    }

    override fun hashCode(): Int {
        var result = wonOscar.hashCode()
        result = 31 * result + v.hashCode()
        return result
    }


}