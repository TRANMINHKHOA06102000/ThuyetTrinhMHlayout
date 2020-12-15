package com.example.danhmucsanpham;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    MyAdapter adapter;
    ArrayList<BanHang> mangBanHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true); // hien thi nut back tren toolbar
        actionBar.setTitle("Danh mục sản phẩm");

        Anhxa();
        adapter = new MyAdapter(this, R.layout.row, mangBanHang);
        gridView.setAdapter(adapter);

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                xacnhanXoa(i);
                return false;
            }
        });
    }

    private void xacnhanXoa(final int position) {
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông Báo!");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Bạn có muốn xóa sản phẩm này không");
        alertDialog.setPositiveButton("có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mangBanHang.remove(position);
                adapter.notifyDataSetChanged();// cập nhật lại mảng
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
    private void Anhxa() {
        gridView = (GridView) findViewById(R.id.gridview);
        mangBanHang = new ArrayList<>();
        mangBanHang.add(new BanHang("Điện thoại Oppo A92 2020 (8G/120GB)", "5.490.000 đ", "21%", R.drawable.dt1));
        mangBanHang.add(new BanHang("Điện thoại Galaxy Samsung M31", "4.699.000 đ", "20%", R.drawable.dt2));
        mangBanHang.add(new BanHang("Điện thoại Oppo A67 2020 (8G/120GB)", "5.490.000 đ", "11%", R.drawable.dt3));
        mangBanHang.add(new BanHang("Điện thoại Oppo A92 2020 (8G/120GB)", "4.490.000 đ", "18%", R.drawable.dt4));
        mangBanHang.add(new BanHang("Điện thoại Oppo A53 2020 (4G/128GB)", "4.490.000 đ", "11%", R.drawable.dt5));
    }
    // bắt sựu kiện cho các nút trên thanh toolbar

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // nút back
                onBackPressed();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}