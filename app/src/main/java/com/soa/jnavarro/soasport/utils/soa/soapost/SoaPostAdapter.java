package com.soa.jnavarro.soasport.utils.soa.soapost;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soa.jnavarro.soasport.R;

import java.util.List;

public class SoaPostAdapter extends RecyclerView.Adapter<SoaPostAdapter.SoaPostViewHolder> {
    class SoaPostViewHolder extends RecyclerView.ViewHolder{

        TextView mtextViewShortDesc;
        TextView mtextViewTitle;
        TextView mtextViewRating;
        TextView mtextViewAlt;

        public SoaPostViewHolder(View itemView) {
            super(itemView);
            mtextViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            mtextViewTitle = itemView.findViewById(R.id.textViewTitle);
            mtextViewRating = itemView.findViewById(R.id.textViewRating);
            mtextViewAlt = itemView.findViewById(R.id.textViewAlt);
        }
    }

    private Context mContext;
    private List<SoaPost> mSoaPostList;

    //getting the context and product list with constructor
    public SoaPostAdapter(Context mCtx, List<SoaPost> productList) {
        this.mContext = mCtx;
        this.mSoaPostList = productList;
    }


    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public SoaPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        View view = inflater.inflate(R.layout.list_layout,null);
        SoaPostViewHolder holder = new SoaPostViewHolder(view);
        return holder;
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull SoaPostViewHolder holder, int position) {
        SoaPost soapost = this.mSoaPostList.get(position);
        holder.mtextViewTitle.setText(soapost.getmTitle());
        holder.mtextViewAlt.setText(soapost.getmTitle());
        holder.mtextViewRating.setText(soapost.getmRating());
        holder.mtextViewShortDesc.setText(soapost.getmDescription());
    }

    /**
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return this.mSoaPostList.size();
    }
}
