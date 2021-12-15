//y36,y37
class Series(name: String, duration: Int, isAvailable: Boolean, trailer:Trailer?=null):Media(name, duration, isAvailable, trailer)   { //Añadiendo interfaz Comparable

    var totalEpisodes=0
    var totalSeasons=0
    var episodeDuration=0

    init{
        episodeDuration=duration
        totalEpisodes=10
    }

    private var v=false
    private val realDuration=episodeDuration*totalEpisodes

    override fun play() {

        if(isAvailable){
            if(realDuration>0){
                for (i in 0 until realDuration step realDuration / 10) {
                    println("Playing series $name")
                }
                v=true
            }else {
                println("Playing series duration is zero or less than zero")

            }
        }else{
            println("Series $name is not available")
        }
    }

    override fun pause() {
        println("Series paused")

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
        trailer?.play(name) ?: println("No series trailer available")
    }

    override fun toString(): String {
        return "Nombre: $name -  Duración: $realDuration min"
    }

    override fun equals(other: Any?): Boolean {
        return other!=null && other is Series && other.name==this.name && other.duration==this.duration
    }

    override fun hashCode(): Int {
        var result = totalEpisodes
        result = 31 * result + totalSeasons
        result = 31 * result + episodeDuration
        result = 31 * result + v.hashCode()
        result = 31 * result + realDuration
        return result
    }


}