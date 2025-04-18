package bean;

/**
 *  投票数を保管するクラス
 */
public class Count {
	/** 選択肢Aの投票数 */
	private int A;
	/** 選択肢Bの投票数 */
	private int B;

	/**
	 * ゲッター
	 * @return 選択肢Aの投票数
	 */
	public int getA() {
		return A;
	}
	/**
	 * セッター
	 * @param a 選択肢Aの投票数
	 */
	public void setA(int a) {
		A = a;
	}
	/**
	 * ゲッター
	 * @return 選択肢Bの投票数
	 */
	public int getB() {
		return B;
	}
	/**
	 * セッター
	 * @param b 選択肢Bの投票数
	 */
	public void setB(int b) {
		B = b;
	}

	/**
	 * 総投票数を取得する
	 * @return 総投票数
	 */
	public int sum() {
		return A + B;
	}
}
