package com.datazi.cart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.datazi.adapter.ProductListAdapter;
import com.datazi.model.Product;
import com.datazi.service.ProductService;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //private Button addToWishlistButton;
    ListView productListView;
    ProductService productService=new ProductService();
    private List<Product> allProductList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productListView=findViewById(R.id.productListView);
        allProductList=productService.getAllProductList();
        ProductListAdapter productListAdapter=new ProductListAdapter(this,allProductList);
        productListView.setAdapter(productListAdapter);

        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               /* Product product=allProductList.get(i);
                productService.setWishListProduct(product);*/
                Toast.makeText(MainActivity.this,"Helllo "+i,Toast.LENGTH_SHORT).show();
            }
        });

    }
    //Temproaray view
    public void showWishlist(View view){
        Intent intent=new Intent(this,WishlistActivity.class);
        startActivity(intent);
    }


}
