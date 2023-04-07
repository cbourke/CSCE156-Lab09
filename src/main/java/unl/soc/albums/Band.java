package unl.soc.albums;

import java.util.ArrayList;
import java.util.List;

public class Band {

	private Integer bandId;
	private String name;
	private List<String> members = new ArrayList<String>();
	
	public Band(Integer bandId, String name) {
		super();
		this.bandId = bandId;
		this.name = name;
	}
	
	public Band(String name) {
		this(null, name);
	}

	public Integer getBandId() {
		return bandId;
	}

	public String getName() {
		return name;
	}

	public List<String> getMembers() {
		return members;
	}
	
	public void addMember(String name) {
		this.members.add(name);
	}
	
	
	@Override
	public int hashCode() {
		return bandId != null ? bandId.hashCode() : 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Band && bandId != null) {
			return bandId.equals(((Band) obj).bandId);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Band [bandId=" + bandId + ", name=" + name + ", members="
				+ members + "]";
	}
	
	
}
