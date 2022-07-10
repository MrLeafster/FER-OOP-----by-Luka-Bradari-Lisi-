package samostalno_3.zad_1;

class IPv6Utils {
	public static void checkIPv6AddressValidity(String ip) throws InvalidIPv6AddressException {
		String[] ipNumbers = ip.split(":");
		
		// #1 duljina
		if(ipNumbers.length != 8) {
			throw new InvalidIPv6AddressException("IPv6 address does not contain 8 hexadecimal numbers!");
		}
		
		// #2 provjera brojeva
		for(String ipNum: ipNumbers) {
			Integer tempIpNumber;
			
			// #2.1 ispravan broj
			try {
				tempIpNumber = Integer.parseInt(ipNum, 16);
			} catch(NumberFormatException e) {
				throw new InvalidIPv6AddressException("One or more strings in the IPv6 address are not hexadecimal numbers!");
			}
			
			// #2.2 broj u range-u
			if(!(tempIpNumber >= 0 && tempIpNumber <= Integer.parseInt("FFFF", 16))) {
				throw new InvalidIPv6AddressException("One or more numbers in the IPv6 address are not in the correct range!");
			}
		}
	}
}
