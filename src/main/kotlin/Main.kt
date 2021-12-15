//y41-y42
fun main(args: Array<String>) {

    val movie1=Movie("Tuxedo", 80,true)
    val movie2=Movie("Tuxedo", 80,true)

    var trailerMonk=Trailer()


    val movie3=Movie("FF2", 150, true)
    val series3=Series("Monk",40,true,trailerMonk)

    val movie4=Movie("The craziest emperator",55,true)
    val movie5=Movie("Willie the bale",75,true)
    val movie6=Movie("Cars",85,true)
    val movie7=Movie("Godzilla",80,true)

    val series4=Series("Bigbang theory", 30, true)
    val series5=Series("The simpsons", 20, true)
    val series6=Series("Drake and Josh", 25, true)
    val series7=Series("Lost", 40, true)

    series3.playTrailer()

    val seriesList= listOf<Series>(series3,series4,series5,series6,series7)
    println("The 1st item of the seriesList is ${seriesList[0]}")

    var mediaList=
        mutableListOf<Media>()
    mediaList.add(movie2)
    mediaList.add(series3)
    mediaList.add(movie3)
    mediaList.add(movie4)

    mediaList.add(series4)
    mediaList.add(movie5)

    addIfNotInList(mediaList,movie5) //agregar movie5 si no está en la lista
    addIfNotInList(mediaList,series6) //agregar series6 si no está en la lista //añadiendo con método en main

    mediaList.addIfNotInList1(movie7)//añadiendo con extension

    mediaList.sort()
    showPlaylist(mediaList)

    //y41 HashMap
    val mediaMap=HashMap<String, Media>() //Par de clave y valor
    mediaMap["Cero"]=movie1
    mediaMap["Dos"]=series6
    mediaMap["Tres"]=series4

    println(mediaMap["Dos"])

    for(value in mediaMap.values){ //el mediaMap.values devuelve un set
        println(value)
    }
    for(key in mediaMap.keys){
        println(key)
    }
}

fun playMedia(media: Media){
    media.play()
}

fun showPlaylist(list: MutableList<Media>){
    println("")
    println("----Start Show list: mediaList----")
    for(item in list){
        println(item)
        //item.play() //Este comando reproducirá cada item
    }
    println("----End Show list: mediaList----")
    println("")
}

fun addIfNotInList(list:MutableList<Media>, media: Media) {
    var p = ""
    if (!list.contains(media)) {
        list.add(media)
    } else {
        if (media is Movie) {
            p = "Movie"
        } else {
            p = "Series"
        }
        println("$p ${media.name} is already in playlist")
    }
}

    //y42 Extensiones
fun MutableList<Media>.addIfNotInList1(media: Media){
    var p=""
    if(!this.contains(media)){
        this.add(media)
    }else{
        if(media is Movie) {
            p = "Movie"
        }else{
            p="Series"
        }
        println("$p ${media.name} is already in playlist")
    }
}

fun <T> MutableList<T>.addIfNotInList2(myObject: T){ //Se puede usar para cualquier clase de objeto
    if(!this.contains(myObject)){
        this.add(myObject)
    }else{
        println("${myObject} is already in playlist") //myObject debe tener override toString
    }
}


