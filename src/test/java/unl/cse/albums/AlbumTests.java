package unl.cse.albums;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;

/**
 * This is a suite of tests for the {@link #Album} class.
 * 
 */
public class AlbumTests {

	/**
	 * Tests that the {@link Album#getAlbumSummaries()} method contains a minimal
	 * number of albums (as should exist if the albums database has been installed
	 * properly) as well as several known albums that should exist.
	 * 
	 */
	@Test
	public void getAlbumSummariesTest() {

		Album expectedAlbum01 = new Album(1, "The Velvet Underground & Nico");
		Album expectedAlbum02 = new Album(2, "Bleach");
		Album expectedAlbum03 = new Album(3, "Nevermind");
		Album expectedAlbum04 = new Album(5, "Rain Dogs");
		Album expectedAlbum05 = new Album(103, "Help!");
		int expectedNumberOfAlbums = 5;
		List<Album> actual = Album.getAlbumSummaries();

		Assertions.assertNotNull(actual);
		Assertions.assertTrue(actual.contains(expectedAlbum01),
				"Database appears to be missing " + expectedAlbum01 + " or getAlbumSummaries() does not include it");
		Assertions.assertTrue(actual.contains(expectedAlbum02),
				"Database appears to be missing " + expectedAlbum02 + " or getAlbumSummaries() does not include it");
		Assertions.assertTrue(actual.contains(expectedAlbum03),
				"Database appears to be missing " + expectedAlbum03 + " or getAlbumSummaries() does not include it");
		Assertions.assertTrue(actual.contains(expectedAlbum04),
				"Database appears to be missing " + expectedAlbum04 + " or getAlbumSummaries() does not include it");
		Assertions.assertTrue(actual.contains(expectedAlbum05),
				"Database appears to be missing " + expectedAlbum05 + " or getAlbumSummaries() does not include it");

		Assertions.assertTrue(actual.size() >= expectedNumberOfAlbums,
				"Database does not appear to contain at least " + expectedNumberOfAlbums + " album records");
	}

	/**
	 * Tests that the {@link Album#getDetailedAlbum(int)} method returns an album's
	 * details. The album is expected to be in the database if installed properly
	 * (Tom Wait's Rain Dogs)
	 * 
	 */
	@Test
	public void getDetailedAlbumTest01() {

		List<String> expectedSongs = Arrays.asList("Singapore", "Clap Hands", "Cemetery Polka",
				"Jockey Full of Bourbon", "Tango Till They're Sore", "Big Black Mariah", "Diamonds & Gold",
				"Hang Down Your Head", "Time", "Rain Dogs", "Midtown", "9th & Hennepin", "Gun Street Girl",
				"Union Square", "Blind Love", "Walking Spanish", "Downtown Train", "Bride of Rain Dog",
				"Anywhere I Lay My Head");

		Album actual = Album.getDetailedAlbum(5);
		Assertions.assertNotNull(actual);
		Assertions.assertEquals(5, actual.getAlbumId());
		Assertions.assertEquals("Rain Dogs", actual.getTitle());
		Assertions.assertEquals(1985, actual.getYear());
		Assertions.assertEquals(3, actual.getBand().getBandId());
		Assertions.assertEquals("Tom Waits", actual.getBand().getName());
		Assertions.assertEquals(actual.getSongTitles(), expectedSongs);

	}

	/**
	 * Tests that the {@link Album#getDetailedAlbum(int)} method returns an album's
	 * details. The album is expected to be in the database if installed properly
	 * (Nirvana's In Utero)
	 * 
	 */
	@Test
	public void getDetailedAlbumTest02() {

		List<String> expectedSongs = Arrays.asList(

				"Serve the Servants", "Scentless Apprentice", "Heart-Shaped Box", "Rape Me",
				"Frances Farmer Will Have Her Revenge on Seattle", "Dumb", "Very Ape", "Milk It", "Pennyroyal Tea",
				"Radio Friendly Unit Shifter", "tourette's", "All Apologies");

		Album actual = Album.getDetailedAlbum(4);
		Assertions.assertNotNull(actual);
		Assertions.assertEquals(4, actual.getAlbumId());
		Assertions.assertEquals("In Utero", actual.getTitle());
		Assertions.assertEquals(1993, actual.getYear());
		Assertions.assertEquals(2, actual.getBand().getBandId());
		Assertions.assertEquals("Nirvana", actual.getBand().getName());
		Assertions.assertEquals(actual.getSongTitles(), expectedSongs);

	}

	/**
	 * Tests that the {@link Album#getDetailedAlbum(int)} method returns an album's
	 * details. The album is expected to be in the database if installed properly
	 * (Meshuggah's Koloss)
	 * 
	 */
	@Test
	public void getDetailedAlbumTest03() {

		List<String> expectedSongs = Arrays.asList("I Am Colossus", "The Demons Name Is Surveillance",
				"Do Not Look Down", "Behind The Sun", "The Hurt That Finds You First", "Marrow",
				"Break Those Bones Whose Sinews Gave It Motion", "Swarm", "Demiurge", "The Last Vigil");

		Album actual = Album.getDetailedAlbum(654);
		Assertions.assertNotNull(actual);
		Assertions.assertEquals(654, actual.getAlbumId());
		Assertions.assertEquals("Koloss", actual.getTitle());
		Assertions.assertEquals(2012, actual.getYear());
		Assertions.assertEquals(2478, actual.getBand().getBandId());
		Assertions.assertEquals("Meshuggah", actual.getBand().getName());
		Assertions.assertEquals(actual.getSongTitles(), expectedSongs);

	}

}