package java8work;

public class Address {

	String addressType;
	String country;

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address(String addressType, String country) {
		super();
		this.addressType = addressType;
		this.country = country;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Address [addressType=" + addressType + ", country=" + country + "]";
	}

}
