
(ns handler.handler
    (:require [compojure.api.sweet :refer :all]
              [ring.util.http-response :refer :all]
              [queries.query :as query]
              [schema.core :as schema]
              [domain.customer :refer :all]
              [domain.orders :refer :all]
              [domain.product :refer :all]
              [domain.product_detail :refer :all]))
  (def auth)



(def app
    (api 
      {
        :swagger {
          :ui "/"
          :spec "/swagger.json"
          :data {
            :info { :title "Store" :description "CRUD Application"}
            :tags [
              {:name "customer", :description "Customer endpoint"},
              {:name "product", :description "Product endpoint"},
              {:name "orders", :description "Order endpoint"}
            ]
          }
        }
      }

        
  (context "/customer" []
    :tags ["customer"]

    (GET "/" []
      :return [Customer]
      :summary "Get all customers"
      (ok (query/get-customers)))
    

    (GET "/:id" []
      :path-params [id :- schema/Num]
      :summary "Get customer by id."
      (def customerByID (query/get-customer id))
      (if customerByID (ok customerByID) (not-found,"Customer_does_not_exist!") )
    )

    (POST "/" []
      :summary "Add new customer."
      :body [addedCustomer NewCustomer]
      (def addRes (query/add-customer addedCustomer))
      (if (= (type addRes) java.lang.String) 
        (bad-request addRes)
        (ok addRes) 
      )
    )

    (DELETE "/:id" []
      :summary "Delete customer."
      :path-params [id :- schema/Num]
      (def deletedCustomer (query/delete-customer id))
      (if (= (type deletedCustomer) java.lang.String) 
        (bad-request deletedCustomer)
        (ok nil) 
      )
    )



  
  )

  (context "/product" []
    :tags ["product"]

    (GET "/:id" []
      :path-params [id :- schema/Num]
      :summary "Get product by id."
      (def productByID (query/get-product id))
      (if productByID (ok productByID) (not-found,"Product_does_not_exist!") )
    )

    (GET "/" []
      :return [ProductWithDetail]
      :summary "Get all products"
      (ok (query/get-products)))

    (PUT "/:id" []
      :summary "Update product price."
      :path-params [id :- schema/Num]
      :body [updatedProduct UpdateProduct]
      (def updateRes (query/update-product id updatedProduct))
      (def getProductByID (query/get-product id))
      (if (= (type updateRes) java.lang.Integer) 
        (ok {:NewProduct getProductByID}) 
        (bad-request updateRes)
      )
    )

    (DELETE "/:id" []
      :summary "Delete product."
      :path-params [id :- schema/Num]
      (def deletedProduct (query/delete-product id))
      (if (= (type deletedProduct) java.lang.String) 
        (bad-request deletedProduct)
        (ok nil) 
      )
    )


  )

  (context "/order" []
    :tags ["orders"]
  
  
  (GET "/:id" []
    :path-params [id :- schema/Num]
    :summary "Get order by id."
    (def orderByID (query/get-order id))
    (if orderByID (ok orderByID) (not-found,"Order_does_not_exist!") )
  )


  (POST "/" []
    :summary "Create new order."
    :body [newOrder NewOrder]
    (def addOrder (query/add-order newOrder))
    (if (= (type addOrder) java.lang.String) 
      (bad-request addOrder)
      (ok addOrder) 
    )
  )

  (DELETE "/:id" []
    :summary "Delete order."
    :path-params [id :- schema/Num]
    (def deletedOrder (query/delete-order id))
    (if (= (type deletedOrder) java.lang.String) 
      (bad-request deletedOrder)
      (ok nil) 
    )
  )

  
  )



  

  
  
  ))