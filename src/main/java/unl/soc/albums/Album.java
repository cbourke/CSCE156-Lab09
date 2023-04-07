package unl.soc.albums;

import java.util.ArrayList;
import java.util.List;

public class Album {

	private Integer albumId;
	private String title;
	private Integer year;
	private Band band;
	private List<String> songTitles = new ArrayList<String>();
	
	public Album(Integer albumId, String title, Integer year, Band band) {
		super();
		this.albumId = albumId;
		this.title = title;
		this.year = year;
		this.band = band;
	}

	public Album(String title, Integer year, String bandName) {
		this(null, title, year, new Band(bandName));
	}
	
	public Album(Integer albumId, String title) {
		super();
		this.albumId = albumId;
		this.title = title;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public Band getBand() {
		return band;
	}

	public List<String> getSongTitles() {
		return songTitles;
	}

	public void addSong(String songTitle) {
		this.songTitles.add(songTitle);
	}	

	@Override
	public String toString() {
		return title + " (id = " + albumId + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albumId == null) ? 0 : albumId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (albumId == null) {
			if (other.albumId != null)
				return false;
		} else if (!albumId.equals(other.albumId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
	
	
	
}
