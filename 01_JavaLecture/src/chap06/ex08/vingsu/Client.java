package chap06.ex08.vingsu;

public class Client {

	public static void main(String[] args) {

		VingsuConcrete vingsuCon = new VingsuConcrete();
		
		vingsuCon.makeVingsu(new RedBeanVingsu());
		
		System.out.println();
		
		vingsuCon.makeVingsu(new ChocoVingsu());
		
		System.out.println();
		
		vingsuCon.makeVingsu(new CookieVingsu());

	}

}
