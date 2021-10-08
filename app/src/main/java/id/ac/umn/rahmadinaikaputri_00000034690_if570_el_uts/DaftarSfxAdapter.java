package id.ac.umn.rahmadinaikaputri_00000034690_if570_el_uts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;

public class DaftarSfxAdapter extends RecyclerView.Adapter<DaftarSfxAdapter.ItemViewHolder>{
    private LinkedList<DaftarSfx> mListSfx;
    private Context mContext;
    Activity mActivity;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sfx_list, parent, false);
        ItemViewHolder ivh = new ItemViewHolder(v, this);
        return ivh;
    }

    public DaftarSfxAdapter(Context context, Activity activity,LinkedList<DaftarSfx> sfxList){
        this.mActivity = activity;
        this.mContext = context;
        mListSfx = sfxList;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        DaftarSfx currentSfx = mListSfx.get(position);
        holder.mJudulSfx.setText(currentSfx.getJudulSfx());
        holder.mKeteranganSfx.setText(currentSfx.getKeteranganSfx());
    }

    @Override
    public int getItemCount() {
        return mListSfx.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        private DaftarSfxAdapter mAdapter;
        private DaftarSfx mDaftarSfx;
        private TextView mJudulSfx, mKeteranganSfx;
        private int mPosisi;
        private ImageButton mDeleteBtn;

        public ItemViewHolder(View itemView, DaftarSfxAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            mJudulSfx = (TextView) itemView.findViewById(R.id.tvJudulSfx);
            mKeteranganSfx = (TextView) itemView.findViewById(R.id.tvKeteranganSfx);
            mDeleteBtn = (ImageButton) itemView.findViewById(R.id.btnDelete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPosisi = getLayoutPosition();
                    mDaftarSfx = mListSfx.get(mPosisi);
                    Intent detailIntent = new Intent(mContext, DetailSfxActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("DetailSfx", mDaftarSfx);
                    detailIntent.putExtras(bundle);
                    mContext.startActivity(detailIntent);
                    mActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            });

            mDeleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPosisi = getLayoutPosition();
                    mListSfx.remove(mPosisi);
                    mAdapter.notifyItemRemoved(mPosisi);
                }
            });
        }
    }
}
