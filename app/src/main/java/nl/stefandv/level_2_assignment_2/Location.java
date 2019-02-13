package nl.stefandv.level_2_assignment_2;

public class Location {

    private String country;
    private boolean europe;
    private int mPlaceImage;

    public Location(String country, boolean europe, int mPlaceImage) {
        this.country = country;
        this.europe = europe;
        this.mPlaceImage = mPlaceImage;
    }

    public String getCountry() {
        return country;
    }

    public boolean isEurope() {
        return europe;
    }

    public int getmPlaceImage() {
        return mPlaceImage;
    }


    public static final String[] LOCATION_NAMES = {
            "Denmark",
            "Canada",
            "Bangladesh",
            "Kazachstan",
            "Colombia",
            "Poland",
            "Malta",
            "Thailand",
    };

    public static final int[] LOCATION_IMAGES = {


            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand,
    };

    public static final boolean[] LOCATION_ANSWERS = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false,
    };

}

