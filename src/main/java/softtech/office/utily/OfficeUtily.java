package softtech.office.utily;

import java.text.NumberFormat;
import java.util.Locale;

public class OfficeUtily {

	//　データ変換処理
	public String toDate(String value) {

		String str1 = value.substring(0, 4);
		String str2 = value.substring(4, 6);
		String str3 = value.substring(6, 8);
		String str = str1 + "年" + str2 + "月" + str3 + "日";

		return str;

	}

	public String getCurrencyInstance(String number) {

		NumberFormat nfCur = NumberFormat.getCurrencyInstance(Locale.JAPAN);
		String num = nfCur.format(Long.parseLong(number));
		return num;

	}

	public String toDate1(String value) {

		String str1 = value.substring(0, 4);
		String str2 = value.substring(4, 6);
		String strr = str1 + "年" + str2 + "月";

		return strr;

	}

	public String toYYYYMM(String value) {

		String str1 = value.substring(0, 4);
		String str2 = value.substring(5, 7);
		String strr = str1 + str2;

		return strr;

	}

}
