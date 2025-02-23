package cris.org.in.ima.adaptors;

import android.view.View;
import android.widget.TextView;
import cris.prs.webservices.dto.CountryDTO;
import uk.co.ribot.easyadapter.PositionInfo;

@C0708Uh(2131558727)
public class CountryListViewHolder extends C1424ug<CountryDTO> {
    @C1456wC(2131364086)
    TextView country;
    private String countryCode;
    private String countryName;

    public CountryListViewHolder(View view) {
        super(view);
    }

    public void onSetValues(CountryDTO countryDTO, PositionInfo positionInfo) {
        this.countryName = countryDTO.getCountry();
        this.countryCode = countryDTO.getCountryCode();
        this.country.setText(countryDTO.getCountry());
    }
}
