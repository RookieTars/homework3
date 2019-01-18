package com.example.tarsvillager.book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private List<Book>bookList=new ArrayList<>();
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initBook();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.book_name);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final BookAdapter adapter=new BookAdapter(bookList);
        recyclerView.setAdapter(adapter);
        Button button2=(Button)findViewById(R.id.plus_button);
        editText=(EditText)findViewById(R.id.edit_text);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.plus_button:
                        String inputText=editText.getText().toString();
                        adapter.addNewItem(inputText);

                        break;
                     default:
                         break;
                }
            }
        });

    }

    private void initBook(){
        Book book1=new Book("《人间失格》");
        bookList.add(book1);
        Book book2=new Book("《活着》");
        bookList.add(book2);
        Book book3=new Book("《艾莉诺好极了》");
        bookList.add(book3);
        Book book4=new Book("《追风筝的人》");
        bookList.add(book4);
        Book book5=new Book("《月亮与六便士》");
        bookList.add(book5);
        Book book6=new Book("《三体》");
        bookList.add(book6);
        Book book7=new Book("《围城》");
        bookList.add(book7);
        Book book8=new Book("《小王子》");
        bookList.add(book8);
        Book book9=new Book("《不能承受的生命之轻》");
        bookList.add(book9);
        Book book10=new Book("《高兴死了！！！》");
        bookList.add(book10);
    }
    private  void addBook(String bookName){
        Book newBook=new Book(bookName);
        bookList.add(newBook);
    }
}
