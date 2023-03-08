package com.loubii.account.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.loubii.account.R;
import com.loubii.account.bean.BookBean;
import com.loubii.account.constants.CardRes;
import com.loubii.account.constants.Extra;
import com.loubii.account.ui.card.CardRemindActivity;
import com.loubii.account.ui.card.TransferActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookAdapter extends BaseRecycleAdapter {

    private static final int TYPE_END = 1;
    private static final int TYPE_ITEM = 0;
    private static int TYPE = TYPE_ITEM;
    private final List<BookBean> mList;

    private Context context;


    public BookAdapter(Context context, List<BookBean> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        super.onBindViewHolder(holder, position);
        switch (getItemViewType(position)) {
            case TYPE_END:
                EndHoleder endHoleder = (EndHoleder) holder;
                //endHoleder.tvRemark.setTextColor(context.getResources().getColor(R.color.color_dash));
                break;
            case TYPE_ITEM:
                CardAdapter.ItemHoleder itemHoleder = (CardAdapter.ItemHoleder) holder;
                if (position == 0) {
                    itemHoleder.mTvTransfer.setText("换卡");
                    itemHoleder.mIvAlarm.setVisibility(View.GONE);
                }
                itemHoleder.mTvBandcardName.setText(mList.get(position).getBookName());
                itemHoleder.itemView.setBackgroundResource(CardRes.getCardBg(mList.get(position).getBookName()));
                itemHoleder.mTvTransfer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, TransferActivity.class);
                        intent.putExtra(Extra.CARD_ID, mList.get(position).getBookId());
                        context.startActivity(intent);
                    }
                });
                itemHoleder.mIvAlarm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, CardRemindActivity.class);
                        intent.putExtra(Extra.CARD_REMIND_START_TYPE, "FragmentCard");
                        intent.putExtra(Extra.CARD_ID, mList.get(position).getBookId());
                        context.startActivity(intent);
                    }
                });
                //itemHoleder.tvRemark.setSelected(mList.get(position).isChecked());
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mList.size() - 1)
            TYPE = TYPE_END;
        else
            //此处应改为else if 然后判断position
            TYPE = TYPE_ITEM;
        return TYPE;
    }

    public

    class ItemHoleder extends RecyclerView.ViewHolder {

        /**
         * 以下是需要的xml文件中账本界面的图标或信息
         */
        @BindView(R.id.iv_bandcard)
        ImageView mIvBandcard;
        @BindView(R.id.tv_bandcard_name)
        TextView mTvBandcardName;
        @BindView(R.id.tv_bandcard_type)
        TextView mTvBandcardType;
        @BindView(R.id.tv_bandcard_id)
        TextView mTvBandcardId;
        @BindView(R.id.tv_transfer)
        TextView mTvTransfer;
        @BindView(R.id.iv_alarm)
        ImageView mIvAlarm;

        public ItemHoleder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            //tv = (TextView) itemView.findViewById(R.id.tv_bandcard_name);
        }
    }

    class EndHoleder extends RecyclerView.ViewHolder{
        public EndHoleder(View itemview){
            super(itemview);
        }
    }

    public static void add(BookBean bookData){
        /*if (mList == null) {
            mList = new List<BookBean>();
        }*/
        mList.add(bookData);
        notifyDataSetChanged();
    }
}
