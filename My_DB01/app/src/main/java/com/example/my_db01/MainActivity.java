package com.example.my_db01;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    TextView textView;

    DatabaseHelper dbHelper;
    SQLiteDatabase database;

    String tableName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String databaseName = editText.getText().toString();
                createDatabase(databaseName);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableName = editText2.getText().toString();
                createTable(tableName);

                insertRecord();
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeQuery();
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData("노규선");
            }
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectData();
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });

    }

    private void createDatabase(String name) {
        println("createDatabase 호출됨.");

        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase();

        println("데이터베이스 생성함 : " + name);
    }

    private void createTable(String name) {
        println("createTable 호출됨.");

        if (database == null) {
            println("데이터베이스를 먼저 생성하세요.");
            return;
        }

        database.execSQL("create table if not exists " + name + "("
            + " _id integer PRIMARY KEY autoincrement, "
            + " name text, "
            + " age integer, "
            + " mobile text)");

        println("테이블 생성함 : " + name);
    }

    private void insertRecord() {
        println("insertRecord 호출됨.");

        if (database == null) {
            println("데이터베이스를 먼저 생성하세요.");
            return;
        }

        if (tableName == null) {
            println("테이블을 먼저 생성하세요.");
            return;
        }

        database.execSQL("insert into " + tableName
                        + "(name, age, mobile) "
                        + " values "
                        + "('John', 20, '010-1000-1000')");

        println("레코드 추가함.");
    }

    // add ngs

    private void insertData(String name) {
        println("insertData 호출됨.");

        dbHelper.getWritableDatabase();
        database.execSQL("INSERT INTO Data(name) VALUES(?)",
                new String[]{name});

        database.close();
    }

    private ArrayList<String> selectData() {
        ArrayList<String> list = new ArrayList<>();

        dbHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM Data", null);

        while (cursor.moveToNext()) {
            list.add(cursor.getString(1));
        }

        cursor.close();
        database.close();

        return list;
    }

    private void deleteData() {
        println("deleteRecord 호출됨.");

        if (database == null) {
            println("데이터베이스를 먼저 생성하세요.");
            return;
        }

        if (tableName == null) {
            println("테이블을 먼저 생성하세요.");
            return;
        }

        database.execSQL("DELETE FROM " + tableName + " WHERE colum = '1'");

        println("레코드 삭제함.");
    }

    private void updateData() {
        println("updateRecord 호출됨.");

        if (database == null) {
            println("데이터베이스를 먼저 생성하세요.");
            return;
        }

        if (tableName == null) {
            println("테이블을 먼저 생성하세요.");
            return;
        }

        database.execSQL("UPDATE tableName SET name ='se"+"' WHERE name='John'");

        println("레코드 수정함.");
    }

    public void println(String data) {
        textView.append(data + "\n");
    }

    public void executeQuery() {
        println("executeQuery 호출됨.");

        Cursor cursor = database.rawQuery("select _id, name, age, mobile from emp", null);
        int recordCount = cursor.getCount();
        println("레코드 개수 : " + recordCount);

        for (int i = 0; i < recordCount; i++) {
            cursor.moveToNext();

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String mobile = cursor.getString(3);

            println("레코드 #" + i + " : " + id + ", " + name + ", " + age + ", " + mobile);
        }

        cursor.close();
    }

}
