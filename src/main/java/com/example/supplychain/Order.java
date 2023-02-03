package com.example.supplychain;

public class Order {
    public static boolean placeSingleOrder(Product product,String customerEmail){
        String orderQuery=String.format("insert into orders (quantity,customer_id,product_id,status) values (1,(select cid from customer where email = '%s'),%s,'ORDERED')",
                customerEmail,product.getId()
        );

        DatabaseConnection dbConn = new DatabaseConnection();
        if(dbConn.insertData(orderQuery)>=1){
            return true;
        }

        System.out.println(orderQuery);

        return false;
    }
}
