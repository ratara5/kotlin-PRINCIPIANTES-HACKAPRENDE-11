//y36 en nuestro programa no necesitamos objetos de tipo media, solo objetos del tipo de sus hijas(Movie y Series)
abstract class Media(var name: String, var duration: Int, var isAvailable: Boolean, var trailer:Trailer?=null):Comparable<Media>{ // por eso, borramos el open y ponemos el abstract
    //abstracta quiere decir que no se pueden crear instancias de ella
    //y40: Añadiendo interfaz Comparable

    companion object{
        private const val FRAME_RATE_HD=60
        private const val FRAME_RATE_SD=24
        private const val SECONDS_IN_A_MINUTE=60

        fun getTotalFrames(duration: Int, isHd: Boolean):Int{
            return if(isHd) {
                FRAME_RATE_HD * SECONDS_IN_A_MINUTE * duration
            }else{
                FRAME_RATE_SD * SECONDS_IN_A_MINUTE * duration
            }
        }
    }

    abstract fun play(): Unit  //los métodos deben ser abstractos y vacíos en una clase abstracta

    abstract fun pause()

    abstract fun played():Boolean //este se puede dejar open y no sobreescribirlo igual en las hijas? Tener presente la private var v=false

    abstract fun playTrailer()

    //y40
    override fun compareTo(other: Media): Int {
        return this.name.compareTo(other.name) //Para organizar alfabéticamente
        //return this.duration-other.duration //Para organizar por duración de menor a mayor. Recordar que para Series, duration es la duración de un episodio
    }



}