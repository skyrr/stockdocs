package science.mydiabetes.stockdocs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import science.mydiabetes.stockdocs.R;
import science.mydiabetes.stockdocs.model.Student;

/**
 * Created by sky on 10.02.2017.
 */

public class StudentAdapter extends BaseAdapter{

    private class ViewHolder {
        TextView firstName;
        TextView lastName;
        TextView age;
        ViewHolder(View view) {
            firstName = (TextView) view.findViewById(R.id.firstNameAdapter);
            lastName = (TextView) view.findViewById(R.id.lastNameAdapter);
            age = (TextView) view.findViewById(R.id.ageStudentAdapter);
        }
    }

    private LayoutInflater layoutInflater;

    public StudentAdapter(Context context, List<Student> students) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.students = students;
    }

    private List<Student> students;

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int i) {
        return students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.student_adapter, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Student student = getItem(i);
        if (student != null) {
            holder.firstName.setText(student.getFirstName());
            holder.lastName.setText(student.getLastName());
            holder.age.setText(String.valueOf(student.getAge()));
        }
        return view;
    }
}
