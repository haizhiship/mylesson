package ch10.convert;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class MemberFormatter implements Formatter<Member> {

	public String print(Member arg0, Locale arg1) {
		// TODO Auto-generated method stub
		return arg0.getName();
	}

	public Member parse(String arg0, Locale arg1) throws ParseException {
		// TODO Auto-generated method stub
		Member m = new Member();
		m.setName(arg0);

		return m;
	}

}
