class CineBoxPlayer:MediaDownloader.DownloadListener {
    override fun onDownloadFisnished(media: Media) {
        media.play()
    }

    init{
        val mediaDownloader=MediaDownloader()
        mediaDownloader.downloadMedia(this)
    }

}