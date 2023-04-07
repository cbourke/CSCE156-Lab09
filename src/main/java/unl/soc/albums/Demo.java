package unl.soc.albums;

import java.util.List;

import unl.soc.database.DataLoader;

public class Demo {

	public static void main(String args[]) {

		List<Album> disc = DataLoader.loadAlbumSummaries();

		for(Album a : disc) {
			System.out.println(a.getTitle() + " (id = "+a.getAlbumId()+") by " + a.getBand().getName() + " (id = "+a.getBand().getBandId()+"), " + a.getYear());
		}
		
	}
}
