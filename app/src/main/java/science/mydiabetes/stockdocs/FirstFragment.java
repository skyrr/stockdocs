package science.mydiabetes.stockdocs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sky on 21.02.2017.
 */

public class FirstFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;


    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");


    }

    @Override
    public void onStop() {
        super.onStop();
    }
    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
//        String url = "http://nimblerest.lisuns.com:4531/GetHistory/?accessKey=d6deed12-2f9f-4366-917a-87a284ee4503&exchange=NSE&instrumentIdentifier=ADANIPORTS&periodicity=DAY&from=1483228800&to=1487635200&max=0&xml=false";
//        new GetAsyncTask().execute(url);

        return view;
    }




}