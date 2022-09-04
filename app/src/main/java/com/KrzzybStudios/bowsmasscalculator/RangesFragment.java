package com.KrzzybStudios.bowsmasscalculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import com.google.common.primitives.Doubles;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RangesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RangesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RangesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RangesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RangesFragment newInstance(String param1, String param2) {
        RangesFragment fragment = new RangesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ranges, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        TextView txtCalculated = view.findViewById(R.id.textView);
        TextView txtCalculatedResult = view.findViewById(R.id.textView2);
        TextView txtKG = view.findViewById(R.id.textView3);
        EditText alphaAngle = view.findViewById(R.id.editAlpha);
        EditText alphaAngle2 = view.findViewById(R.id.editAlpha2);
        EditText betaAngle = view.findViewById(R.id.editBeta);
        EditText betaAngle2 = view.findViewById(R.id.editBeta2);
        EditText drawWeight = view.findViewById(R.id.editDrawweight);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double alpha = Double.parseDouble(alphaAngle.getText().toString());
                double alpha2 = Double.parseDouble(alphaAngle2.getText().toString());
                double beta = Double.parseDouble(betaAngle.getText().toString());
                double beta2 = Double.parseDouble(betaAngle2.getText().toString());
                double draw = Double.parseDouble(drawWeight.getText().toString());
                double[] weights = {Bows_weight_formula_1.getWeight(alpha, beta, draw),
                                    Bows_weight_formula_1.getWeight(alpha2, beta, draw),
                                    Bows_weight_formula_1.getWeight(alpha, beta2, draw),
                                    Bows_weight_formula_1.getWeight(alpha2,beta2,draw)};
                txtCalculated.setText("Calculated weight: ");
                txtCalculatedResult.setText(Doubles.max(weights));
                txtKG.setText("kg");
            }
        });
        return view;
    }


}