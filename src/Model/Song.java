package Model;



public class Song  {
	

	private String path;
	private String title;
	private String artist;
	private String composer;
	private String genre;
	private String album;
	
	public Song()
	{
		setPath(null);
		setTitle(null);
		setArtist(null);
		setComposer(null);
		setGenre(null);
		setAlbum(null);
	}
	
	Song(InfoCommand infoSong)
	{
		this.setPath(infoSong.getPath());
		this.setTitle(infoSong.getTitle());
		this.setArtist(infoSong.getArtist());
		this.setComposer(infoSong.getComposer());
		this.setGenre(infoSong.getGenre());
		this.setAlbum(infoSong.getAlbum());
	}
	public void afisare()
	{
		System.out.println("Afisare din song");
		System.out.println(this.path);
		System.out.println(this.title);
		System.out.println(this.artist);
		System.out.println(this.album);
		System.out.println(this.composer);
		System.out.println(this.genre);

	}
	
	@Override
	  public String toString() {
	    return String.format("[Song: path='%s', \n\t title=%s,\n\t artist=%s,\n\t album=%s, \n\t composer=%s, \n\t genre=%s]", path, title, artist,album,composer,genre);
	  }

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}
}
