package com.example.testbook.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.testbook.Model.Classes;
import com.example.testbook.Model.CourseCards;
import com.example.testbook.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPAgerAdapter extends PagerAdapter {

    private final CourseCards mCards;
    private final Context mActivity;
    @BindView(R.id.selectLogo_IV)
    ImageView selectLogoIV;
    @BindView(R.id.facultyImage_IV)
    ImageView facultyImageIV;
    @BindView(R.id.courseTitle_TV)
    TextView courseTitleTV;
    private LayoutInflater layoutInflater;
    private Context context;


    public ViewPAgerAdapter(CourseCards courseCards, Context context) {
        this.mCards = courseCards;
        this.mActivity = context;
    }

    @Override
    public int getCount() {
        return mCards.getCourses().getClasses().size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(mActivity);
        View view = layoutInflater.inflate(R.layout.banner_design, container, false);
        ButterKnife.bind(this, view);
        container.addView(view, 0);
        bind(mCards.getCourses().getClasses().get(position));
        return view;
    }

    private void bind(Classes classes) {
        if (!classes.getCourseTitles().equals("") || classes.getCourseTitles() != null) {
            courseTitleTV.setText(classes.getCourseTitles());
        }
        if (classes.getClassInfo().getFacultyImageUrl() != null || !classes.getClassInfo().getFacultyImageUrl().equals("")) {
//                GlideToVectorYou.justLoadImage(mActivity,
//                        Uri.parse( classes.getClassInfo().getFacultyImageUrl()),facultyImageIV)
//            Picasso.get().load(classes.getClassInfo().getFacultyImageUrl()).into(facultyImageIV);


            // the imageurl data is being fetched from the api but its not loading with glide
            // or piccaso
            //todo maybe net issue or something very uncommon will see at end

            //for test loding direct image from api still not wrking
            Picasso.get().load("http://cdn.testbook.com/images/production/472-X-200-faculty-final" +
                    "%20%282%29_product_facultiesImage_all_1599122759.png").into(facultyImageIV);

        }
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

