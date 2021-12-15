class MediaDownloader {

    interface DownloadListener{
        fun onDownloadFisnished(media: Media)
    }

    fun downloadMedia(downloadListener:DownloadListener){
        val thread=Thread(Runnable {
            println("Download started")
            Thread.sleep(3000)
            println("Download finish")

            val downloadedMovie=Movie("Troya",105,true)
            downloadListener.onDownloadFisnished(downloadedMovie)
        })
        thread.start()
    }

    fun downloadMedia(onDownloadFinishedWithLambda: (media: Media) -> Unit){

        val thread=Thread(Runnable {
            println("Download started")
            Thread.sleep(3000)
            println("Download finish")

            val downloadedMovie=Movie("Troya",105,true)
            onDownloadFinishedWithLambda(downloadedMovie)
        })
        thread.start()

    }
}