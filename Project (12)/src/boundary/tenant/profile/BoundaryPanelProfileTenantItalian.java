package boundary.tenant.profile;

import javax.swing.JDialog;

import entity.Session;
import entity.Tenant;
import entity.strings.StringsItalian;

public class BoundaryPanelProfileTenantItalian extends BoundaryPanelProfileTenant {
	private static final long serialVersionUID = 1L;

	public BoundaryPanelProfileTenantItalian(JDialog dialog) {
		super(dialog);
		
		Tenant tenant = (Tenant) Session.getSessionInstance().getCustomer();

		dialog.setTitle(StringsItalian.STR_MY_PROFILE);
		this.lblTitle.setText(StringsItalian.STR_MY_PROFILE);
		
		this.lblFirstName.setText(StringsItalian.STR_NAME);
		this.lblFirstNameValue.setText(tenant.getFirstName());
		
		this.lblLastName.setText(StringsItalian.STR_SURNAME);
		this.lblLastNameValue.setText(tenant.getLastName());
		
		this.lblEmail.setText(StringsItalian.STR_EMAIL);
		this.lblEmailValue.setText(tenant.getEmail());
		
		this.lblBirthDate.setText(StringsItalian.STR_DATE);
		this.lblBirthDateValue.setText(tenant.getBirthDate());
		
		this.lblBirthPlace.setText(StringsItalian.STR_PLACE);
		this.lblBirthPlaceValue.setText(tenant.getBirthPlace());
		
		this.lblFax.setText(StringsItalian.STR_FAX);
		this.lblFaxValue.setText(tenant.getFax());
		
		this.lblAddress.setText(StringsItalian.STR_ADDR);
		this.lblAddressValue.setText(tenant.getAddress());
		
		this.lblWebSite.setText(StringsItalian.STR_WEBSITE);
		this.lblWebSiteValue.setText(tenant.getWebsite());
		
		this.lblTaxCode.setText(StringsItalian.STR_TAX_CODE);
		this.lblTaxCodeValue.setText(tenant.getTaxCode());
		
		this.lblPhone.setText(StringsItalian.STR_PHONE);
		this.lblPhoneValue.setText(tenant.getPhone());
		

		this.btnModifyProfile.setText(StringsItalian.STR_CHANGE_PROFILE);
		this.btnModifyPassword.setText(StringsItalian.STR_CHANGE_PASSWORD);
	}
}
