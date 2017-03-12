package science.mydiabetes.stockdocs;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import science.mydiabetes.stockdocs.model.Echanges;

/**
 * Created by sky on 21.02.2017.
 */

public class FirstFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    private TextView textJson;
    List<Echanges> echanges = new ArrayList<>();

    private List<Echanges> parseJson(String s) {
        if (s != null && s.length() > 0) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = null;
            try {
                jsonNode = mapper.readTree(s);
            } catch (IOException e) {
                e.printStackTrace();
            }

//                JSONArray jsonArrayItem = new JSONArray(new ObjectMapper().convertValue(jsonNode.get("EXCHANGES"), List.class));
//                Log.d("Json", "Node" + jsonArrayItem);

//            for (int i = 0; i < jsonArrayItem.length(); i++) {
//                try {
//                    echanges.add(new Echanges(jsonArrayItem.get(i).toString()));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
        }
        return echanges;
    }

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

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        textJson = (TextView) view.findViewById(R.id.text_json);
        Log.d("MyClass", " class " + MainActivity.class);

        new GetAsyncTask().execute("http://dev.markitondemand.com/MODApis/Api/v2/quote?symbol=aapl");
//        String url = "http://nimblerest.lisuns.com:4531/GetHistory/?accessKey=d6deed12-2f9f-4366-917a-87a284ee4503&exchange=NSE&instrumentIdentifier=ADANIPORTS&periodicity=DAY&from=1483228800&to=1487635200&max=0&xml=false";
//        new GetAsyncTask().execute(url);

        return view;
    }

    private class GetAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String[] params) {
            if (params != null && params.length > 0) {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet(params[0]);
                HttpResponse response;
                String result = null;
                try {
                    response = client.execute(request);
                    HttpEntity entity = response.getEntity();

                    if (entity != null) {

                        // A Simple JSON Response Read
                        InputStream instream = entity.getContent();
                        result = convertStreamToString(instream);
                        // now you have the string representation of the HTML request
                        System.out.println("RESPONSE: " + result);
                        instream.close();
                        if (response.getStatusLine().getStatusCode() == 200) {
//                    netState.setLogginDone(true);
                        }

                    }
                    // Headers
                    org.apache.http.Header[] headers = response.getAllHeaders();
                    for (int i = 0; i < headers.length; i++) {
                        System.out.println(headers[i]);
                    }
                } catch (ClientProtocolException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                return result;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result != null) {
                parseJson(result);
                textJson.setText(result);
            }

        }
    }

    private static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}