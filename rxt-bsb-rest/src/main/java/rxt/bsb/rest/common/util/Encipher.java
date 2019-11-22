package rxt.bsb.rest.common.util;

public class Encipher {
	  public final static String m_strKey1 = "zxcvbnm,./asdfg";

	  public final static String m_strKeya = "cjk;";

	  public final static String m_strKey2 = "hjkl;'qwertyuiop";

	  public final static String m_strKeyb = "cai2";

	  public final static String m_strKey3 = "[]\\1234567890-";

	  public final static String m_strKeyc = "%^@#";

	  public final static String m_strKey4 = "=` ZXCVBNM<>?:LKJ";

	  public final static String m_strKeyd = "*(N";

	  public final static String m_strKey5 = "HGFDSAQWERTYUI";

	  public final static String m_strKeye = "%^HJ";

	  public final static String m_strKey6 = "OP{}|+_)(*&^%$#@!~";

	  public static String Encode(String str) {
	    String strEncode = new String("");
	    int n;
	    char code;
	    String des = new String();
	    String strKey = new String();

	    if ((str == null) | str.length() == 0) {
	      strEncode = "";
	      return strEncode;
	    }
	    strKey = m_strKey1 + m_strKey2
	        + m_strKey3 + m_strKey4
	        + m_strKey5 + m_strKey6;
	    while (str.length() < 8) {
	      str = str + (char) 1;
	    }
	    des = "";
	    for (n = 0; n <= str.length() - 1; n++) {
	      while (true) {
	        code = (char) Math.rint(Math.random() * 100);
	        while ((code > 0)&
	             (((code ^ str.charAt(n)) < 0) || ((code ^ str.charAt(n)) > 90))) {
	          code = (char) ((int) code - 1);
	        }
	        char mid = 0;
	        int flag;
	        flag = code ^ str.charAt(n);
	        if (flag > 93) {
	          mid = 0;
	        } else {
	          mid = strKey.charAt(flag); // Asc(Mid(strKey, (code Xor
	                        // Asc(Mid(str, n, 1))) +
	                        // 1, 1))
	        }
	        if ((code > 35) & (code < 122) & (code != 124) & (code != 39)
	            & (code != 44) & (mid != 124) & (mid != 39)
	            & (mid != 44)) {
	          break;
	        }
	        // 确保生成的字符是可见字符并且在SQL语句中有效
	      }
	      char temp = 0;
	      temp = strKey.charAt(code ^ str.charAt(n));
	      des = des + (char) code + temp;
	    }
	    strEncode = des;
	    return strEncode;
	  }

	  public static String Decode(String varCode) {
	    int n;
	    String des = new String();
	    String strKey = new String();
	    if ((varCode == null) || (varCode.length() == 0)) {
	      return "";
	    }
	    strKey = m_strKey1 + m_strKey2
	        + m_strKey3 + m_strKey4
	        + m_strKey5 + m_strKey6;
	    if (varCode.length() % 2 == 1) {
	      varCode = varCode + "?";
	    }
	    des = "";
	    for (n = 0; n <= varCode.length() / 2 - 1; n++) {
	      char b;
	      b = varCode.charAt(n * 2);
	      int a;
	      a = (int) strKey.indexOf(varCode.charAt(n * 2 + 1));
	      des = des + (char) ((int) b ^ a);
	    }
	    n = des.indexOf(1);
	    if (n > 0) {
	      return des.substring(0, n);
	    } else {
	      return des;
	    }
	  }
	  public static void main(String[] args){
		  System.out.println(Encipher.Encode("1qaz!QAZ"));
		  System.out.println(Encipher.Decode(Encipher.Encode("1qaz!QAZ")));
	  }
	}
