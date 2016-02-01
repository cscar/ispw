package entity.language;

import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import boundary.administrator.BoundaryPanelAdministrator;
import boundary.administrator.BoundaryPanelAdministratorItalian;
import boundary.authentication.BoundaryPanelAuthentication;
import boundary.authentication.BoundaryPanelAuthenticationItalian;
import boundary.frame.BoundaryPanelFrame;
import boundary.frame.BoundaryPanelFrameItalian;
import boundary.iban.BoundaryPanelIban;
import boundary.iban.BoundaryPanelIbanItalian;
import boundary.landlord.BoundaryPanelLandLord;
import boundary.landlord.BoundaryPanelLandLordItalian;
import boundary.landlord.changepassword.BoundaryPanelChangePasswordItalianLandLord;
import boundary.landlord.changepassword.BoundaryPanelChangePasswordLandLord;
import boundary.landlord.changeprofile.BoundaryPanelChangeProfileLandLord;
import boundary.landlord.changeprofile.BoundaryPanelChangeProfileLandLordItalian;
import boundary.landlord.profile.BoundaryPanelProfileLandLord;
import boundary.landlord.profile.BoundaryPanelProfileLandLordItalian;
import boundary.login.BoundaryPanelLogin;
import boundary.login.BoundaryPanelLoginItalian;
import boundary.registration.BoundaryPanelRegistration;
import boundary.registration.BoundaryPanelRegistrationItalian;
import boundary.registration.properties.BoundaryPanelRegistrationProperties;
import boundary.registration.properties.BoundaryPanelRegistrationPropertiesItalian;
import boundary.rent.BoundaryPanelRent;
import boundary.rent.BoundaryPanelRentItalian;
import boundary.scout.BoundaryPanelScout;
import boundary.scout.BoundaryPanelScoutItalian;
import boundary.scout.properties.BoundaryPanelProperty;
import boundary.scout.properties.BoundaryPanelPropertyItalian;
import boundary.search.BoundaryPanelSearch;
import boundary.search.BoundaryPanelSearchItalian;
import boundary.search.properties.BoundaryPanelSearchProperty;
import boundary.search.properties.BoundaryPanelSearchPropertyItalian;
import boundary.tenant.BoundaryPanelTenant;
import boundary.tenant.BoundaryPanelTenantItalian;
import boundary.tenant.changepassword.BoundaryPanelChangePasswordTenant;
import boundary.tenant.changepassword.BoundaryPanelChangePasswordTenantItalian;
import boundary.tenant.changeprofile.BoundaryPanelChangeProfileTenant;
import boundary.tenant.changeprofile.BoundaryPanelChangeProfileTenantItalian;
import boundary.tenant.profile.BoundaryPanelProfileTenant;
import boundary.tenant.profile.BoundaryPanelProfileTenantItalian;
import entity.properties.Property;

public class LanguageItalian implements Language {

	@Override
	public BoundaryPanelFrame createMainPanel(JFrame frame) {
		return new BoundaryPanelFrameItalian(frame);
	}

	@Override
	public BoundaryPanelRegistration createPanelRegistration(JDialog dialog) {
		return new BoundaryPanelRegistrationItalian(dialog);
	}

	@Override
	public BoundaryPanelLogin createPanelLogin(JDialog dialog) {
		return new BoundaryPanelLoginItalian(dialog);
	}

	@Override
	public BoundaryPanelLandLord createPanelLandLord(JDialog dialog) {

		return new BoundaryPanelLandLordItalian(dialog);
	}

	@Override
	public BoundaryPanelTenant createPanelTenant(JDialog dialog) {

		return new BoundaryPanelTenantItalian(dialog);
	}

	@Override
	public BoundaryPanelRegistrationProperties createPanelRegistrationProperties(JDialog dialog) {

		return new BoundaryPanelRegistrationPropertiesItalian(dialog);
	}

	@Override
	public BoundaryPanelAdministrator createPanelAdministrator(JDialog dialog) {

		return new BoundaryPanelAdministratorItalian(dialog);
	}

	@Override
	public BoundaryPanelProfileLandLord createPanelProfileLandLord(JDialog dialog) {

		return new BoundaryPanelProfileLandLordItalian(dialog);
	}

	@Override
	public BoundaryPanelChangeProfileLandLord createPanelChangeProfileLandLord(JDialog dialog) {

		return new BoundaryPanelChangeProfileLandLordItalian(dialog);
	}

	@Override
	public BoundaryPanelChangePasswordLandLord createPanelChangePasswordLandLord(JDialog dialog) {

		return new BoundaryPanelChangePasswordItalianLandLord(dialog);
	}

	@Override
	public BoundaryPanelScout createPanelScout(JDialog dialog) {
		return new BoundaryPanelScoutItalian(dialog);
	}

	@Override
	public BoundaryPanelProperty createPanelProperty(JDialog dialog, Property property) {
		return new BoundaryPanelPropertyItalian(dialog, property);
	}

	@Override
	public BoundaryPanelSearch createPanelSearch(Window window, ArrayList<Property> properties) {
		return new BoundaryPanelSearchItalian(window, properties);
	}

	@Override
	public BoundaryPanelSearchProperty createPanelSearchProperty(JDialog dialog, Property property) {
		return new BoundaryPanelSearchPropertyItalian(dialog, property);
	}

	@Override
	public BoundaryPanelProfileTenant createPanelProfileTenant(JDialog dialog) {
		return new BoundaryPanelProfileTenantItalian(dialog);
	}

	@Override
	public BoundaryPanelChangeProfileTenant createPanelChangeProfileTenant(JDialog dialog) {
		return new BoundaryPanelChangeProfileTenantItalian(dialog);
	}

	@Override
	public BoundaryPanelChangePasswordTenant createPanelChangePasswordTenant(JDialog dialog) {
		return new BoundaryPanelChangePasswordTenantItalian(dialog);
	}

	@Override
	public BoundaryPanelAuthentication createPanelAuthentication(JDialog dialog) {
		return new BoundaryPanelAuthenticationItalian(dialog);
	}

	@Override
	public BoundaryPanelIban createPanelIban(JDialog dialog) {
		return new BoundaryPanelIbanItalian(dialog);
	}
	
	@Override
	public BoundaryPanelRent createPanelRent(JDialog dialog, Property property) {
		return new BoundaryPanelRentItalian(dialog, property);
	}

}
