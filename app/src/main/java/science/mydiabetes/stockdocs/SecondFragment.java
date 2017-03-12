package science.mydiabetes.stockdocs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import science.mydiabetes.stockdocs.adapter.StudentAdapter;
import science.mydiabetes.stockdocs.controller.StudentController;

/**
 * Created by sky on 21.02.2017.
 */

public class SecondFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    private ListView listView;
    private View view;


    // newInstance constructor for creating fragment with arguments
    public static SecondFragment newInstance(int page, String title) {
        SecondFragment fragmentSecond = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentSecond.setArguments(args);
        return fragmentSecond;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("MyFragment", "Show");
        view = inflater.inflate(R.layout.fragment_second, container, false);

        init();
        return view;
    }

    private void init() {
        listView = (ListView) view.findViewById(R.id.listView);
        StudentAdapter studentAdapter = new StudentAdapter(getContext(), StudentController.generateStudentsList());
        listView.setAdapter(studentAdapter);
    }
}