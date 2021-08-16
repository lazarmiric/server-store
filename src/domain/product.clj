(ns domain.product
    (:require [schema.core :as sch]
              [korma.core :refer :all]
              [korma.db :refer :all]
              [database.database :refer [db]]
              [domain.product_detail :refer :all]
              [ring.swagger.schema :refer [coerce!]]))

            (defentity product_detail)
              (defentity product
                (pk :ProductID)
                (belongs-to product_detail)) 

  (sch/defschema Product {
    :ProductID               Integer
    :ProductName             String
    :ProductType             String
    :ProductDetailID         Integer
    :Price                   Double
  })

  (sch/defschema ProductWithDetail {
    :ProductID               Integer
    :ProductName             String
    :ProductType             String
    :Price                   Double
    :Brand                   String
    :CountryOfOrigin         String
  })

  (sch/defschema UpdateProduct
    {
     :Price Double
     })
  


  
  (sch/defschema NewProduct (dissoc Product :ProductID))