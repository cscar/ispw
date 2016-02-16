package entity.language;

import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import boundary.administrator.BoundaryPanelAdministrator;
import boundary.authentication.BoundaryPanelAuthentication;
import boundary.frame.BoundaryPanelFrame;
import boundary.iban.BoundaryPanelIban;
import boundary.landlord.BoundaryPanelLandLord;
import boundary.landlord.changepassword.BoundaryPanelChangePasswordLandLord;
import boundary.landlord.changeprofile.BoundaryPanelChangeProfileLandLord;
import boundary.landlord.profile.BoundaryPanelProfileLandLord;
import boundary.login.BoundaryPanelLogin;
import boundary.registration.BoundaryPanelRegistration;
import boundary.registration.properties.BoundaryPanelRegistrationProperties;
import boundary.rent.BoundaryPanelRent;
import boundary.scout.BoundaryPanelScout;
import boundary.scout.properties.BoundaryPanelProperty;
import boundary.search.BoundaryPanelSearch;
import boundary.search.properties.BoundaryPanelSearchProperty;
import boundary.tenant.BoundaryPanelTenant;
import boundary.tenant.changepassword.BoundaryPanelChangePasswordTenant;
import boundary.tenant.changeprofile.BoundaryPanelChangeProfileTenant;
import boundary.tenant.profile.BoundaryPanelProfileTenant;
import entity.properties.Property;

public interface Language {

	public BoundaryPanelFrame createMainPanel(JFrame frame);

	public BoundaryPanelRegistration createPanelRegistration(JDialog dialog);

	public BoundaryPanelLogin createPanelLogin(JDialog dialog);

	public BoundaryPanelLandLord createPanelLandLord(JDialog dialog);

	public BoundaryPanelTenant createPanelTenant(JDialog dialog);

	public BoundaryPanelRegistrationProperties createPanelRegistrationProperties(JDialog dialog);

	public BoundaryPanelAdministrator createPanelAdministrator(JDialog dialog);

	public BoundaryPanelProfileLandLord createPanelProfileLandLord(JDialog dialog);

	public BoundaryPanelChangeProfileLandLord createPanelChangeProfileLandLord(JDialog dialog);

	public BoundaryPanelChangePasswordLandLord createPanelChangePasswordLandLord(JDialog dialog);

	public BoundaryPanelProfileTenant createPanelProfileTenant(JDialog dialog);

	public BoundaryPanelChangeProfileTenant createPanelChangeProfileTenant(JDialog dialog);

	public BoundaryPanelChangePasswordTenant createPanelChangePasswordTenant(JDialog dialog);

	public BoundaryPanelScout createPanelScout(JDialog dialog);

	public BoundaryPanelProperty createPanelProperty(JDialog dialog, Property property);

	public BoundaryPanelSearchProperty createPanelSearchProperty(JDialog dialog, Property property);

	public BoundaryPanelSearch createPanelSearch(Window window, ArrayList<Property> properties);

	public BoundaryPanelAuthentication createPanelAuthentication(JDialog dialog);

	public BoundaryPanelIban createPanelIban(JDialog dialog);
	
	public BoundaryPanelRent createPanelRent(JDialog dialog, Property property);
}
