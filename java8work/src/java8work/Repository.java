package java8work;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repository {

	static void mainframe() {
		System.out.println("Hello mainframe ");
	}

	static void AS400() {
		System.out.println("Hello AS400 ");
	}
	
	public Object add(Address a) {
		if (a.getAddressType().equalsIgnoreCase("S")) {
			Address asdfa = new Address();
			a.setAddressType("dfasdaf");
			a.setCountry("jdf");
			return a;
		}
		return null;
	}

	public static void main(String[] args) {

//		 String senderCountryId = addressList.stream().
//				 filter(countryDetails -> countryDetails.getAddressType().equalsIgnoreCase("S"))
//				 .map(countryId -> countryId.getCountry()).toString();
//		 
//		 String receiverCountryId = addressList.stream().
//				 filter(countryDetails -> countryDetails.getAddressType().equalsIgnoreCase("R"))
//				 .map(countryId -> countryId.getCountry()).toString();
		Address address = new Address();
		List<Address> addressList = Arrays.asList(new Address("S", "IT"), new Address("R", "DK"),
				new Address("C", "GB"), new Address("D", "PT"));
		System.out.println(addressList.toString());
		String receiverCountryId = addressList.stream()
				.filter(countryDetails -> countryDetails.getAddressType().equalsIgnoreCase("R"))
				.map(countryId -> countryId.getCountry()).findFirst().orElse(null);

		String senderCountryId = addressList.stream()
				.filter(countryDetails -> countryDetails.getAddressType().equalsIgnoreCase("S"))
				.map(countryId -> countryId.getCountry()).findAny().orElse(null);

		Map<String, String> data = new HashMap<String, String>();
		for (Address address2 : addressList) {
			System.out.println("ss "+address2.toString());
			data.put(address2.getAddressType(), address2.getCountry());
		}
		System.out.println("------------------------");
		System.out.println("data " + data);
		for (Map.Entry<String, String> mapdata : data.entrySet()) {
			System.out.println("key " + mapdata.getKey() + " value " + mapdata.getValue());
			if (mapdata.getValue().contentEquals("IT")) {
				System.out.println("contains " + mapdata.getValue().contentEquals("IT"));
			}
			if ((mapdata.getKey().equalsIgnoreCase("S") && mapdata.getValue().equalsIgnoreCase("It"))
					|| (mapdata.getKey().equalsIgnoreCase("R") && mapdata.getValue().equalsIgnoreCase("IT"))) {
				System.out.println(
						" getKey = " + mapdata.getKey() + " getValue = " + mapdata.getValue() + " Filiali data");
			}
		}
		System.out.println("------------------------");
		System.out.println("oooooooooooooooooooooooo");
		for (Address address2 : addressList) {
			if (address2.getCountry().equalsIgnoreCase("GB")) {
				System.out.println("isItaly = " + address2.getCountry());
				break;
			}
			System.out.println("address2.getCountry()" + address2.getCountry());

		}
		
		Repository r = new Repository();
		Address a = new Address("hi", "IT");
		System.out.println("iiiiiiiiiiiiiiii");
		System.out.println(r.add( a));
		
		System.out.println("oooooooooooooooooooooooo");

//		 System.out.println("receiver : "+receiverCountryId);
//		 System.out.println("sender : "+senderCountryId);

		if ((senderCountryId != null && senderCountryId.equalsIgnoreCase("IT")
				&& !receiverCountryId.equalsIgnoreCase("IT"))
				|| (receiverCountryId != null && receiverCountryId.equalsIgnoreCase("IT")
						&& !senderCountryId.equalsIgnoreCase("IT"))) {
			System.out.println("Data pushed to AS400 International method call");
			AS400();
		} else if ((senderCountryId != null && senderCountryId.equalsIgnoreCase("IT")
				&& (receiverCountryId != null && receiverCountryId.equalsIgnoreCase("IT")))) {
			System.out.println("Data pushed to AS400 Domestic call");
		} else {
			System.out.println("Mainframe flow call ");
		}
	}

}
