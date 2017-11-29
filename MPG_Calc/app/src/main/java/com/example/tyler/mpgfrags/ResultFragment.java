package com.example.tyler.mpgfrags;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.text.DecimalFormat;

import javax.xml.transform.Result;

/**
 * Created by tyler on 10/31/17.
 */

public class ResultFragment extends android.support.v4.app.Fragment {

    private TextView totalCostTextView;
    private TextView perMileCostTextView;
    private CheckBox ecoCheckBox;

    private Trip theTrip;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theTrip = Trip.getInstance();

        //couldn't get bundles to work properly - replaced them with the singleton logic we used in class
//        Bundle tripBundle = getArguments();
//        tripBundle.getDouble("mileage", dMileage);
//        tripBundle.getDouble("gasprice", dGasPrice);
//        tripBundle.getDouble("distance", dDistance);
//
//        totalCostTextView.setText(dMileage.toString());
//        perMileCostTextView.setText(dGasPrice.toString());

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.result_fragment, container, false);

        this.totalCostTextView = v.findViewById(R.id.tv_total_cost);
        this.perMileCostTextView = v.findViewById(R.id.tv_per_mile_cost);
        this.ecoCheckBox = v.findViewById(R.id.cb_eco);

        ecoCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

           @Override
           public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
               if(isChecked)
               {
                   //Add five to the mileage to calculate the cost, set the views, then revert the mileage
                   //this way if you switch to the trip fragment when the checkbox is checked
                   //it will not fill in the edittext with a value 5 higher than the user entered
                   theTrip.setGasMileage(theTrip.getGasMileage()+5);
                   Double tc = theTrip.getTotalTripCost();
                   Double pmc = theTrip.getPerMileTripCost();

                   //Trim the decimal to 2 places for monetary notation
                   DecimalFormat df = new DecimalFormat("#.##");
                   totalCostTextView.setText("Total trip cost: $" + df.format(tc));
                   perMileCostTextView.setText("Trip cost per mile: $" + df.format(pmc));

                   theTrip.setGasMileage(theTrip.getGasMileage()-5);
               }
               else
               {
                   //revert the textviews to non-eco values
                   updateTextViews();
               }
           }
       }
        );

        updateTextViews();

        return v;
    }

    private void updateTextViews()
    {
        try{
            Double tc = theTrip.getTotalTripCost();
            DecimalFormat df = new DecimalFormat("#.##");
            totalCostTextView.setText("Total trip cost: $" + df.format(tc));
            Double pmc = theTrip.getPerMileTripCost();
            perMileCostTextView.setText("Trip cost per mile: $" + df.format(pmc));

            //If you go right to the result fragment, let the user know they need to enter
            //values rather than showing NaN
            if(Double.isNaN(tc)) {
                totalCostTextView.setText("Total trip cost: Not enough information");
                perMileCostTextView.setText("Total trip cost: Not enough information");
            }
            if(Double.isNaN(pmc))
            {
                totalCostTextView.setText("Total trip cost: Not enough information");
                perMileCostTextView.setText("Trip cost per mile: Not enough information");
            }

        }
        catch(Exception e)
        {
            totalCostTextView.setText("Total trip cost: Not enough information");
            perMileCostTextView.setText("Trip cost per mile: Not enough information");
        }
    }
}
