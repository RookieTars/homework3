package com.example.tarsvillager.book;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book>mBookList;
    private int color[]={0X4EEE94C8,0X00BFFFC8,0X6A5AFFC8};
    static int colorNum=0;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView bookName;

        public ViewHolder(View view){
            super(view);
            bookName=(TextView)view.findViewById(R.id.book_name);
        }
    }
    public BookAdapter(List<Book>bookList){
        mBookList=bookList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Book book=mBookList.get(position);
        holder.bookName.setText(book.getName());
        holder.bookName.setBackgroundColor(color[(colorNum++)%3]);
    }
    @Override
    public int getItemCount(){
        return mBookList.size();
    }
    public void addNewItem(String name){
        mBookList.add(0,new Book(name));
        notifyItemInserted(0);
    }
}
