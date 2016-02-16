package boundary.tenant.profile;

import javax.swing.JDialog;

import entity.Session;
import entity.Tenant;
import entity.strings.StringsEnglish;

public class BoundaryPanelProfileTenantEnglish extends BoundaryPanelProfileTenant {
	private static final long serialVersionUID = 1L;

	public BoundaryPanelProfileTenantEnglish(JDialog dialog) {
		super(dialog);

		Tenant tenant = (Tenant) Session.getSessionInstance().getCustomer();

		dialog.setTitle(StringsEnglish.STR_MY_PROFILE);
		this.lblTitle.setText(StringsEnglish.STR_MY_PROFILE);

		this.lblFirstName.setText(StringsEnglish.STR_NAME);
		this.lblFirstNameValue.setText(tenant.getFirstName());

		this.lblLastName.setText(StringsEnglish.STR_SURNAME);
		this.lblLastNameValue.setText(tenant.getLastName());

		this.lblEmail.setText(StringsEnglish.STR_EMAIL);
		this.lblEmailValue.setText(tenant.getEmail());

		this.lblBirthDate.setText(StringsEnglish.STR_DATE);
		this.lblBirthDateValue.setText(tenant.getBirthDate());

		this.lblBirthPlace.setText(StringsEnglish.STR_PLACE);
		this.lblBirthPlaceValue.setText(tenant.getBirthPlace());

		this.lblFax.setText(StringsEnglish.STR_FAX);
		this.lblFaxValue.setText(tenant.getFax());

		this.lblAddress.setText(StringsEnglish.STR_ADDR);
		this.lblAddressValue.setText(tenant.getAddress());

		this.lblWebSite.setText(StringsEnglish.STR_WEBSITE);
		this.lblWebSiteValue.setText(tenant.getWebsite());

		this.lblTaxCode.setText(StringsEnglish.STR_TAX_CODE);
		this.lblTaxCodeValue.setText(tenant.getTaxCode());

		this.lblPhone.setText(StringsEnglish.STR_PHONE);
		this.lblPhoneValue.setText(tenant.getPhone());

		this.btnModifyProfile.setText(StringsEnglish.STR_CHANGE_PROFILE);
		this.btnModifyPassword.setText(StringsEnglish.STR_CHANGE_PASSWORD);
	}
}
