package com.datazi.cart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.datazi.adapter.ProductListAdapter;
import com.datazi.service.ProductService;

public class WishlistActivity extends AppCompatActivity {

    public ListView wishListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        wishListView=findViewById(R.id.wishListView);
        ProductListAdapter cartListAdapter=new ProductListAdapter(this, new ProductService().getAllCartProductList());

        wishListView.setAdapter(cartListAdapter);

        //
        TextView totalItem=findViewById(R.id.totalItem);
        TextView totalPrice=findViewById(R.id.totalPrice);
        ProductService productService=new ProductService();
        totalItem.setText("Total Item : "+productService.getTotalItem());
        Log.i("WishlistActivty"," "+productService.getTotalprice());
        totalPrice.setText("Total Price: "+productService.getTotalprice());

    }
}
