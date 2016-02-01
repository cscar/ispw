package boundary.landlord.profile;

import javax.swing.JDialog;

import entity.LandLord;
import entity.Session;
import entity.strings.StringsEnglish;

public class BoundaryPanelProfileLandLordEnglish extends BoundaryPanelProfileLandLord {
	private static final long serialVersionUID = 1L;

	public BoundaryPanelProfileLandLordEnglish(JDialog dialog) {
		super(dialog);
		
		LandLord landlord = (LandLord) Session.getSessionInstance().getCustomer();

		dialog.setTitle(StringsEnglish.STR_MY_PROFILE);
		this.lblTitle.setText(StringsEnglish.STR_MY_PROFILE);
		
		this.lblFirstName.setText(StringsEnglish.STR_NAME);
		this.lblFirstNameValue.setText(landlord.getFirstName());
		
		this.lblLastName.setText(StringsEnglish.STR_SURNAME);
		this.lblLastNameValue.setText(landlord.getLastName());
		
		this.lblEmail.setText(StringsEnglish.STR_EMAIL);
		this.lblEmailValue.setText(landlord.getEmail());
		
		this.lblBirthDate.setText(StringsEnglish.STR_DATE);
		this.lblBirthDateValue.setText(landlord.getBirthDate());
		
		this.lblBirthPlace.setText(StringsEnglish.STR_PLACE);
		this.lblBirthPlaceValue.setText(landlord.getBirthPlace());
		
		this.lblFax.setText(StringsEnglish.STR_FAX);
		this.lblFaxValue.setText(landlord.getFax());
		
		this.lblAddress.setText(StringsEnglish.STR_ADDR);
		this.lblAddressValue.setText(landlord.getAddress());
		
		this.lblWebSite.setText(StringsEnglish.STR_WEBSITE);
		this.lblWebSiteValue.setText(landlord.getWebsite());
		
		this.lblIban.setText(StringsEnglish.STR_IBAN);
		this.lblIbanValue.setText(landlord.getIban());
		
		this.lblTaxCode.setText(StringsEnglish.STR_TAX_CODE);
		this.lblTaxCodeValue.setText(landlord.getTaxCode());
		
		this.lblPhone.setText(StringsEnglish.STR_PHONE);
		this.lblPhoneValue.setText(landlord.getPhone());
		
		this.btnModifyProfile.setText(StringsEnglish.STR_CHANGE_PROFILE);
		this.btnModifyPassword.setText(StringsEnglish.STR_CHANGE_PASSWORD);
	}
}
