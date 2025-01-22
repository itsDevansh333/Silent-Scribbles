
public class Encryption {
	public String encrytion(int key, String Text) {
		String text="";
		for(int i=0;i<Text.length();i++) {
			int ch=((int)Text.charAt(i));
			if(ch>=65&&ch<=90) {
				ch=ch-64;
				ch=(ch+key)%26;
				ch=ch+64;
			}
			else if(ch>=97 && ch<=122) {
				ch=ch-97;
				ch=(ch+key)%26;
				ch=ch+97;
			}
			text=text+(char)ch;
			
		}
		//System.out.println(text);
		return text;
	}
	public String decryption(int key, String Text) {
		String text="";
		for(int i=0;i<Text.length();i++) {
			int ch=((int)Text.charAt(i));
			if(ch>=65&&ch<=90) {
				ch=ch-64;
				ch=(ch-key);
				if(ch<1) {
					ch=26-ch;
				}
				ch=ch+64;
			}
			else if(ch>=97 && ch<=122) {
				ch=ch-96;
				ch=(ch-key);
				if(ch<1) {
					ch=26+ch;
				}
				ch=ch+96;
			}
			text=text+(char)ch;
			
		}
		//System.out.println(text);
		return text;
	}
	public static void main(String[] args) {
		Encryption e1=new Encryption();
		e1.decryption(2, "Fgxcpuj");
	}
}
