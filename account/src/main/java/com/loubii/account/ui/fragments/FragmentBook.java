package com.loubii.account.ui.fragments;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.loubii.account.R;
import com.loubii.account.adapter.BaseRecycleAdapter;
import com.loubii.account.adapter.BookAdapter;
import com.loubii.account.bean.BookBean;
import com.loubii.account.constants.Extra;
import com.loubii.account.ui.book.BookAddActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class FragmentBook extends BaseEventFragment{

    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.ll_add_book)
    LinearLayout mLlAddDeposit;
    //    @BindView(R.id.ll_add_credit)
//    LinearLayout mLlAddCredit;
    @BindView(R.id.rv_book)
    RecyclerView mRvBook;
    private String mParam1;
    private String mBookType;
    private ArrayList<BookBean> mBookList;
    private BookAdapter mAdapter;
    
    
    
    
    @BindView(R.id.ll_add_deposit)
    LinearLayout mLlAddBook;

    private void setListener() {
        mAdapter.setOnItemClickListener(new BaseRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position == mBookList.size() - 1) { //添加账本
                    Intent intent = new Intent(getActivity(), BookAddActivity.class);
                    intent.putExtra(Extra.BOOK_ADD, position);
                    startActivity(intent);
                }
                else {
                    //更改到账单页面且载入该账本的账单
                    Intent intent = new Intent(getActivity(), FragmentBill.class);
                    intent.putExtra(Extra.BOOK_ID,mBookList.get(position).getBookId());
                    startActivity(intent);
                }
            }
        });
    }

    private void initRecycleView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        mRvBook.setLayoutManager(linearLayoutManager);
        mAdapter = new BookAdapter(context, getBookData());
        mRvBook.setAdapter(mAdapter);
    }

    private List<BookBean> getBookData() {
        mBookList = new ArrayList<>();
        BookBean bookBean = new BookBean();
        mBookList.add(bookBean);
        return mBookList;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
