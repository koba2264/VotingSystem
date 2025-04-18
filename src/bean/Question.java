package bean;

/**
 * 問題文と選択肢を保持するbeanクラス
 * @author s_kobayashi
 *
 */
public class Question implements java.io.Serializable {
	private static int id = 1;

	private int questionId;
	/** 問題文 */
	private String text;
	/** 選択肢A */
	private String ChoicesA;
	/** 選択肢B */
	private String ChoicesB;

	public static void setId(int id) {
		Question.id = id;
	}

	/**
	 * 問題文のセッター
	 * @param text 問題文
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 選択肢Aのセッター
	 * @param choicesA 選択肢A
	 */
	public void setChoicesA(String choicesA) {
		ChoicesA = choicesA;
	}

	/**
	 * 選択肢Bのセッター
	 * @param choicesB 選択肢B
	 */
	public void setChoicesB(String choicesB) {
		ChoicesB = choicesB;
	}

	/**
	 * 問題文のゲッター
	 * @return 問題文の原文
	 */
	public String getText() {
		return text;
	}

	/**
	 * 選択肢Aのゲッター
	 * @return 選択肢Aの原文
	 */
	public String getChoicesA() {
		return ChoicesA;
	}

	/**
	 * 選択肢Bのゲッター
	 * @return 選択肢Bの原文
	 */
	public String getChoicesB() {
		return ChoicesB;
	}

	public static int getId() {
		return Question.id;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
}
