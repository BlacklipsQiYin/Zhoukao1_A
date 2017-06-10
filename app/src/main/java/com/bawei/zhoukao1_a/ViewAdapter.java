package com.bawei.zhoukao1_a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder>{

private Context rContext;
private List<Bean1> rList ;
private LayoutInflater inflater ;

public ViewAdapter(Context context, List<Bean1> list){

this.rContext = context;
this.rList = list ;
inflater = LayoutInflater.from(context);
}

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


View view = inflater.inflate(R.layout.item1, parent, false);

ViewHolder viewHolder = new ViewHolder(view);

return viewHolder;


}

@Override
public void onBindViewHolder(ViewHolder holder, final int position) {


holder.title1.setText(rList.get(position).getTitle());
holder.textView1.setText(rList.get(position).getText());


    //条目点击
    holder.imageView1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            listener.onItemClickListener(position,v);
        }
    });

    holder.textView1.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            listener.onItemLongClickListener(position,v);
            return true;
        }
    });


}



@Override
public int getItemCount() {
return rList.size();
}

class ViewHolder extends RecyclerView.ViewHolder {

    private TextView title1;
    private TextView textView1;
    private ImageView imageView1;

    public ViewHolder(View itemView) {
        super(itemView);

        title1 = (TextView) itemView.findViewById(R.id.title1);
        textView1 = (TextView) itemView.findViewById(R.id.textView1);
        imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);

    }
}


    //条目点击
    interface OnItemClickListener {

        void onItemClickListener(int position,View view);
        void onItemLongClickListener(int position,View view);
    }


    public OnItemClickListener listener ;



    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


}