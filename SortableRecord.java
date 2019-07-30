public class SortableRecord extends Record implements Comparable<SortableRecord> {
	private Integer scoreTotal;
	private Integer scoreMath;
	private Integer scoreJapanese;
	private Integer scoreEnglish;
	
	public SortableRecord(String id, Integer j, Integer m, Integer e) { super(id, j, m, e); }
	
	public int getTotalScore() { return score_total; }
	public int getMathScore() { return score_math; }
	public int getJapanScore() { return score_Japanese; }
	public int getEnglishScore() { return score_English; }
	
	public void setScore(int j, int m, int e) {
		scoreTotal = j + m + e;
		scoreJapanese = j;
		scoreMath = m;
		scoreEnglish = e;
	}
	
	public String toString() { return super.toString(); }
	
	public int compareTo(SortableRecord v) {
		setScore(score_Japanese, score_math, score_English);
		return result(v);
	}
	
	public int result(SortableRecord v) {
		int result = scoreTotal.compareTo(v.getTotalScore())*-1;
		result = result == 0 ? scoreMath.compareTo(v.getMathScore())*-1 : result;
		result = result == 0 ? scoreJapanese.compareTo(v.getJapanScore())*-1 : result;
		return result == 0 ? scoreEnglish.compareTo(v.getEnglishScore())*-1 : result;
	}
}
