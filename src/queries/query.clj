(ns queries.query
    (:require [connection.mysqlconnection]
              [korma.core :refer :all]
              [korma.db :refer :all]
              [schema.core :as schema]
              [domain.customer :refer :all]
              [domain.orders :refer :all]
              [domain.product :refer :all]
              [domain.product_detail :refer :all])
    (:import (java.security MessageDigest)))


    ; Customer

    (defentity customer)

    (defn get-customers[]
        (select customer))

    (defn get-customer[CustomerID]
       (first
          (select customer
            (where {:CustomerID [= CustomerID]} )
             (limit 1))))

   (defn add-customer [NewCustomer]
                  ((def newCustomer (insert customer
                    (values {
                      :Name (get NewCustomer :Name)
                      :LastName (get NewCustomer :LastName)
                      :City (get NewCustomer :City)
                      })
                    ))
                    (def newCustomerID (get newCustomer :generated_key))
                    (get-customer newCustomerID)
                  )
                )

    (defn delete-customer[CustomerID]
        (def customerByID (get-customer CustomerID))
            (if customerByID (delete customer            
            (where {:CustomerID [= CustomerID]}))                  
        "Customer does not exist!"
      )
    )


  ; Product 
 ; (defentity product)

  ;(defentity product_detail)

    (defn get-product [ProductID]
         (first
          (select product
            (where {:ProductID [= ProductID]} )
              (limit 1))))


   (defn get-products []
    (select product
        (fields :product.ProductID :product.ProductName :product.ProductType :product.Price :product_detail.Brand :product_detail.CountryOfOrigin)
        (join product_detail (= :product_detail.ProductDetailID :ProductDetailID))
        )
    )

                      

   (defn update-product [ProductID updatedProduct]
        (def productByID (get-product ProductID))
                (if productByID (update product
                      (set-fields {
                        :Price (get updatedProduct :Price)
                      })
                      (where {:ProductID [= ProductID]}))                  
                  "Product does not exist!"
                )
              )


  ; Orders 

  (defentity orders)

              (defn get-order [OrderID]
                  (first
                     (select orders
                       (where {:OrderID [= OrderID]} )
                        (limit 1))))
      
              
      
                      (defn add-order [NewOrder]
                          (def customerExist (get-customer (get NewOrder :CustomerID)))
                          (def productExist (get-product (get NewOrder :ProductID)))
                            (if customerExist (
                              if productExist ((def newOrder(insert orders
                                    (values {
                                      :TotalPayment (get NewOrder :TotalPayment)
                                      :CustomerID (get NewOrder :CustomerID)
                                      :ProductID (get NewOrder :ProductID)
                                      :TotalOrderOfSameProduct (get NewOrder :TotalOrderOfSameProduct)
                                    })
                                  ))
                                  (def newOrderID (get newOrder :generated_key))
                                  (get-order newOrderID)
                                )    
                                "Product does not exist!"   
                            )                
                          "Customer does not exist!"
                          )
                      )


                      (defn delete-order[OrderID]
                        (def orderByID (get-order OrderID))
                            (if orderByID (delete orders            
                            (where {:OrderID [= OrderID]}))                  
                        "Order does not exist!"
                      )
                    )
      

       