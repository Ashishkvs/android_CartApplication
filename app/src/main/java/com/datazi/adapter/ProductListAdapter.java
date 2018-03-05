package com.datazi.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.datazi.cart.R;
import com.datazi.model.Product;
import com.datazi.service.ProductService;

import java.util.List;

/**
 * Created by Ashish on 3/5/2018.
 */

public class ProductListAdapter extends BaseAdapter{
    private Context context;
    private List<Product> productList;

    //ViewHolder object

    private ImageView productImage;
    private TextView productName;
    private TextView productPrice;
    private TextView productQuantity;
    private Button wishlistButton;

    //to add to wishlist
    private ProductService productService=new ProductService();

    //param cons for passing context and productList
   public ProductListAdapter(Context context,List<Product> productList) {
        this.context=context;
        this.productList=productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(R.layout.product_layout,null);
        //attach view holder using id
        productImage=view.findViewById(R.id.productImage);
        productName=view.findViewById(R.id.productName);
        productQuantity=view.findViewById(R.id.productQuantity);
        productPrice=view.findViewById(R.id.productPrice);
        wishlistButton=view.findViewById(R.id.addToWishListbutton);


        //set resource
        final Product product=productList.get(position);
        productName.setText(product.getName().toString());
        productImage.setImageResource(product.getImage());
        productQuantity.setText(String.valueOf(product.getQty()));

        productPrice.setText(String.valueOf(product.getPrice()));
        //on wishlistButton click set resource
        wishlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String status= addToWishList(product);
                Toast.makeText(context,product.getName()+" "+status,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
//this mehtod will called onclick add to wishList button
    public String addToWishList(Product product){
        if(productService.setWishListProduct(product)){
            return "Has been added";
        }else{

            return "Already in the cart";
        }
    }
}
