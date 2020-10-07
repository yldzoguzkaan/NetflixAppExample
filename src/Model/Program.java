package Model;

import java.util.ArrayList;
import java.util.List;

public class Program {
	private int id;
	private String name;
	private String type;
	private List<String> kind = new ArrayList<String>();
	private int episodeCount;
	private int episodeTime;
	private int score;
	
	public Program() {
	}

	public Program(String name, String type, List<String> kind, int episodeCount, int episodeTime, int score) {
		super();
		this.name = name;
		this.type = type;
		this.kind = kind;
		this.episodeCount = episodeCount;
		this.episodeTime = episodeTime;
		this.score = score;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getKind() {
		return kind;
	}
	public void setKind(List<String> kind) {
		this.kind = kind;
	}
	public int getEpisodeCount() {
		return episodeCount;
	}
	public void setEpisodeCount(int episodeCount) {
		this.episodeCount = episodeCount;
	}
	public int getEpisodeTime() {
		return episodeTime;
	}
	public void setEpisodeTime(int episodeTime) {
		this.episodeTime = episodeTime;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Program [id=" + id + ", name=" + name + ", type=" + type + ", kind=" + kind.toString() + ", episodeCount=" + episodeCount
				+ ", episodeTime=" + episodeTime + ", score=" + score + "]";
	}
}
