package unl.soc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import unl.soc.albums.Album;
import unl.soc.albums.Band;

/**
 * Utility class for interacting with the database
 *
 */
public class DataLoader {
	

	/**
	 * This method returns a {@link #Album} instance loaded from the 
	 * database corresponding to the given {@code albumId}.  
	 * Returns {@code null} if the {@code albumId} is
	 * invalid.
	 * 
	 * All fields are loaded with this method including band information,
	 * musicians, and album songs.
	 * 
	 * @param albumId
	 * @return
	 */
	public static Album loadDetailedAlbum(int albumId) {
		//TODO in Lab 09
		return null;
	}
	
	/**
	 * Returns a list of all albums in the database.  However, this
	 * is only a summary so only the following items need to be loaded
	 * from the database:
	 * <ul>
	 *   <li>Album ID</li>
	 *   <li>Album Title</li>
	 *   <li>Album Year</li>
	 *   <li>Band ID</li>
	 *   <li>Band Name</li>
	 * </ul>
	 *   
	 * @return
	 */
	public static List<Album> loadAlbumSummaries() {
		//TODO in Lab 09
		return null;
	}

	/**
	 * This method returns a {@link #Band} instance loaded from the 
	 * database corresponding to the given {@code bandId}.  
	 * Throws an {@link IllegalStateException} upon an invalid {@code bandId}.
	 * All fields are loaded with this method.
	 * 
	 * @param bandId
	 * @return
	 */
	public static Band loadBand(int bandId) {
		Band b = null;
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.USERNAME, DatabaseInfo.PASSWORD);
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		

		String query = "SELECT name FROM Band WHERE bandId = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, bandId);
			rs = ps.executeQuery();
			if(rs.next()) {
				String bandName = rs.getString("name");
				b = new Band(bandId, bandName);
			} else {
				throw new IllegalStateException("no such band with bandId = " + bandId);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		query = "SELECT firstName, lastName, country FROM BandMember bm JOIN Musician m ON bm.musicianId = m.musicianId WHERE bm.bandId = ?";
		
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, bandId);
			rs = ps.executeQuery();
			while(rs.next()) {
				String musicianLastName = rs.getString("lastName");
				String musicianFirstName = rs.getString("firstName");
				b.addMember(musicianLastName + ", " + musicianFirstName);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
			if(ps != null && !ps.isClosed()) {
				ps.close();
			}
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return b;
	}
}
