package entity.language;

import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import boundary.administrator.BoundaryPanelAdministrator;
import boundary.administrator.BoundaryPanelAdministratorEnglish;
import boundary.authentication.BoundaryPanelAuthentication;
import boundary.authentication.BoundaryPanelAuthenticationEnglish;
import boundary.frame.BoundaryPanelFrame;
import boundary.frame.BoundaryPanelFrameEnglish;
import boundary.iban.BoundaryPanelIban;
import boundary.iban.BoundaryPanelIbanEnglish;
import boundary.landlord.BoundaryPanelLandLord;
import boundary.landlord.BoundaryPanelLandLordEnglish;
import boundary.landlord.changepassword.BoundaryPanelChangePasswordEnglishLandLord;
import boundary.landlord.changepassword.BoundaryPanelChangePasswordLandLord;
import boundary.landlord.changeprofile.BoundaryPanelChangeProfileLandLord;
import boundary.landlord.changeprofile.BoundaryPanelChangeProfileLandLordEnglish;
import boundary.landlord.profile.BoundaryPanelProfileLandLord;
import boundary.landlord.profile.BoundaryPanelProfileLandLordEnglish;
import boundary.login.BoundaryPanelLogin;
import boundary.login.BoundaryPanelLoginEnglish;
import boundary.registration.BoundaryPanelRegistration;
import boundary.registration.BoundaryPanelRegistrationEnglish;
import boundary.registration.properties.BoundaryPanelRegistrationProperties;
import boundary.registration.properties.BoundaryPanelRegistrationPropertiesEnglish;
import boundary.rent.BoundaryPanelRent;
import boundary.rent.BoundaryPanelRentEnglish;
import boundary.scout.BoundaryPanelScout;
import boundary.scout.BoundaryPanelScoutEnglish;
import boundary.scout.properties.BoundaryPanelProperty;
import boundary.scout.properties.BoundaryPanelPropertyEnglish;
import boundary.search.BoundaryPanelSearch;
import boundary.search.BoundaryPanelSearchEnglish;
import boundary.search.properties.BoundaryPanelSearchProperty;
import boundary.search.properties.BoundaryPanelSearchPropertyEnglish;
import boundary.tenant.BoundaryPanelTenant;
import boundary.tenant.BoundaryPanelTenantEnglish;
import boundary.tenant.changepassword.BoundaryPanelChangePasswordTenant;
import boundary.tenant.changepassword.BoundaryPanelChangePasswordTenantEnglish;
import boundary.tenant.changeprofile.BoundaryPanelChangeProfileTenant;
import boundary.tenant.changeprofile.BoundaryPanelChangeProfileTenantEnglish;
import boundary.tenant.profile.BoundaryPanelProfileTenant;
import boundary.tenant.profile.BoundaryPanelProfileTenantEnglish;
import entity.properties.Property;

public class LanguageEnglish implements Language {

	@Override
	public BoundaryPanelFrame createMainPanel(JFrame frame) {
		return new BoundaryPanelFrameEnglish(frame);
	}

	@Override
	public BoundaryPanelRegistration createPanelRegistration(JDialog dialog) {
		return new BoundaryPanelRegistrationEnglish(dialog);
	}

	@Override
	public BoundaryPanelLogin createPanelLogin(JDialog dialog) {
		return new BoundaryPanelLoginEnglish(dialog);
	}

	@Override
	public BoundaryPanelLandLord createPanelLandLord(JDialog dialog) {

		return new BoundaryPanelLandLordEnglish(dialog);
	}

	@Override
	public BoundaryPanelTenant createPanelTenant(JDialog dialog) {

		return new BoundaryPanelTenantEnglish(dialog);
	}

	@Override
	public BoundaryPanelRegistrationProperties createPanelRegistrationProperties(JDialog dialog) {

		return new BoundaryPanelRegistrationPropertiesEnglish(dialog);
	}

	@Override
	public BoundaryPanelAdministrator createPanelAdministrator(JDialog dialog) {

		return new BoundaryPanelAdministratorEnglish(dialog);
	}

	@Override
	public BoundaryPanelProfileLandLord createPanelProfileLandLord(JDialog dialog) {

		return new BoundaryPanelProfileLandLordEnglish(dialog);
	}

	@Override
	public BoundaryPanelChangeProfileLandLord createPanelChangeProfileLandLord(JDialog dialog) {

		return new BoundaryPanelChangeProfileLandLordEnglish(dialog);
	}

	@Override
	public BoundaryPanelChangePasswordLandLord createPanelChangePasswordLandLord(JDialog dialog) {

		return new BoundaryPanelChangePasswordEnglishLandLord(dialog);
	}

	@Override
	public BoundaryPanelScout createPanelScout(JDialog dialog) {
		return new BoundaryPanelScoutEnglish(dialog);
	}

	@Override
	public BoundaryPanelProperty createPanelProperty(JDialog dialog, Property property) {
		return new BoundaryPanelPropertyEnglish(dialog, property);
	}

	@Override
	public BoundaryPanelSearch createPanelSearch(Window window, ArrayList<Property> properties) {
		return new BoundaryPanelSearchEnglish(window, properties);
	}

	@Override
	public BoundaryPanelSearchProperty createPanelSearchProperty(JDialog dialog, Property property) {
		return new BoundaryPanelSearchPropertyEnglish(dialog, property);
	}

	@Override
	public BoundaryPanelProfileTenant createPanelProfileTenant(JDialog dialog) {
		return new BoundaryPanelProfileTenantEnglish(dialog);
	}

	@Override
	public BoundaryPanelChangeProfileTenant createPanelChangeProfileTenant(JDialog dialog) {
		return new BoundaryPanelChangeProfileTenantEnglish(dialog);
	}

	@Override
	public BoundaryPanelChangePasswordTenant createPanelChangePasswordTenant(JDialog dialog) {
		return new BoundaryPanelChangePasswordTenantEnglish(dialog);
	}

	@Override
	public BoundaryPanelAuthentication createPanelAuthentication(JDialog dialog) {
		return new BoundaryPanelAuthenticationEnglish(dialog);
	}

	@Override
	public BoundaryPanelIban createPanelIban(JDialog dialog) {
		return new BoundaryPanelIbanEnglish(dialog);
	}
	
	@Override
	public BoundaryPanelRent createPanelRent(JDialog dialog, Property property) {
		return new BoundaryPanelRentEnglish(dialog, property);
	}

}
