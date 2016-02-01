package boundary.landlord.profile;

import javax.swing.JDialog;

import entity.LandLord;
import entity.Session;
import entity.strings.StringsItalian;

public class BoundaryPanelProfileLandLordItalian extends BoundaryPanelProfileLandLord {
	private static final long serialVersionUID = 1L;

	public BoundaryPanelProfileLandLordItalian(JDialog dialog) {
		super(dialog);
		
		LandLord landlord= (LandLord) Session.getSessionInstance().getCustomer();

		dialog.setTitle(StringsItalian.STR_MY_PROFILE);
		this.lblTitle.setText(StringsItalian.STR_MY_PROFILE);
		
		this.lblFirstName.setText(StringsItalian.STR_NAME);
		this.lblFirstNameValue.setText(landlord.getFirstName());
		
		this.lblLastName.setText(StringsItalian.STR_SURNAME);
		this.lblLastNameValue.setText(landlord.getLastName());
		
		this.lblEmail.setText(StringsItalian.STR_EMAIL);
		this.lblEmailValue.setText(landlord.getEmail());
		
		this.lblBirthDate.setText(StringsItalian.STR_DATE);
		this.lblBirthDateValue.setText(landlord.getBirthDate());
		
		this.lblBirthPlace.setText(StringsItalian.STR_PLACE);
		this.lblBirthPlaceValue.setText(landlord.getBirthPlace());
		
		this.lblFax.setText(StringsItalian.STR_FAX);
		this.lblFaxValue.setText(landlord.getFax());
		
		this.lblAddress.setText(StringsItalian.STR_ADDR);
		this.lblAddressValue.setText(landlord.getAddress());
		
		this.lblWebSite.setText(StringsItalian.STR_WEBSITE);
		this.lblWebSiteValue.setText(landlord.getWebsite());
		
		this.lblIban.setText(StringsItalian.STR_IBAN);
		this.lblIbanValue.setText(landlord.getIban());
		
		this.lblTaxCode.setText(StringsItalian.STR_TAX_CODE);
		this.lblTaxCodeValue.setText(landlord.getTaxCode());
		
		this.lblPhone.setText(StringsItalian.STR_PHONE);
		this.lblPhoneValue.setText(landlord.getPhone());
		

		this.btnModifyProfile.setText(StringsItalian.STR_CHANGE_PROFILE);
		this.btnModifyPassword.setText(StringsItalian.STR_CHANGE_PASSWORD);
	}
}
