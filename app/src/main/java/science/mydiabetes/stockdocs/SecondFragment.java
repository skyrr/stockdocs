package science.mydiabetes.stockdocs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import science.mydiabetes.stockdocs.model.CurrencyModel;

/**
 * Created by sky on 21.02.2017.
 */

public class SecondFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    private ListView listView;
    private View view;
    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;

    ArrayList<HashMap<String, String>> contactList;

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
        contactList = new ArrayList<>();
        lv = (ListView) view.findViewById(R.id.list);
        Log.d("MyClass", " class " + MainActivity.class);

        new SecondFragment.GetAsyncTask().execute("https://openexchangerates.org/api/latest.json?app_id=79b7318e95df47afa730b9dc6d6899d0");

//        init();
        return view;
    }
    private class GetAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String[] params) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
//            String url = "http://api.androidhive.info/contacts/";
            String url = "https://openexchangerates.org/api/latest.json?app_id=79b7318e95df47afa730b9dc6d6899d0";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    // Getting JSON Array node
                    JSONObject rates = jsonObj.getJSONObject("rates");

                    CurrencyModel currencyModel = createModel();
                    for (int i = 0; i < currencyModel.getCount(); i++) {
                        String curEl = currencyModel.getArrayElement(i);
                        System.out.println(curEl);
                        String currencyName = curEl;
                        String currencyValue = rates.getString(currencyName);
                        // looping through All Contacts

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        currencyName = "USD" + currencyName;
                        // adding each child node to HashMap key => value
                        contact.put("currencyName", currencyName);
                        contact.put("currencyValue", currencyValue);

                        // adding contact to contact list
                        contactList.add(contact);

                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(getActivity(), contactList,
                    R.layout.list_item, new String[]{ "currencyName","currencyName","currencyValue","currencyValue"},
                    new int[]{R.id.currencyName,R.id.currencyDescr, R.id.currencyValue, R.id.currencyValueChange});
            lv.setAdapter(adapter);
        }
    }
    private static CurrencyModel createModel() {
        String[] x = {"AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTC", "BTN", "BWP", "BYN", "BYR", "BZD", "CAD", "CDF", "CHF", "CLF", "CLP", "CNY", "COP", "CRC", "CUC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EEK", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRO", "MTL", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLL", "SOS", "SRD", "STD", "SVC", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VEF", "VND", "VUV", "WST", "XAF", "XAG", "XAU", "XCD", "XDR", "XOF", "XPD", "XPF", "XPT", "YER", "ZAR", "ZMK", "ZMW", "ZWL"};
        return new CurrencyModel(x);
    }
}
