package com.bawei.zhoukao1_a;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class View2Adapter extends RecyclerView.Adapter<View2Adapter.ViewHolder>{

private Context rContext;
private List<Bean1> rList ;

public View2Adapter(Context context, List<Bean1> list){

this.rContext = context;
this.rList = list ;

}

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


View view = View.inflate(rContext, R.layout.item2, null);

ViewHolder viewHolder = new ViewHolder(view);

return viewHolder;


}

@Override
public void onBindViewHolder(ViewHolder holder, int position) {



    //瀑布流改变高度
    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) holder.title2.getLayoutParams();
        Random random = new Random();
        params.height = random.nextInt(300);
        holder.title2.setLayoutParams(params);

//        if(position % 2 == 0){
//            holder.title2.setBackgroundColor(Color.GRAY);
//        } else{
//            holder.title2.setBackgroundColor(Color.BLUE);
//        }


    holder.title2.setText(rList.get(position).getTitle());


}



@Override
public int getItemCount() {
return rList.size();
}

class ViewHolder extends RecyclerView.ViewHolder {

    private TextView title2;
    private ImageView imageView2;

    public ViewHolder(View itemView) {
        super(itemView);

        title2 = (TextView) itemView.findViewById(R.id.title2);
        imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);

    }
}
}