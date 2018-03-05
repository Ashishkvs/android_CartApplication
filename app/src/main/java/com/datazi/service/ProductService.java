package com.datazi.service;

import android.util.Log;
import android.widget.Toast;

import com.datazi.cart.R;
import com.datazi.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 3/5/2018.
 */

public class ProductService {
   //private List<Product> productList;
   static List<Product> wishListProductList =new ArrayList<>();


    public List<Product> getAllProductList(){
        List<Product> productList;
        productList=new ArrayList<>();

        productList.add(new Product("Apple", R.drawable.apple,2.0d,1));
        productList.add(new Product("Dell", R.drawable.apple,10.0d,10));
        productList.add(new Product("Mac", R.drawable.apple,4.0d,31));
        productList.add(new Product("hp", R.drawable.apple,7.0d,11));

        return productList;
    }
    public List<Product> getAllCartProductList(){


        return  wishListProductList;

    }
    public boolean setWishListProduct(Product product){
        //if wishlist already conatin product don't add again
        if(wishListProductList.contains(product)){
            return false;
        }else{
        wishListProductList.add(product);
            return true;
        }

    }
    //get Total item int the list wishListProductList
    public int getTotalItem(){
        return wishListProductList.size();
    }
    //fetchprice of all item in the list wishListProductList
    public double getTotalprice(){
        double totalPrice=0.0d;

        for(Product product :wishListProductList){
            Log.i("product qty"+product.getQty(),"product price"+product.getPrice());
           totalPrice =  totalPrice + (product.getPrice()*product.getQty());
        }
        Log.i("Total price",": "+totalPrice);
        return totalPrice;
    }
}
