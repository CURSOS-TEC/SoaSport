package com.soa.jnavarro.soasport.utils.soa.soapost;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.soa.jnavarro.soasport.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SoaPostAdapter extends RecyclerView.Adapter<SoaPostAdapter.SoaPostViewHolder> {
    class SoaPostViewHolder extends RecyclerView.ViewHolder{

        TextView mtextViewShortDesc;
        TextView mtextViewTitle;
        TextView mtextViewRating;
        TextView mtextViewAlt;
        ImageView mImageView;

        public SoaPostViewHolder(View itemView) {
            super(itemView);
            mtextViewShortDesc = itemView.findViewById(R.id.textViewDescription);
            mtextViewTitle = itemView.findViewById(R.id.textViewTitle);
            mtextViewRating = itemView.findViewById(R.id.textViewRating);
            mtextViewAlt = itemView.findViewById(R.id.textViewRating);
            mImageView = itemView.findViewById(R.id.imageViewThumbnail);

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
        View view = inflater.inflate(R.layout.soa_post,null);
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
        holder.mtextViewAlt.setText(soapost.getmAuthor());
        holder.mtextViewRating.setText(soapost.getmRating());
        holder.mtextViewShortDesc.setText(soapost.getmDescription());
        loadImageFromURL(mContext,holder.mImageView,soapost.getmURImage());


    }

    /**
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return this.mSoaPostList.size();
    }



    public void loadImageFromURL(Context context, ImageView imageView, String  URL){
        Picasso.with(context).load(URL).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView,new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
