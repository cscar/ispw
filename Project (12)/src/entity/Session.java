package entity;

public class Session {
	
	private static Session instance = null;
	private Customer customer;
	private Scout scout;
	private Administrator administrator;
	private boolean isTenant;
	private boolean isLandLord;
	private boolean isScout;
	private boolean isAdministrator;
	
	private Session() {
		logout();
	}
	
	public void loginAsTenant(Customer customer) {
		this.logout();
		this.customer = customer;
		this.isTenant = true;
	}
	
	public void loginAsLandLord(Customer customer) {
		this.logout();
		this.customer = customer;
		this.isLandLord = true;
	}
	
	public void loginAsTenantAndLandLord(Customer customer) {
		this.logout();
		this.customer = customer;
		this.isTenant = true;
		this.isLandLord = true;
	}
	
	public void loginAsScout(Scout scout) {
		this.logout();
		this.scout = scout;
		this.isScout = true;
	}
	
	public void loginAsAdministrator(Administrator admin) {
		this.logout();
		this.administrator = admin;
		this.isAdministrator = true;
	}
	
	public boolean isTenant() {
		return isTenant;
	}
	
	public boolean isLandLord() {
		return isLandLord;
	}
	
	public boolean isScout() {
		return isScout;
	}
	
	public boolean isAdministrator() {
		return isAdministrator;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public Scout getScout() {
		return scout;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void logout() {
		this.customer = null;
		this.scout = null;
		this.administrator = null;
		this.isLandLord = false;
		this.isTenant = false;
		this.isScout = false;
		this.isAdministrator = false;
	}

	public synchronized static final Session getSessionInstance() {
		if (Session.instance == null) {
			Session.instance = new Session();
		}
		return Session.instance;
	}
}
