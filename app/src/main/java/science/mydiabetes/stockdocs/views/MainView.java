package science.mydiabetes.stockdocs.views;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sky on 10.02.2017.
 */

public class MainView {
    /**
     * linear layout
     * @param context
     * @return
     */
    public static LinearLayout createLinearLayout(Context context) {
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.MATCH_PARENT));
        return ll;
    }

    public static TextView createTextView(String caption, int color, Context context) {
        TextView tv = new TextView(context);

        tv.setText(caption);
        tv.setTextColor(color);
        return tv;
    }

    public static Button createButton(String caption, Context context) {
        Button button = new Button(context);
        button.setText(caption);
        return button;
    }
}
