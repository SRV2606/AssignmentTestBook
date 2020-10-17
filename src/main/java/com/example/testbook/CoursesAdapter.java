package com.example.testbook;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testbook.Model.Classes;
import com.example.testbook.Model.CourseCards;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.MyViewHolder> {
    private final Context context;
    private final CourseCards mCourseCards;
    private final Activity mActivity;

    public CoursesAdapter(Context applicationContext, CourseCards courseCards, Activity activity) {
        this.context = applicationContext;
        this.mCourseCards = courseCards;
        this.mActivity = activity;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.banner_design, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bind(mCourseCards.getCourses().getClasses().get(position), position);
    }

    @Override
    public int getItemCount() {
        return mCourseCards.getCourses().getClasses().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.selectLogo_IV)
        ImageView selectLogoIV;
        @BindView(R.id.facultyImage_IV)
        ImageView facultyImageIV;
        @BindView(R.id.courseTitle_TV)
        TextView courseTitleTV;
        @BindView(R.id.constraintLayout)
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Classes classes, int position) {

            if (position % 2 == 0) {
                constraintLayout.setBackground(context.getResources().getDrawable(R.color.color2));
            } else {
                constraintLayout.setBackground(context.getResources().getDrawable(R.color.color3));

            }


            if (!classes.getCourseTitles().equals("") || classes.getCourseTitles() != null) {
                courseTitleTV.setText(classes.getCourseTitles());
            }
            if (classes.getClassInfo().getFacultyImageUrl() != null || !classes.getClassInfo().getFacultyImageUrl().equals("")) {
//                GlideToVectorYou.justLoadImage(mActivity,
//                        Uri.parse( classes.getClassInfo().getFacultyImageUrl()),facultyImageIV)

                // the imageurl data is being fetched from the api but its not loading with glide
                // or piccaso

                //todo maybe net issue or something very uncomming will see at end
                Picasso.get().load(classes.getClassInfo().getFacultyImageUrl()).into(facultyImageIV);
            }
        }
    }
}
