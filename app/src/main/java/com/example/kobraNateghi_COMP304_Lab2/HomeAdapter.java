package com.example.kobraNateghi_COMP304_Lab2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends ArrayAdapter <Home>{

    private Context h_Context;
    private List<Home> homeList = new ArrayList<>(  );

//    public HomeAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Home> list){
public HomeAdapter(Context context, ArrayList<Home> list){
        super(context, 0 , list);
        h_Context = context;
        homeList = list;

    }




    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem==null){
            listItem= LayoutInflater.from(h_Context).inflate( R.layout.list_item,parent,false );
        }


        Home home=homeList.get( position );
        ImageView imageView = (ImageView)listItem.findViewById( R.id.image_View_list );
        imageView.setImageResource( home.getImage() );

        TextView textViewTitle =(TextView)listItem.findViewById( R.id.textView_opt1 );
        textViewTitle.setText( home.getAddress() );
        TextView textViewIsbn = (TextView)listItem.findViewById( R.id.textView_opt2 );
        textViewIsbn .setText( home.getPrice());


        CheckBox checkBox = listItem.findViewById(R.id.checkboxlist);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent= new Intent(getContext(), CheckoutActivity.class );
//                intent.putExtra("price", homeList.get(position).getPrice() );
//                getContext().startActivity(intent);
//
//
              Intent intent= new Intent(getContext(), CheckoutActivity.class );
              Bundle bundle=new Bundle();
              bundle.putString("price",homeList.get(position).getPrice());
              intent.putExtras(bundle);
                getContext().startActivity(intent);



            }
        });

        return listItem;


    }


}
