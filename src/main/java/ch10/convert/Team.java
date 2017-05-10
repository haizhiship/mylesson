package ch10.convert;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.NumberFormat;

public class Team {
	private int id;

	private List<String> names;
	private Member leader;
	private LocalDate createDate;
	private Member viceLeader;

	@NumberFormat(pattern = "c:0000")
	private int memberCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public Member getLeader() {
		return leader;
	}

	public void setLeader(Member leader) {
		this.leader = leader;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Member getViceLeader() {
		return viceLeader;
	}

	public void setViceLeader(Member viceLeader) {
		this.viceLeader = viceLeader;
	}
}
