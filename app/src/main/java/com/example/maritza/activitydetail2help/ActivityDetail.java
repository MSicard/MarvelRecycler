package com.example.maritza.activitydetail2help;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemSimpleImage;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemSimpleText;

import java.util.ArrayList;
import java.util.List;

public class ActivityDetail extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    private Button button;
    private Toolbar toolbar;
    ImageView imageToolbar;
    private TextView title;
    private TextView subTitle;
    private TextView column_right;
    private TextView column_center;
    private TextView column_left;
    private TextView value_right;
    private TextView value_center;
    private TextView value_left;
    private String external_url;
    private String background;
    private String document;



    // Inicializar
    List items = new ArrayList();

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        document = getIntent().getStringExtra("Document");

        title = (TextView) findViewById(R.id.detail_title);
        subTitle = (TextView) findViewById(R.id.detail_subtitle);
        column_left = (TextView) findViewById(R.id.column_left);
        column_right = (TextView) findViewById(R.id.column_right);
        column_center = (TextView) findViewById(R.id.column_center);
        value_left = (TextView)findViewById(R.id.value_left);
        value_right = (TextView) findViewById(R.id.value_right);
        value_center = (TextView) findViewById(R.id.value_center);


        items.add(new ItemSimpleImage("1", "Thor", "Thor el dios del trueno", R.drawable.detail_thor));
        items.add(new ItemSimpleText("3", "Thor", "Soy un tipo guapo y rubio >.O"));
        items.add(new ItemSimpleImage("1", "Dead Pool","El inmortal DeadPool", R.drawable.detail_deapool));
        items.add(new ItemSimpleText("0", "DeadPool", "Me gustan las chimichangas :v"));
        items.add(new ItemSimpleImage("0", "Wolverine", "Garritas Wolverine", R.drawable.detail_wolverine));
        items.add(new ItemSimpleText("0", "Wolverine", "SPOILER ALERT: mi hija me vio morir :("));

        items.add(new ItemSimpleImage("0", "Dr Strange", "El drogadicto de Dr Strange", R.drawable.detail_strange));
        items.add(new ItemSimpleText("0", "DeadPool", "Kids...las drogas son malas"));

        items.add(new ItemSimpleImage("0", "Ant Man", "El pequeño Ant Man", R.drawable.detail_antman));
        items.add(new ItemSimpleText("0", "Ant Man", "No se que ponerle :v"));
        items.add(new ItemSimpleText("0", "Prueba de posición",  "No se que ponerle :v"));


        button = (Button) findViewById(R.id.button);
        toolbar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageToolbar = (ImageView) findViewById(R.id.img_header);
        //imageToolbar.setImageResource(R.drawable.detail_marvel);

        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.mCollapseToolbar);
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        collapsingToolbar.setTitle(" ");

        collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.colorPrimary));

        final AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.mAppbar);

        //getText();
        external_url = "";
        if(external_url == ""){
            button.setVisibility(View.INVISIBLE);
            mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                    if(verticalOffset <= -mAppBarLayout.getTotalScrollRange()){
                        collapsingToolbar.setTitle(title.getText());
                        title.setVisibility(View.INVISIBLE);
                        subTitle.setVisibility(View.INVISIBLE);

                    }else{
                        title.setVisibility(View.VISIBLE);
                        collapsingToolbar.setTitle(" ");
                        subTitle.setVisibility(View.VISIBLE);

                    }
                }
            });
        }
        else{
            mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                    if(verticalOffset <= -mAppBarLayout.getTotalScrollRange()){
                        button.setVisibility(View.INVISIBLE);
                        collapsingToolbar.setTitle(title.getText());
                        title.setVisibility(View.INVISIBLE);
                        subTitle.setVisibility(View.INVISIBLE);

                    }else{
                        button.setVisibility(View.VISIBLE);
                        title.setVisibility(View.VISIBLE);
                        collapsingToolbar.setTitle(" ");
                        subTitle.setVisibility(View.VISIBLE);

                    }

                }
            });
        }


// Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.activity_detail_recycler);
        recycler.setHasFixedSize(true);

// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(ActivityDetail.this);
        recycler.setLayoutManager(lManager);

// Crear un nuevo adaptador
        adapter = new AdapterDetail(items);
        recycler.setAdapter(adapter);
    }

   /* private void getText(){
        Document doc = getDocument(document);
        Map<String,Object> content = doc.getProperties();
        int i = 0;
        Log.v("Document", content.toString());

        external_url = (String) content.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_URL_TXT);

       Map<String, Object> header = (Map<String, Object>) content.get("header");
        ArrayList<Map<String, Object>> columns = (ArrayList<Map<String, Object>>) header.get("columns");

        title.setText((String)header.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_TITLE));

        subTitle.setText((String)header.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_SUB_TITLE));

        background = (String)header.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_BACKGROUND);

        for(final Map<String, Object> column:columns){
            switch (i){
                case(0):
                    if((String)column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_VALUE_TYPE) == "int"){
                        column_left.setText((String)column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_COLUMN_TITLE));
                        value_left.setText(String.valueOf((Integer) column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_COLUMN_VALUE)));
                    }
                    else{
                        column_left.setText((String) column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_COLUMN_TITLE));
                        value_left.setText(String.valueOf((String) column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_COLUMN_VALUE)));
                    }
                    i++;
                    break;
                case(1):
                    if((String)column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_VALUE_TYPE) == "int"){
                        column_center.setText((String)column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_COLUMN_TITLE));
                        value_center.setText(String.valueOf((Integer) column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_COLUMN_VALUE)));
                    }
                    else{
                        column_center.setText((String)  column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_COLUMN_TITLE));
                        value_center.setText((String)  column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_COLUMN_VALUE));
                    }
                    i++;
                    break;
                case(2):
                    if((String)column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_VALUE_TYPE) == "int"){
                        column_right.setText((String)column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_COLUMN_TITLE));
                        value_right.setText(String.valueOf((Integer) column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_COLUMN_VALUE)));
                    }
                    else{
                        column_right.setText((String)column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_COLUMN_TITLE));
                        value_right.setText((String) column.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_COLUMN_VALUE));
                        }
                    i++;
                    break;
                   }
        }


        external_url = (String) content.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_URL);
        button.setText((String)content.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_URL_TXT));


        ArrayList<Map<String, Object>> sections =  (ArrayList<Map<String, Object>>)content.get("cards");

        for (final Map<String, Object> section:sections) {
            switch ((String)section.get("card_item")){
                case("item_simple_text"):
                    items.add(new ItemSimpleText((String) section.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_CARD_ICON),
                            (String)section.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_CARD_TITLE),
                            (String)section.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_CARD_TXT)));
                    break;
                case("item_simple_image"):
                    items.add(new ItemSimpleImage((String) section.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_CARD_ICON),
                            (String)section.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_CARD_TITLE),
                            (String)section.get(com.alphawavesystems.android.beaconioapp.common.Constants.DETAIL_SECTION_CARD_TXT),
                            0));
                    break;

            }
        }

    }*/

    public void onClick(View view){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(external_url));
        startActivity(myIntent);
    }

  /*  public void toggleDetails(View view) {
        if(view.findViewById(R.id.item_simple_text)){

        }
        if (expandArea.getVisibility() == View.GONE) {
            ExpandAndCollapseViewUtil.expand(expandArea, DURATION);
            imageViewExpand.setImageResource(R.drawable.ico_grey_down);
            rotate(-180.0f);
        } else {
            ExpandAndCollapseViewUtil.collapse(expandArea, DURATION);
            imageViewExpand.setImageResource(R.drawable.ico_grey_up);
            rotate(180.0f);
        }
    }

    private void rotate(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }*/

}
