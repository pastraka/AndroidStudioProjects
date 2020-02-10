package hfad.com.beeradviser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    //Called when the button gets clicked
    public void onClickFindBeer(View view) {
        //Get reference to the TextView
        TextView brands = findViewById(R.id.brands);

        //Get a reference to the Spinner
        Spinner color = findViewById(R.id.color);

        //Get the selected item in the Spinner
        String beerType = String.valueOf(color.getSelectedItem());

        //Get List of brands
        List<String> brandList = expert.getBrands(beerType);

        //Build string using the values in the list
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandList) {
            //display each brand on a new line
            brandsFormatted.append(brand).append('\n');
        }

        //Display the results in the text view
        brands.setText(brandsFormatted);
    }
}
