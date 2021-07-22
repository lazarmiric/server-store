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

  ; Product 

  (defentity product)

    (defn get-product [ProductID]
         (first
          (select product
            (where {:ProductID [= ProductID]} )
              (limit 1))))




  